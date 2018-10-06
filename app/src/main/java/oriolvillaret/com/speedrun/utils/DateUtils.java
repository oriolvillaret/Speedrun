package oriolvillaret.com.speedrun.utils;

import android.content.Context;

import oriolvillaret.com.speedrun.R;

public class DateUtils {
    public static String formatTime(Context context, Double time) {

        int seconds = (int) (time % 60);
        time = time / 60;
        int minutes = (int) (time % 60);
        time = time / 60;
        int hours = (int) (time % 24);
        int days = (int) (time / 24);

        String res = "";
        if (days > 0) {
            res = res + " " + days + context.getString(R.string.days);
        }
        if (hours > 0 || !res.isEmpty()) {
            res = res + " " + hours + context.getString(R.string.hours);
        }
        if (minutes > 0 || !res.isEmpty()) {
            res = res + " " + minutes + context.getString(R.string.minutes);
        }
        if (seconds > 0 || !res.isEmpty()) {
            res = res + " " + seconds + context.getString(R.string.seconds);
        }
        return res.trim();
    }
}
