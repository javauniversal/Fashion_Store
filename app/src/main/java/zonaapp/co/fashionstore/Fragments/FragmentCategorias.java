package zonaapp.co.fashionstore.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zonaapp.co.fashionstore.Adapters.AdapterRecyclerCategoria;
import zonaapp.co.fashionstore.R;


public class FragmentCategorias extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;

    public FragmentCategorias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorias, container, false);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        adapter = new AdapterRecyclerCategoria(getActivity());
        recycler.setAdapter(adapter);
    }

}
