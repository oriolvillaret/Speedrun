package oriolvillaret.com.api_connection_lib.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Game implements Serializable{
    @SerializedName("id")
    public String id;
    @SerializedName("names")
    public Names names;
    @SerializedName("assets")
    public Assets assets;

    public class Names implements Serializable{
        @SerializedName("international")
        public String international;
    }

    public class Assets implements Serializable{
        @SerializedName("icon")
        public Icon icon;
    }

    public class Icon implements Serializable {
        @SerializedName("uri")
        public String uri;
        @SerializedName("width")
        public Integer width;
        @SerializedName("height")
        public Integer height;
    }

}
