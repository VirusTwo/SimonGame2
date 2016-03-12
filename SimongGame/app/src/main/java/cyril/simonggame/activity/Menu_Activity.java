package cyril.simonggame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import cyril.simonggame.R;
import cyril.simonggame.view.Menu_view;

/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Menu_Activity extends Activity {
    static Menu_view menu_view;
    private int idColor = 0;
    public final static String DIFFICULT = "DIFFICULT";
    public final static String COLOR = "COLOR";
    public final static int DIFFICULT_CODE = 10;
    public final static int COLOR_CODE = 11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //retire le titre (Toolbar)
        setInfullScreen();
        menu_view = new Menu_view(this);
        setContentView(menu_view);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.abc_fade_out);
    }

    public void setInfullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == DIFFICULT_CODE) {
            menu_view.difficult = data.getIntExtra(DIFFICULT, 0);
        }
        else if (resultCode == COLOR_CODE) {
            menu_view.color = data.getIntExtra(COLOR, 0);
        }
        System.out.println(menu_view.color);
    }
}