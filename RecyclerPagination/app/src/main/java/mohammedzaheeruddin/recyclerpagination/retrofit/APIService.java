package mohammedzaheeruddin.recyclerpagination.retrofit;

import mohammedzaheeruddin.recyclerpagination.entity.ApiData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public interface APIService {

    @GET("users")
    Call<ApiData> getData(@Query("page") int index, @Query("pagesize") int size,
                          @Query("order") String order, @Query("sort") String sort,
                          @Query("site") String site);
}
