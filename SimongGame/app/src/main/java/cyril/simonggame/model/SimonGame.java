package cyril.simonggame.model;

/**
 * Created by Cyril on 12/03/2016.
 */

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import cyril.simonggame.R;
import cyril.simonggame.activity.GameActivity;
import cyril.simonggame.view.Game_View;

/**
 * Created by Cyril on 10/03/2016.
 */
public class SimonGame {
    private Game_View game_View;
    private boolean gameStarted = false;
    private boolean inAnimation = false;

    private Button buttons[];
    private int round;
    private int currentTurn;
    private ArrayList<Button> pattern = new ArrayList<Button>();
    public SimonGame(Game_View game_View,Button buttons[]){
        this.buttons = buttons;
        this.game_View = game_View;
    }
    public void startGame(){
        pattern.clear();
        gameStarted = true;
        round = 0;
        currentTurn = 0;
        game_View.updateScore(0);
        game_View.startGamePartternAnimation();
    }
    public void addColorToPattern(){
        setRound(0);
        int randnb = random(0,3);
        pattern.add(buttons[randnb]);
    }
    public Integer random(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    public ArrayList<Button> getPattern(){
        return pattern;
    }

    public Button getButtonAt(int index){
        return buttons[index];
    }

    public void setRound(int round){
        this.round = round;
    }
    public int getRound(){
        return round;
    }


    public void setInAnimation(boolean inAnimation){
        this.inAnimation = inAnimation;
    }
    public boolean getInAnimation(){
        return inAnimation;
    }

    public boolean getgameStarted(){
        return gameStarted;
    }
    public void setGameStarted(boolean gameStarted){
        this.gameStarted = gameStarted;
    }

    public void scoreUp(){
        round++;
    }
}
