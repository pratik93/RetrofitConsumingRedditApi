package pratikthapa.example.com.retrofitconsumingredditapi.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pratikthapa on 11/10/17.
 */

public class Images {
    @SerializedName("source")
    @Expose
    private Source source;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Images{" +
                "source=" + source +
                '}';
    }
}
