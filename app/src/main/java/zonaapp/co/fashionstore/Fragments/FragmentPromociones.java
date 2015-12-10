package zonaapp.co.fashionstore.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.astuetz.PagerSlidingTabStrip;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import zonaapp.co.fashionstore.Activities.DetailsActivity;
import zonaapp.co.fashionstore.Adapters.MyPagerAdapter;
import zonaapp.co.fashionstore.Entities.EntProductGrup;
import zonaapp.co.fashionstore.R;

import static zonaapp.co.fashionstore.Entities.EntProductGrup.setEntProductGrup;

public class FragmentPromociones extends BaseVolleyFragment {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    public FragmentPromociones() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_promociones, container, false);

        // Initialize the ViewPager and set an adapter
        pager = (ViewPager) myView.findViewById(R.id.pager);
        // Bind the tabs to the ViewPager
        tabs = (PagerSlidingTabStrip) myView.findViewById(R.id.tabs);

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

                pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
                pager.setCurrentItem(0);

                tabs.setViewPager(pager);
                tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                tabs.setIndicatorColor(getResources().getColor(R.color.colorNegro));

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


}
