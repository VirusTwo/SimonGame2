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
        System.out.println(simonGame.getgameStarted());
       if(simonGame.getgameStarted() && !simonGame.getInAnimation()){
           game_View.doAnimationBounce(currentButton);
            if(currentButton == simonGame.getPattern().get(simonGame.getRound())){
                simonGame.setRound(simonGame.getRound()+1);
            }else{
                simonGame.setGameStarted(false);
                System.out.println("GameOver");
            }

            if(simonGame.getPattern().size() == simonGame.getRound()){
                simonGame.scoreUp();
                game_View.updateScore(simonGame.getRound());

                System.out.println("GG");
                simonGame.setInAnimation(true);
                game_View.startGamePartternAnimation();
            }
        }
    }
}
