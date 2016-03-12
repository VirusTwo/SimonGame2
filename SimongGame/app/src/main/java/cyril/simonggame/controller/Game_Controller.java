package cyril.simonggame.controller;

import android.view.View;

import cyril.simonggame.view.Game_View;

/**
 * Created by Cyril on 12/03/2016.
 */
public class Game_Controller implements View.OnClickListener {
    Game_View game_View;
    public Game_Controller(Game_View view){
        this.game_View = view;
    }
    public void onClick(View v) {
        
    }
}
