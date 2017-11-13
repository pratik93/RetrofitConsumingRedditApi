package pratikthapa.example.com.retrofitconsumingredditapi.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pratikthapa on 11/8/17.
 */

public class Data {

    @SerializedName("contest_mode")
    @Expose
    private String contest_mode;

    @SerializedName("subreddit")
    @Expose
    private String subreddit;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("preview")
    @Expose
    private Preview preview;

    public String getContest_mode() {
        return contest_mode;
    }

    public void setContest_mode(String contest_mode) {
        this.contest_mode = contest_mode;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "Data{" +
                "contest_mode='" + contest_mode + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", author='" + author + '\'' +
                ", preview=" + preview +
                '}';
    }
}
