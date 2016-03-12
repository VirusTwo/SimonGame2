package cyril.simonggame.controller;

import android.view.View;

import cyril.simonggame.R;
import cyril.simonggame.view.Setting_View;


/**
 * Created by VirusTwoIUT on 12/03/2016.
 */
public class Setting_Controller implements View.OnClickListener {
    Setting_View setting_view;

    public Setting_Controller(Setting_View view){
        this.setting_view = view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
