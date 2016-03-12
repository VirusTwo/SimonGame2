package cyril.simonggame.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import java.util.Locale;

import cyril.simonggame.R;
import cyril.simonggame.activity.GameActivity;
import cyril.simonggame.activity.Menu_Activity;
import cyril.simonggame.view.Setting_View;


/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Setting_Controller implements View.OnClickListener {
    Setting_View setting_view;
    private int idColor = 0;
    public Setting_Controller(Setting_View view){
        this.setting_view = view;
    }
    ActivityOptionsCompat compat ;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btColor1 :
                idColor = 1;
                break;
            case R.id.btColor2 :
                idColor = 2;
                break;
            case R.id.btColor3 :
                idColor = 3;
                break;
            case R.id.btRetour :
                String numId = "numId";
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) setting_view.getContext(), null);
                Intent intent = new Intent(setting_view.getContext(), Menu_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(numId,idColor);
                setting_view.getContext().startActivity(intent,compat.toBundle());
                break;
            case R.id.imgBtEnglish :
                String languageToLoad  = "fr"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;
            case R.id.imgbtFrench :
                break;
        }
    }
}
