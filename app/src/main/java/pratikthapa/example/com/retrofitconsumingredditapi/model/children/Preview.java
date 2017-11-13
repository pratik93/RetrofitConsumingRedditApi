package pratikthapa.example.com.retrofitconsumingredditapi.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pratikthapa on 11/10/17.
 */

public class Preview {
    @SerializedName("images")
    @Expose
    private ArrayList<Images> images;

    public ArrayList<Images> getImages() {
        return images;
    }

    public void setImages(ArrayList<Images> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Preview{" +
                "images=" + images +
                '}';
    }
}
