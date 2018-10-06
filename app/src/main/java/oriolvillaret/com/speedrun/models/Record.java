package oriolvillaret.com.speedrun.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Record implements Parcelable {
    private String videoURL;
    private Double time; //in seconds
    private User userFistPlace;

    public Record() {
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public User getUserFistPlace() {
        return userFistPlace;
    }

    public void setUserFistPlace(User userFistPlace) {
        this.userFistPlace = userFistPlace;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.videoURL);
        dest.writeDouble(this.time);
        dest.writeParcelable(this.userFistPlace, flags);
    }

    protected Record(Parcel in) {
        this.videoURL = in.readString();
        this.time = in.readDouble();
        this.userFistPlace = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel source) {
            return new Record(source);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };
}
