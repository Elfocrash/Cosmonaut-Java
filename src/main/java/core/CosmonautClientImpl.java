package core;

import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.RetryOptions;

public class CosmonautClientImpl implements CosmonautClient {

    private final DocumentClient _documentClient;

    public CosmonautClientImpl(DocumentClient documentClient){
        this(documentClient, true);
    }

    public CosmonautClientImpl(DocumentClient documentClient, boolean infiniteRetrying){
        _documentClient = documentClient;
        if(infiniteRetrying){
            setInfiniteRetries();
        }
    }

    public CosmonautClientImpl(String serviceEndpoint, String authKey, ConnectionPolicy connectionPolicy, ConsistencyLevel consistencyLevel){
        _documentClient = new DocumentClient(serviceEndpoint, authKey, connectionPolicy, consistencyLevel);
    }

    public CosmonautClientImpl(String serviceEndpoint, String authKey){
        this(serviceEndpoint, authKey, ConnectionPolicy.GetDefault(), ConsistencyLevel.Session);
    }

    public CosmonautClientImpl(String serviceEndpoint, String authKey, ConnectionPolicy connectionPolicy, ConsistencyLevel consistencyLevel, boolean infiniteRetrying){
        _documentClient = new DocumentClient(serviceEndpoint, authKey, connectionPolicy, consistencyLevel);
        if(infiniteRetrying){
            setInfiniteRetries();
        }
    }

    public CosmonautClientImpl(String serviceEndpoint, String authKey, boolean infiniteRetrying){
        this(serviceEndpoint, authKey, ConnectionPolicy.GetDefault(), ConsistencyLevel.Session, infiniteRetrying);
    }

    @Override
    public DocumentClient getDocumentClient() {
        return _documentClient;
    }

    private void setInfiniteRetries(){
        RetryOptions retryOptions = _documentClient.getConnectionPolicy().getRetryOptions();
        retryOptions.setMaxRetryAttemptsOnThrottledRequests(Integer.MAX_VALUE);
        _documentClient.getConnectionPolicy().setRetryOptions(retryOptions);
    }
}
