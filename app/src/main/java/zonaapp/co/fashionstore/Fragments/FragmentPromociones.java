package zonaapp.co.fashionstore.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zonaapp.co.fashionstore.Activities.DetailsActivity;
import zonaapp.co.fashionstore.Adapters.AdapterRecyclerProduct;
import zonaapp.co.fashionstore.Entities.EntProduct;
import zonaapp.co.fashionstore.Entities.EntProductGrup;
import zonaapp.co.fashionstore.R;

import static zonaapp.co.fashionstore.Entities.EntProductGrup.setEntProductGrup;

public class FragmentPromociones extends BaseVolleyFragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private String _regular_price, _sale_price, _max_variation_regular_price, _min_variation_sale_price;

    public FragmentPromociones() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_promociones, container, false);

        mRecyclerView = (RecyclerView) myView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        return myView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadDataProduct();

    }

    public void loadDataProduct(){
        String url = String.format("%1$s%2$s", getString(R.string.url_base),"PromotionalProductList");
        StringRequest jsonRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(final String response) {
                        parseJSON(response);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        onConnectionFailed(error.toString());
                        startActivity(new Intent(getActivity(), DetailsActivity.class).putExtra("STATE", "ERROR"));
                        getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams(){
                return new HashMap<>();
            }
        };
        addToQueue(jsonRequest);
    }

    private boolean parseJSON(String json) {
        if (!json.equals("[]")){

            try {

                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

                EntProductGrup productsproducts = gson.fromJson(json, EntProductGrup.class);
                setEntProductGrup(productsproducts);

                List<EntProduct> entProducts = new ArrayList<>();

                for (int i=0; i < productsproducts.getListProduct().size(); i++) {

                    getPrecio(i,productsproducts);

                    if(!(_sale_price == null || _sale_price.equals("")) || !(_min_variation_sale_price == null || _max_variation_regular_price.equals(""))){
                        entProducts.add(new EntProduct(productsproducts.getListProduct().get(i).getID(),
                                productsproducts.getListProduct().get(i).getPost_title(),
                                productsproducts.getListProduct().get(i).getPost_type(),
                                productsproducts.getListProduct().get(i).getPost_status(),
                                productsproducts.getListProduct().get(i).getPost_content(),
                                productsproducts.getListProduct().get(i).getPost_excerpt(),
                                productsproducts.getListProduct().get(i).getPost_name(),
                                productsproducts.getListProduct().get(i).getCategoryList(),
                                productsproducts.getListProduct().get(i).getAttributesList(),
                                productsproducts.getListProduct().get(i).getGaleryList()));
                    }

                }

                mLayoutManager = new GridLayoutManager(getActivity(), 2);
                mRecyclerView.setLayoutManager(mLayoutManager);

                mAdapter = new AdapterRecyclerProduct(getActivity(), entProducts);
                mRecyclerView.setAdapter(mAdapter);

                return true;

            }catch (IllegalStateException ex) {
                ex.printStackTrace();
            }

        }else {
            startActivity(new Intent(getActivity(), DetailsActivity.class).putExtra("STATE", "EMPTY"));
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }

        return false;

    }

    public void getPrecio(int position, EntProductGrup productsproducts){

        for (int i=0; i < productsproducts.getListProduct().get(position).getAttributesList().size(); i++) {

            if(productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_key().equals("_regular_price")){
                _regular_price = productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_value();
            }else if(productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_key().equals("_sale_price")){
                _sale_price = productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_value();
            }else if(productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_key().equals("_min_variation_sale_price")){
                _min_variation_sale_price = productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_value();
            }else if(productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_key().equals("_max_variation_regular_price")){
                _max_variation_regular_price = productsproducts.getListProduct().get(position).getAttributesList().get(i).getMeta_value();
            }

        }

    }


}
