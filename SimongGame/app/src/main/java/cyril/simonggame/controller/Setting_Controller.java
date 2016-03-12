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
    String numId = "numIdColor";
    String numLevel = "numLevel";
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
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) setting_view.getContext(), null);
                Intent intent = new Intent(setting_view.getContext(), Menu_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(numId,idColor);
                setting_view.getContext().startActivity(intent,compat.toBundle());
                break;

            case R.id.imgbtEnglish :
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) setting_view.getContext(), null);
                String languageToLoad  = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);

                Configuration config = new Configuration();
                config.locale = locale;
                setting_view.getContext().getResources().updateConfiguration(config, setting_view.getContext().getResources().getDisplayMetrics());

                Intent intent2 = new Intent(setting_view.getContext(), Menu_Activity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putExtra(numId, idColor);
                setting_view.getContext().startActivity(intent2, compat.toBundle());
                break;

            case R.id.imgbtFrench :
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) setting_view.getContext(), null);
                String languageToLoadfr  = "fr"; // your language
                Locale localefr = new Locale(languageToLoadfr);
                Locale.setDefault(localefr);

                Configuration configfr = new Configuration();
                configfr.locale = localefr;
                setting_view.getContext().getResources().updateConfiguration(configfr, setting_view.getContext().getResources().getDisplayMetrics());

                Intent intent3 = new Intent(setting_view.getContext(), Menu_Activity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent3.putExtra(numId, idColor);
                setting_view.getContext().startActivity(intent3, compat.toBundle());
                break;

            case R.id.btLevel1 :
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) setting_view.getContext(), null);
                Intent intent4 = new Intent(setting_view.getContext(), Menu_Activity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent4.putExtra(numLevel,1);
                setting_view.getContext().startActivity(intent4,compat.toBundle());
                break;

            case R.id.btLevel2 :
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) setting_view.getContext(), null);
                Intent intent5 = new Intent(setting_view.getContext(), Menu_Activity.class);
                intent5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent5.putExtra(numLevel,2);
                setting_view.getContext().startActivity(intent5,compat.toBundle());
                break;

            case R.id.btLevel3 :
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) setting_view.getContext(), null);
                Intent intent6 = new Intent(setting_view.getContext(), Menu_Activity.class);
                intent6.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent6.putExtra(numLevel,3);
                setting_view.getContext().startActivity(intent6,compat.toBundle());
                break;
            
            case R.id.switch1 :

                break;
        }
    }
}
