package oriolvillaret.com.api_connection_lib;

import oriolvillaret.com.api_connection_lib.models.PagerGamesResponse;
import oriolvillaret.com.api_connection_lib.models.PagerRecordsResponse;
import oriolvillaret.com.api_connection_lib.models.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpeedrunService {
    @GET("/api/v1/games")
    Call<PagerGamesResponse> getGames();

    @GET("api/v1/games/{gameid}/records")
    Call<PagerRecordsResponse> getListRepos(@Path("gameid") String gameid);

    @GET("api/v1/users/{userid}")
    Call<UserResponse> getUser(@Path("userid") String userid);

}
