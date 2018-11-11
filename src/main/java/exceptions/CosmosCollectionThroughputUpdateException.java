package exceptions;

import com.microsoft.azure.documentdb.DocumentCollection;

public class CosmosCollectionThroughputUpdateException extends Exception {

    public CosmosCollectionThroughputUpdateException(DocumentCollection documentCollection) {
        super(String.format("Failed to update hroughput of collection %s", documentCollection.getId()));
    }
}
