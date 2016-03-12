package cyril.simonggame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import cyril.simonggame.view.Menu_view;
import cyril.simonggame.view.Setting_View;

/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Setting_Activity extends Activity {
    Setting_View setting_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //retire le titre (Toolbar)
        setting_view = new Setting_View(this);
        setContentView(setting_view);
    }
}
