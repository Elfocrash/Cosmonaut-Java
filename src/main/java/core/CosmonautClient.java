package core;

import com.microsoft.azure.documentdb.DocumentClient;

public interface CosmonautClient {
    DocumentClient getDocumentClient();
}
