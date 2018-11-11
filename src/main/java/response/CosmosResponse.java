package response;

import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.ResourceResponse;

public class CosmosResponse<TEntity> {

    CosmosOperationStatus cosmosOperationStatus = CosmosOperationStatus.SUCCESS;

    ResourceResponse<Document> resourceResponse;

    TEntity entity;

    public CosmosResponse(ResourceResponse<Document> resourceResponse)
    {
        this.resourceResponse = resourceResponse;
    }

    public CosmosResponse(TEntity entity, ResourceResponse<Document> resourceResponse)
    {
        this.resourceResponse = resourceResponse;
        this.entity = entity;
    }

    CosmosResponse(TEntity entity, CosmosOperationStatus statusType)
    {
        this.cosmosOperationStatus = statusType;
        this.entity = entity;
    }

    boolean isSuccess(){
        return (resourceResponse != null &&
                resourceResponse.getStatusCode() >= 200 && resourceResponse.getStatusCode() <= 299 &&
                cosmosOperationStatus == CosmosOperationStatus.SUCCESS ) ||
                (resourceResponse == null && cosmosOperationStatus == CosmosOperationStatus.SUCCESS);
    }

    public TEntity entity(){
        if (entity != null) {
            return entity;
        }

        //TODO: Check deserialization (toJson() or toString()?)
        String responseString = resourceResponse == null ? null : resourceResponse.getResource().toJson();

        if(responseString != null && !responseString.isEmpty()){
            //TODO: Add some way to convert from Json to TEntity
            return null;
        }

        return null;
    }

    public CosmosOperationStatus getCosmosOperationStatus() {
        return cosmosOperationStatus;
    }

    public ResourceResponse<Document> getResourceResponse() {
        return resourceResponse;
    }

    public TEntity getEntity() {
        return entity;
    }

    public void setEntity(TEntity entity) {
        this.entity = entity;
    }
}
