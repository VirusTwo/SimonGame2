package cyril.simonggame.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.telecom.Call;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.View;

import cyril.simonggame.R;
import cyril.simonggame.activity.GameActivity;
import cyril.simonggame.activity.Menu_Activity;
import cyril.simonggame.activity.Setting_Activity;
import cyril.simonggame.view.Menu_view;

/**
 * Created by VirusTwoIUT on 11/03/2016.
 */
public class Menu_Controller implements View.OnClickListener {
    Menu_view menu_view;
    Menu_Activity menu_activity;
    public final int SETTINGS_REQUEST = 1;
    public final static String DIFFICULT = "DIFFICULT";
    public final static String COLOR = "COLOR";
    public Menu_Controller(Menu_view view){
        this.menu_view = view;
        menu_activity = (Menu_Activity)view.getContext();
    }
    ActivityOptionsCompat compat ;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btPlay :
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) menu_view.getContext(), null);
                Intent intent = new Intent(menu_view.getContext(), GameActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(DIFFICULT, menu_view.difficult);
                intent.putExtra(COLOR,menu_view.color);
                menu_view.getContext().startActivity(intent, compat.toBundle());
                break;
            case R.id.btSetting :
                compat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) menu_view.getContext(), null);
                Intent intent2 = new Intent(menu_view.getContext(), Setting_Activity.class);
                //intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putExtra(DIFFICULT, menu_view.difficult);
                intent2.putExtra(COLOR, menu_view.color);
                ((Activity) menu_view.getContext()).startActivityForResult(intent2, SETTINGS_REQUEST, compat.toBundle());
                break;
            case R.id.btLeave :
                int p = android.os.Process.myPid();
                android.os.Process.killProcess(p);
                break;
        }
    }
}
