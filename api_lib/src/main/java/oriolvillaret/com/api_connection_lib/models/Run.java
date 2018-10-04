package oriolvillaret.com.api_connection_lib.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Run {
    @SerializedName("id")
    public String id;
    @SerializedName("videos")
    public Videos videos;
    @SerializedName("players")
    public List<User> players;
    @SerializedName("times")
    public Times times;

    public class Videos {
        @SerializedName("links")
        public List<Link> links;
    }

    public class Link {
        @SerializedName("uri")
        public String uri;
    }

    public class Times {
        //in seconds
        @SerializedName("realtime_t")
        public Integer realtime_t;
    }
}
