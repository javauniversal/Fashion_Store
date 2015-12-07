package zonaapp.co.fashionstore.Activities;


import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import zonaapp.co.fashionstore.DataBase.DBHelper;
import zonaapp.co.fashionstore.R;

public class Splash extends AwesomeSplashCustom {

    //DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!
    private DBHelper mydb;

    @Override
    public void initSplash(ConfigSplash configSplash) {

        /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.colorPrimary); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(2000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.icon_); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.DropOut); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

        //Customize Title
        configSplash.setTitleSplash("Fashion Store");
        configSplash.setTitleTextColor(R.color.colorBlanco);
        configSplash.setTitleTextSize(45f); //float value
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.Tada);
        configSplash.setTitleFont("fonts/Satisfy-Regular.ttf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {

        mydb = new DBHelper(Splash.this);
        mydb.insertIntro("Inicio_sesion");

        startActivity(new Intent(Splash.this, Accounts.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();

    }

}
