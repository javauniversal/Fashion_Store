package zonaapp.co.fashionstore.Entities;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntProduct {

    @SerializedName("ID")
    private int ID;

    @SerializedName("post_title")
    private String post_title;

    @SerializedName("post_type")
    private String post_type;

    @SerializedName("post_status")
    private String post_status;

    @SerializedName("post_content")
    private String post_content;

    @SerializedName("post_excerpt")
    private String post_excerpt;

    @SerializedName("post_name")
    private String post_name;

    @SerializedName("categoria")
    private List<EntCategory> categoryList;

    @SerializedName("atributos")
    private List<EntAttributes> attributesList;

    @SerializedName("galeria")
    private List<EntGalery> galeryList;

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

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getPost_status() {
        return post_status;
    }

    public void setPost_status(String post_status) {
        this.post_status = post_status;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_excerpt() {
        return post_excerpt;
    }

    public void setPost_excerpt(String post_excerpt) {
        this.post_excerpt = post_excerpt;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public List<EntCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<EntCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public List<EntAttributes> getAttributesList() {
        return attributesList;
    }

    public void setAttributesList(List<EntAttributes> attributesList) {
        this.attributesList = attributesList;
    }

    public List<EntGalery> getGaleryList() {
        return galeryList;
    }

    public void setGaleryList(List<EntGalery> galeryList) {
        this.galeryList = galeryList;
    }

}
