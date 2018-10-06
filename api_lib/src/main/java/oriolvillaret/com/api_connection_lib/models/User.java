package oriolvillaret.com.api_connection_lib.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    public String id;
    @SerializedName("names")
    public Names names;

    public class Names {
        @SerializedName("international")
        public String international;
    }

}
