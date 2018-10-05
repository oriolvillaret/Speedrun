package oriolvillaret.com.api_connection_lib.models;

import com.google.gson.annotations.SerializedName;

public class Game {
    @SerializedName("id")
    public String id;
    @SerializedName("names")
    public Names names;
    @SerializedName("assets")
    public Assets assets;

    public class Names {
        @SerializedName("international")
        public String international;
    }

    public class Assets {
        @SerializedName("icon")
        public Asset icon;
        @SerializedName("cover-large")
        public Asset coverLarge;
    }

    public class Asset {
        @SerializedName("uri")
        public String uri;
        @SerializedName("width")
        public Integer width;
        @SerializedName("height")
        public Integer height;
    }

}
