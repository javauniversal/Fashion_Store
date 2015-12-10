package zonaapp.co.fashionstore.Entities;

import com.google.gson.annotations.SerializedName;

public class EntGalery {

    @SerializedName("ID")
    private int ID;

    @SerializedName("post_parent")
    private int post_parent;

    @SerializedName("guid")
    private String guid;

    public int getPost_parent() {
        return post_parent;
    }

    public void setPost_parent(int post_parent) {
        this.post_parent = post_parent;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
