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
        public Icon icon;
    }

    public class Icon {
        @SerializedName("uri")
        public String uri;
        @SerializedName("width")
        public Integer width;
        @SerializedName("height")
        public Integer height;
    }

}
