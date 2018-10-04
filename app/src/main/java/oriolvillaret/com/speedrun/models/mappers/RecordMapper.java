package oriolvillaret.com.speedrun.models.mappers;

import java.util.ArrayList;
import java.util.List;

import oriolvillaret.com.api_connection_lib.models.Run;
import oriolvillaret.com.speedrun.models.Record;
import oriolvillaret.com.speedrun.models.User;

public class RecordMapper {

    public static Record fromApi(oriolvillaret.com.api_connection_lib.models.Record record) {
        Record res = new Record();

        if (record.runs == null || record.runs.isEmpty()) {
            return null;
        }
        Run run = record.runs.get(0).run;
        if (run.videos.links!=null && !run.videos.links.isEmpty()){
            res.setVideoURL(run.videos.links.get(0).uri);
        }
        res.setTime(run.times.realtime_t);
        if (run.players!=null && !run.players.isEmpty()){
            User user = new User();
            user.setId(run.players.get(0).id);
            res.setUserFistPlace(user);
        }

        return res;
    }

    public static List<Record> fromApi(List<oriolvillaret.com.api_connection_lib.models.Record> records) {
        ArrayList res = new ArrayList();
        for (oriolvillaret.com.api_connection_lib.models.Record record : records) {
            res.add(fromApi(record));
        }
        return res;
    }
}
