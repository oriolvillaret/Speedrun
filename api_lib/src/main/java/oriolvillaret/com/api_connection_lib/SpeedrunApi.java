package oriolvillaret.com.api_connection_lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import oriolvillaret.com.api_connection_lib.models.PagerGamesResponse;
import oriolvillaret.com.api_connection_lib.models.PagerRecordsResponse;
import oriolvillaret.com.api_connection_lib.models.UserResponse;
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

    public void getRecords(String gameId, final SpeedrunApiResponse<PagerRecordsResponse> callback) {
        SpeedrunService service = retrofit.create(SpeedrunService.class);
        Call<PagerRecordsResponse> records = service.getListRepos(gameId);
        records.enqueue(new Callback<PagerRecordsResponse>() {
            @Override
            public void onResponse(Call<PagerRecordsResponse> call, Response<PagerRecordsResponse> response) {
                callback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<PagerRecordsResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getUser(String userId, final SpeedrunApiResponse<UserResponse> callback) {
        SpeedrunService service = retrofit.create(SpeedrunService.class);
        Call<UserResponse> user = service.getUser(userId);
        user.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                callback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public interface SpeedrunApiResponse<T> {
        void onResponse(T response);

        void onFailure(Throwable t);
    }
}
