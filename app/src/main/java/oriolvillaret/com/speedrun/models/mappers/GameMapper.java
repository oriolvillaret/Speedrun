package oriolvillaret.com.speedrun.models.mappers;

import java.util.ArrayList;
import java.util.List;

import oriolvillaret.com.speedrun.models.Game;

public class GameMapper {

    public static Game fromApi(oriolvillaret.com.api_connection_lib.models.Game game) {
        Game res = new Game();

        res.setId(game.id);
        res.setName(game.names.international);
        res.setLogoURL(game.assets.icon.uri);

        return res;
    }

    public static List<Game> fromApi(List<oriolvillaret.com.api_connection_lib.models.Game> games) {
        ArrayList res = new ArrayList();
        for (oriolvillaret.com.api_connection_lib.models.Game game: games){
            res.add(fromApi(game));
        }
        return res;
    }
}
