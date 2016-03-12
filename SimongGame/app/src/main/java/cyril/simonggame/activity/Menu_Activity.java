package cyril.simonggame.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import cyril.simonggame.view.Menu_view;

/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Menu_Activity extends Activity {
    Menu_view menu_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        menu_view = new Menu_view(this);
        setContentView(menu_view);
    }

}
