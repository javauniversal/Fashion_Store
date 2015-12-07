package zonaapp.co.fashionstore.Fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import zonaapp.co.fashionstore.Adapters.MyPagerAdapter;
import zonaapp.co.fashionstore.R;


public class FragmentPromociones extends BaseVolleyFragment {

    PagerSlidingTabStrip tabs;
    ViewPager pager;

    public FragmentPromociones() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }
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

        pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));

        tabs.setViewPager(pager);

        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        tabs.setIndicatorColor(getResources().getColor(R.color.colorNegro));

    }

}
