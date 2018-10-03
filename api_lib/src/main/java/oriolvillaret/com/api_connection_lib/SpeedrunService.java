package oriolvillaret.com.api_connection_lib;

import oriolvillaret.com.api_connection_lib.model.PagerGamesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SpeedrunService {
    @GET("/api/v1/games")
    Call<PagerGamesResponse> getGames();

}
