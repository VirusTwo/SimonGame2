package cyril.simonggame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import cyril.simonggame.R;
import cyril.simonggame.view.Menu_view;

/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Menu_Activity extends Activity {
    static Menu_view menu_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //retire le titre (Toolbar)
        menu_view = new Menu_view(this);
        setContentView(menu_view);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.abc_fade_out);
    }

}