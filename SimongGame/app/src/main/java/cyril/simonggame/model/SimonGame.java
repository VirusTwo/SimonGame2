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
    private int score;
    private int tour;
    private ArrayList<Button> pattern = new ArrayList<Button>();
    public SimonGame(Game_View game_View,Button buttons[]){
        this.buttons = buttons;
        this.game_View = game_View;
    }
    public void startGame(){
        pattern.clear();
        gameStarted = true;
        score = 0;
        tour = 0;
        game_View.updateScore(0);
        game_View.startGamePartternAnimation();
    }
    public void addColorToPattern(){
        setTour(0);
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

    public void setTour(int tour){
        this.tour = tour;
    }
    public int getTour(){
        return tour;
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
        score++;
    }
    public int getScore(){return score;}

    public void userHadClick(Button currentButton){
        if(gameStarted && !inAnimation){
            game_View.doAnimationBounce(currentButton);
            if(currentButton == pattern.get(tour)){
                tour++;
            }else{
                gameOver();
                System.out.println("GameOver");
            }

            if(pattern.size() == tour){
                scoreUp();
                game_View.updateScore(score);
                System.out.println("GG");
                inAnimation = true;
                game_View.startGamePartternAnimation();
            }
        }
    }
    public void gameOver(){
        gameStarted = false;
        game_View.setTextViewFinalScore(score);
        game_View.doGameOverAnimation();

    }
}
