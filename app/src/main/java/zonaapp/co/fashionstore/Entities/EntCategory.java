package zonaapp.co.fashionstore.Entities;


import com.google.gson.annotations.SerializedName;

public class EntCategory {

    @SerializedName("object_id")
    private int object_id;

    @SerializedName("term_taxonomy_id")
    private int term_taxonomy_id;

    @SerializedName("term_order")
    private int term_order;

    @SerializedName("term_id")
    private int term_id;

    @SerializedName("name")
    private String name;

    @SerializedName("slug")
    private String slug;

    @SerializedName("term_group")
    private int term_group;

    public int getObject_id() {
        return object_id;
    }

    public void setObject_id(int object_id) {
        this.object_id = object_id;
    }

    public int getTerm_taxonomy_id() {
        return term_taxonomy_id;
    }

    public void setTerm_taxonomy_id(int term_taxonomy_id) {
        this.term_taxonomy_id = term_taxonomy_id;
    }

    public int getTerm_order() {
        return term_order;
    }

    public void setTerm_order(int term_order) {
        this.term_order = term_order;
    }

    public int getTerm_id() {
        return term_id;
    }

    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getTerm_group() {
        return term_group;
    }

    public void setTerm_group(int term_group) {
        this.term_group = term_group;
    }

    @Override
    public String toString() {
        return name;
    }
}
