package oriolvillaret.com.api_connection_lib.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pagination {

    @SerializedName("offset")
    public Integer offset;
    @SerializedName("max")
    public Integer max;
    @SerializedName("size")
    public Integer size;
    @SerializedName("links")
    public List<Link> links = null;


}
