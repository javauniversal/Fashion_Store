package zonaapp.co.fashionstore.Entities;

import com.google.gson.annotations.SerializedName;

public class EntAttributes {

    @SerializedName("ID")
    private int ID;

    @SerializedName("post_title")
    private String post_title;

    @SerializedName("meta_id")
    private int meta_id;

    @SerializedName("post_id")
    private int post_id;

    @SerializedName("meta_key")
    private String meta_key;

    @SerializedName("meta_value")
    private String meta_value;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public int getMeta_id() {
        return meta_id;
    }

    public void setMeta_id(int meta_id) {
        this.meta_id = meta_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getMeta_key() {
        return meta_key;
    }

    public void setMeta_key(String meta_key) {
        this.meta_key = meta_key;
    }

    public String getMeta_value() {
        return meta_value;
    }

    public void setMeta_value(String meta_value) {
        this.meta_value = meta_value;
    }

}
