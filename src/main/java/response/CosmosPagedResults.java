package response;

import java.util.List;

public class CosmosPagedResults<T> {
    CosmosPagedResults(List<T> results, int pageSize, String nextPageToken)
    {
        this.results = results;
        this.nextPageToken = nextPageToken;
        this.pageSize = pageSize;
    }

    int pageSize;

    public List<T> results;

    public String nextPageToken;

    public boolean hasNextPage(){
        return nextPageToken != null && !nextPageToken.isEmpty();
    }

//  Figure what to do with lack of queryable
//    public async Task<CosmosPagedResults<T>> GetNextPageAsync()
//    {
//        if(Queryable == null)
//            return new CosmosPagedResults<T>(new List<T>(), PageSize, String.Empty);
//
//        if(!HasNextPage)
//            return new CosmosPagedResults<T>(new List<T>(), PageSize, String.Empty);
//
//        if(PageSize <= 0)
//            return new CosmosPagedResults<T>(new List<T>(), PageSize, String.Empty);
//
//        return await Queryable.WithPagination(NextPageToken, PageSize).ToPagedListAsync();
//    }

    public List<T> results()
    {
        return results;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getResults() {
        return results;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }
}
