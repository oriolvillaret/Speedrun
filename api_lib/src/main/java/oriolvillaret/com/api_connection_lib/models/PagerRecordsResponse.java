package oriolvillaret.com.api_connection_lib.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PagerRecordsResponse {

    @SerializedName("data")
    public List<Record> data = null;

    @SerializedName("pagination")
    public Pagination pagination = null;

}
