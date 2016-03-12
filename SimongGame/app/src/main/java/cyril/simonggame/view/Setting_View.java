package cyril.simonggame.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import cyril.simonggame.R;
import cyril.simonggame.controller.Menu_Controller;
import cyril.simonggame.controller.Setting_Controller;

/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Setting_View extends LinearLayout {
    Context context;

    private Button btColor1;
    private Button btColor2;
    private Button btColor3;
    private Button retour;
    private Button english;
    private Button french;
    private Switch switchDalto;
    private Button level1;
    private Button level2;
    private Button level3;

    public Setting_View(Context context) {
        super(context);
        this.context = context;
        inflate();
        bindView();
    }
    private void inflate() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.setting_activity, this, true);
    }
    private void bindView(){
        //Futur Objet de la page
        Setting_Controller controller = new Setting_Controller(this);

        btColor1 = (Button) findViewById(R.id.btColor1);
        btColor2 = (Button) findViewById(R.id.btColor2);
        btColor3 = (Button) findViewById(R.id.btColor3);
        retour = (Button) findViewById(R.id.btRetour);
        english = (Button) findViewById(R.id.imgbtEnglish);
        french = (Button) findViewById(R.id.imgbtFrench);
        switchDalto = (Switch) findViewById(R.id.switch1);
        level1 = (Button) findViewById(R.id.btLevel1);
        level2 = (Button) findViewById(R.id.btLevel2);
        level3 = (Button) findViewById(R.id.btLevel3);

        btColor1.setOnClickListener(controller);
        btColor2.setOnClickListener(controller);
        btColor3.setOnClickListener(controller);
        retour.setOnClickListener(controller);
        english.setOnClickListener(controller);
        french.setOnClickListener(controller);
        switchDalto.setOnClickListener(controller);
        level1.setOnClickListener(controller);
        level2.setOnClickListener(controller);
        level3.setOnClickListener(controller);

    }
}
