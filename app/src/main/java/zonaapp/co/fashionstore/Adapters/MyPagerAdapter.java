package zonaapp.co.fashionstore.Adapters;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import zonaapp.co.fashionstore.Fragments.SuperAwesomeCardFragment;

import static zonaapp.co.fashionstore.Entities.EntProductGrup.getEntProductGrup;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = new String[getEntProductGrup().getCategoriaList().size()];

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        menuCategory();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        Bundle arguments = new Bundle();
        arguments.putInt("position", position);
        SuperAwesomeCardFragment myFragment;
        myFragment = SuperAwesomeCardFragment.newInstance(arguments);

        return myFragment;

    }

    public String[] menuCategory(){

        for (int i=0; i<getEntProductGrup().getCategoriaList().size(); i++) {
            TITLES[i] = getEntProductGrup().getCategoriaList().get(i).toString();
        }

        return TITLES;
    }


}
