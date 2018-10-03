package oriolvillaret.com.api_connection_lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import oriolvillaret.com.api_connection_lib.model.PagerGamesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpeedrunApi {

    private static final String BASE_URL = "https://www.speedrun.com/";

    // Singleton instance.
    private static SpeedrunApi _instance;

    private Retrofit retrofit;

    public static SpeedrunApi getInstance() {
        if (_instance == null) {
            _instance = new SpeedrunApi();
        }
        return _instance;
    }

    private SpeedrunApi() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void getGames(final SpeedrunApiResponse<PagerGamesResponse> callback) {
        SpeedrunService service = retrofit.create(SpeedrunService.class);
        Call<PagerGamesResponse> repos = service.getGames();
        repos.enqueue(new Callback<PagerGamesResponse>() {
            @Override
            public void onResponse(Call<PagerGamesResponse> call, Response<PagerGamesResponse> response) {
                callback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<PagerGamesResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public interface SpeedrunApiResponse<T> {
        void onResponse(T response);

        void onFailure(Throwable t);
    }
}
