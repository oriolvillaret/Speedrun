package oriolvillaret.com.speedrun.controller;

import org.greenrobot.eventbus.EventBus;

import oriolvillaret.com.api_connection_lib.SpeedrunApi;
import oriolvillaret.com.api_connection_lib.model.PagerGamesResponse;
import oriolvillaret.com.speedrun.model.GameMapper;

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
}
