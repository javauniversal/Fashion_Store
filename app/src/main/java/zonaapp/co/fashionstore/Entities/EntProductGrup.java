package zonaapp.co.fashionstore.Entities;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntProductGrup {

    @SerializedName("producto")
    private List<EntProduct> listProduct;

    @SerializedName("categoria")
    private List<EntCategory> categoriaList;

    public static EntProductGrup entProductGrupStatic;

    public List<EntCategory> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<EntCategory> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public List<EntProduct> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<EntProduct> listProduct) {
        this.listProduct = listProduct;
    }

    public static EntProductGrup getEntProductGrup() {
        return entProductGrupStatic;
    }

    public static void setEntProductGrup(EntProductGrup entProductGrup) {
        EntProductGrup.entProductGrupStatic = entProductGrup;
    }

}
