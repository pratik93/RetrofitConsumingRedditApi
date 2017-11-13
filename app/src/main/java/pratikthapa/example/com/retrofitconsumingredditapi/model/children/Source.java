package pratikthapa.example.com.retrofitconsumingredditapi.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pratikthapa on 11/10/17.
 */

public class Source {


    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Source{" +
                "url='" + url + '\'' +
                '}';
    }
}
