package oriolvillaret.com.api_connection_lib.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PagerGamesResponse {

    @SerializedName("data")
    public List<Game> data = null;

    @SerializedName("pagination")
    public Pagination pagination = null;

}
