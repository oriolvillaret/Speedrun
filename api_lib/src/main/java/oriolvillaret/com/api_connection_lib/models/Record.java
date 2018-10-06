package oriolvillaret.com.api_connection_lib.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Record {
    @SerializedName("runs")
    public List<RunItemList> runs;

    public class RunItemList {
        @SerializedName("place")
        public Integer place;
        @SerializedName("run")
        public Run run;
    }
}
