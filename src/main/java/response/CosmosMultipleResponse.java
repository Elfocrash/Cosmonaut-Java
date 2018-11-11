package response;

import java.util.ArrayList;
import java.util.List;

public class CosmosMultipleResponse<TEntity> {


    List<CosmosResponse<TEntity>> failedEntities = new ArrayList<>();

    List<CosmosResponse<TEntity>> successfulEntities = new ArrayList<>();

    private final CosmosOperationStatus _operationStatus = CosmosOperationStatus.SUCCESS;

    void addResponse(CosmosResponse<TEntity> response)
    {
        if (response == null)
            return;

        if (response.isSuccess())
        {
            successfulEntities.add(response);
            return;
        }

        failedEntities.add(response);
    }

    public boolean isSuccess(){
        return _operationStatus == CosmosOperationStatus.SUCCESS;
    }

    public List<CosmosResponse<TEntity>> getFailedEntities() {
        return failedEntities;
    }

    public List<CosmosResponse<TEntity>> getSuccessfulEntities() {
        return successfulEntities;
    }
}
