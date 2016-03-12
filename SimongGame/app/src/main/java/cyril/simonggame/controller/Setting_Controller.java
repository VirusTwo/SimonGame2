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
import cyril.simonggame.activity.Setting_Activity;
import cyril.simonggame.view.Setting_View;


/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Setting_Controller implements View.OnClickListener {
    Setting_View setting_view;
    Setting_Activity setting_activity;
    private int idColor = 0;
    public final static String DIFFICULT = "DIFFICULT";
    public final static String COLOR = "COLOR";
    public final static int DIFFICULT_CODE = 10;
    public final static int COLOR_CODE = 11;
    public Setting_Controller(Setting_View view){
        this.setting_view = view;
        this.setting_activity = (Setting_Activity)setting_view.getContext();
    }
    ActivityOptionsCompat compat ;
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(setting_view.getContext(), Menu_Activity.class);
        switch (v.getId()){
            case R.id.btColor1 :
                idColor = 1;
                intent.putExtra(COLOR, idColor);
                setting_activity.setResult(COLOR_CODE,intent);
                setting_activity.finish();
                break;
            case R.id.btColor2 :
                idColor = 2;
                intent.putExtra(COLOR, idColor);
                setting_activity.setResult(COLOR_CODE, intent);
                setting_activity.finish();
                break;
            case R.id.btColor3 :
                idColor = 3;
                intent.putExtra(COLOR, idColor);
                setting_activity.setResult(COLOR_CODE, intent);
                setting_activity.finish();
                break;
            case R.id.btLevel1:
                intent.putExtra(DIFFICULT, 1);
                setting_activity.setResult(DIFFICULT_CODE, intent);
                setting_activity.finish();
                break;
            case R.id.btLevel2 :
                intent.putExtra(DIFFICULT, 2);
                setting_activity.setResult(DIFFICULT_CODE, intent);
                setting_activity.finish();
                break;
            case R.id.btLevel3 :
                intent.putExtra(DIFFICULT, 3);
                setting_activity.setResult(DIFFICULT_CODE, intent);
                setting_activity.finish();
                break;

            case R.id.btRetour :
                intent.setFlags(0);
                setting_activity.finish();
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
                setting_view.getContext().startActivity(intent3, compat.toBundle());
                break;

        }
    }
}
