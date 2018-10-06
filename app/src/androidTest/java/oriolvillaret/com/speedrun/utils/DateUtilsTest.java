package oriolvillaret.com.speedrun.utils;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DateUtilsTest {

    @Test
    public void formatTime() {
        Context context = InstrumentationRegistry.getTargetContext();

        Double lTest1 = new Double((1 * 24 * 60 * 60) + (3 * 60 * 60) + (4 * 60) + 5);
        String expected1 = "1d 3h 4m 5s";
        assertEquals(expected1, DateUtils.formatTime(context, lTest1));

        Double lTest2 = new Double((0 * 24 * 60 * 60) + (3 * 60 * 60) + (0 * 60) + 5);
        String expected2 = "3h 0m 5s";
        assertEquals(expected2, DateUtils.formatTime(context, lTest2));

        Double lTest3 = new Double((0 * 24 * 60 * 60) + (3 * 60 * 60) + (4 * 60) + 0);
        String expected3 = "3h 4m 0s";
        assertEquals(expected3, DateUtils.formatTime(context, lTest3));

        Double lTest4 = new Double((0 * 24 * 60 * 60) + (0 * 60 * 60) + (4 * 60) + 5);
        String expected4 = "4m 5s";
        assertEquals(expected4, DateUtils.formatTime(context, lTest4));

        Double lTest5 = new Double((0 * 24 * 60 * 60) + (0 * 60 * 60) + (0 * 60) + 5);
        String expected15 = "5s";
        assertEquals(expected15, DateUtils.formatTime(context, lTest5));

        Double lTest6 = new Double((0 * 24 * 60 * 60) + (0 * 60 * 60) + (0 * 60) + 0);
        String expected16 = "";
        assertEquals(expected16, DateUtils.formatTime(context, lTest6));

        Double lTest7 = new Double(-10);
        String expected17 = "";
        assertEquals(expected17, DateUtils.formatTime(context, lTest7));
    }
}