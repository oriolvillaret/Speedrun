package oriolvillaret.com.speedrun.controllers;

import org.greenrobot.eventbus.EventBus;

import oriolvillaret.com.api_connection_lib.SpeedrunApi;
import oriolvillaret.com.api_connection_lib.models.PagerGamesResponse;
import oriolvillaret.com.api_connection_lib.models.PagerRecordsResponse;
import oriolvillaret.com.api_connection_lib.models.UserResponse;
import oriolvillaret.com.speedrun.models.mappers.GameMapper;
import oriolvillaret.com.speedrun.models.mappers.RecordMapper;
import oriolvillaret.com.speedrun.models.mappers.UserMapper;

public class SpeedrunController {

    private static SpeedrunController _instance;

    public static SpeedrunController getInstance() {
        if (_instance == null) {
            _instance = new SpeedrunController();
        }
        return _instance;
    }

    public void getGames() {
        SpeedrunApi.getInstance().getGames(new SpeedrunApi.SpeedrunApiResponse<PagerGamesResponse>() {
            @Override
            public void onResponse(PagerGamesResponse response) {
                EventBus.getDefault().postSticky(GameMapper.fromApi(response.data));
            }

            @Override
            public void onFailure(Throwable t) {
                EventBus.getDefault().postSticky(t);
            }
        });
    }

    public void getRecords(String gameId) {
        SpeedrunApi.getInstance().getRecords(gameId, new SpeedrunApi.SpeedrunApiResponse<PagerRecordsResponse>() {
            @Override
            public void onResponse(PagerRecordsResponse response) {

                EventBus.getDefault().postSticky(RecordMapper.fromApi(response.data));
            }

            @Override
            public void onFailure(Throwable t) {
                EventBus.getDefault().postSticky(t);
            }
        });
    }

    public void getUser(String userId) {
        SpeedrunApi.getInstance().getUser(userId, new SpeedrunApi.SpeedrunApiResponse<UserResponse>() {
            @Override
            public void onResponse(UserResponse response) {
                EventBus.getDefault().postSticky(UserMapper.fromApi(response.data));
            }

            @Override
            public void onFailure(Throwable t) {
                EventBus.getDefault().postSticky(t);
            }
        });
    }
}
