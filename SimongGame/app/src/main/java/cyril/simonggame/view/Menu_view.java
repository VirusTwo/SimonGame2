package cyril.simonggame.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import cyril.simonggame.R;
import cyril.simonggame.controller.Menu_Controller;

/**
 * Created by VirusTwoIUT on 11/03/2016.
 */
public class Menu_view extends LinearLayout {
    private Button play;
    private Button leave;
    private Button setting;
    final Context context;
    public Menu_view(Context context) {
        super(context);
        this.context = context;
        inflate();
        bindView();
    }

    private void inflate() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.accueil_activity, this, true);
    }
    private void bindView(){
        Menu_Controller controller = new Menu_Controller(this);
        //BindButton
        play = (Button) findViewById(R.id.btPlay);
        setting = (Button) findViewById(R.id.btSetting);
        leave = (Button) findViewById(R.id.btLeave);

        play.setOnClickListener(controller);
        setting.setOnClickListener(controller);
        leave.setOnClickListener(controller);

    }

}
