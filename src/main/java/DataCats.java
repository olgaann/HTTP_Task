import com.fasterxml.jackson.annotation.JsonProperty;

public class DataCats {
    private String id;
    private String text;
    private String type;
    private String user;
    private String upvotes;

    public DataCats(@JsonProperty("id") String id,
                    @JsonProperty("text") String text,
                    @JsonProperty("type") String type,
                    @JsonProperty("user") String user,
                    @JsonProperty("upvotes") String upvotes) {

        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "DataCats{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", upvotes=" + upvotes +
                '}';
    }
}
