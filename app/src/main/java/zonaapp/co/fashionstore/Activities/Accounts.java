package zonaapp.co.fashionstore.Activities;

import android.content.Intent;
import android.os.Bundle;

import zonaapp.co.fashionstore.Fragments.FragmentCarridoCompras;
import zonaapp.co.fashionstore.Fragments.FragmentIndex;
import zonaapp.co.fashionstore.Fragments.FragmentPromociones;
import zonaapp.co.fashionstore.R;


public class Accounts extends MaterialNavigationDrawerCustom  {

    @Override
    public void init(Bundle savedInstanceState) {
        // create sections
        setDrawerHeaderImage(R.drawable.side_nav_bar);
        setUsername("Fashion Store");
        setUserEmail("Por que la moda es estar online");
        setFirstAccountPhoto(getResources().getDrawable(R.drawable.icon_));

        // create sections
        this.addSection(newSection("Ofertas", R.drawable.ic_store_black_24dp, new FragmentPromociones()));
        this.addSection(newSection("Carrito de Compra", R.drawable.ic_shopping_basket_black_24dp, new FragmentCarridoCompras()));
        this.addSection(newSection("Tiendas", R.drawable.ic_explore_black_24dp, new FragmentIndex()));
        this.addSection(newSection("Soporte en Línea", R.drawable.ic_people_black_24dp, new FragmentIndex()));
        this.addSection(newSection("Ajustes", R.drawable.ic_settings_black_24dp, new FragmentIndex()));
        this.addSection(newSection("Quienes Somos", R.drawable.ic_person_pin_black_24dp, new FragmentIndex()));

        //this.addSection(newSection("Quienes Somos", R.drawable.ic_pin_drop_black_48dp, new Intent(this, ActMaps.class)));

        // create bottom section
        this.addBottomSection(newSection("Botón Salir", R.drawable.ic_exit_to_app_black_24dp, new Intent(this, Settings.class)));

    }


}
