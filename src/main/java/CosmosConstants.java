import com.microsoft.azure.documentdb.*;

public class CosmosConstants {
    public static final String COSMOS_ID = "id";
    public static final int MINIMUM_COSMOS_THROUGHPUT = 400;
    public static final int DEFAULT_MAXIMUM_UPSCALE_THROUGHPUT = 10000;
    public static final int TooManyRequestsStatusCode = 429;

    public static final IndexingPolicy DEFAULT_INDEXING_POLICY = new IndexingPolicy(
            new Index[]{
                    new RangeIndex(DataType.Number, -1)
                    , new RangeIndex(DataType.String, -1)
                    , new SpatialIndex(DataType.Point)}
             );
}

