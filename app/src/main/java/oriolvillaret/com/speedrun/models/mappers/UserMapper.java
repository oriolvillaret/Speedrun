package oriolvillaret.com.speedrun.models.mappers;

import java.util.ArrayList;
import java.util.List;

import oriolvillaret.com.speedrun.models.User;

public class UserMapper {

    public static User fromApi(oriolvillaret.com.api_connection_lib.models.User user) {
        User res = new User();

        res.setId(user.id);
        if (user.names!=null) {
            res.setName(user.names.international);
        }

        return res;
    }

    public static List<User> fromApi(List<oriolvillaret.com.api_connection_lib.models.User> users) {
        ArrayList res = new ArrayList();
        for (oriolvillaret.com.api_connection_lib.models.User user: users){
            res.add(fromApi(user));
        }
        return res;
    }
}
