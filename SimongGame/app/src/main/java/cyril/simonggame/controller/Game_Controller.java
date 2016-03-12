package cyril.simonggame.controller;

import android.view.View;
import android.widget.Button;

import cyril.simonggame.model.SimonGame;
import cyril.simonggame.view.Game_View;

/**
 * Created by Cyril on 12/03/2016.
 */
public class Game_Controller implements View.OnClickListener {
    private Game_View game_View;
    private SimonGame simonGame;
    public Game_Controller(Game_View view){
        this.game_View = view;
        this.simonGame = game_View.simonGame;
    }

    public void onClick(View v) {
        Button currentButton = (Button)v;
        simonGame.userHadClick(currentButton);
    }
}
