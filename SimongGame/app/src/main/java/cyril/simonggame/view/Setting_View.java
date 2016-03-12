package cyril.simonggame.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import cyril.simonggame.R;
import cyril.simonggame.controller.Menu_Controller;

/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Setting_View extends LinearLayout {
    Context context;
    public Setting_View(Context context) {
        super(context);
        this.context = context;
    }
    private void inflate() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.setting_activity, this, true);
    }
    private void bindView(){
        //Futur Objet de la page
        // Test changement color

    }
}
