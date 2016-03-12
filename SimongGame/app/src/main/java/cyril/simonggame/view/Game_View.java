package cyril.simonggame.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import cyril.simonggame.R;
import cyril.simonggame.controller.Game_Controller;
import cyril.simonggame.model.SimonGame;

/**
 * Created by Cyril on 12/03/2016.
 */
public class Game_View extends LinearLayout {
    public SimonGame simonGame;
    private Game_View itSelf ;
    private Button buttons[] =  new Button[4];
    private TextView textViewScore;
    private LinearLayout layoutButtons;
    private Animation animFondu;
    private Animation animRotate;
    private Animation animStartGame;
    private Animation animBounceButton;
    final Context context;
    private Handler mainHandler = new Handler();
    public Game_View(Context context) {
        super(context);
        itSelf = this;
        this.context = context;

        inflate();
        bindView();
        initAnimation();

        simonGame = new SimonGame(this,buttons);

        StartGameAnimation startGameAnimation = new StartGameAnimation();
        startGameAnimation.start();
        initListener();
    }

    private void inflate() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.activity_game, this, true);
    }
    private void bindView(){
        Game_Controller controller = new Game_Controller(this);
        //BindButton
        buttons[0] = (Button)findViewById(R.id.buttonBlue);
        buttons[1] = (Button)findViewById(R.id.buttonGreen);
        buttons[2] = (Button)findViewById(R.id.buttonPurple);
        buttons[3] = (Button)findViewById(R.id.buttonRed);
        textViewScore = (TextView) findViewById(R.id.textViewScoreNb);
        layoutButtons = (LinearLayout) findViewById(R.id.layoutButtons);

    }
    public  void initAnimation(){
        animFondu = AnimationUtils.loadAnimation(context, R.anim.alpha);
        animStartGame = AnimationUtils.loadAnimation(context, R.anim.startgame);
        animBounceButton = AnimationUtils.loadAnimation(context, R.anim.littlebounce);
    }
    public void initListener(){
        for(final Button x: buttons) {
            x.setOnClickListener(new Game_Controller(this));
        }
    }
    public void doStartGameAnimation(){
        layoutButtons.startAnimation(animStartGame);
    }
    public void doAnimationFondu(final Button button) {
        button.startAnimation(animFondu);
    }
    public void doAnimationBounce(final Button button){
        button.startAnimation(animBounceButton);
    }

    public void startGamePartternAnimation(){
        GamePatternAnimation gamePatternAnimation = new GamePatternAnimation();
        gamePatternAnimation.start();
    }
    public void updateScore(int score){
        textViewScore.setText(String.valueOf(score));
    }

    public class StartGameAnimation extends Thread{
        public void run(){
            doStartGameAnimation();
            try{
                sleep(2000);
            } catch (InterruptedException e){
            }
            Runnable runAnimation = new Runnable() {
                @Override
                public void run() {
                    simonGame.startGame();
                }
            };
            mainHandler.post(runAnimation);
        }

    }
    public class GamePatternAnimation extends Thread{
        public void run(){
            simonGame.setInAnimation(true);
            int randnb;
            simonGame.addColorToPattern();
            for(final Button x: simonGame.getPattern()) {
                doAnimInMainHandle(x);
                try{
                    sleep(700);
                }catch (InterruptedException e){
                }
            }
            simonGame.setInAnimation(false);

        }
        public void doAnimInMainHandle(final Button button){
            Runnable runAnimation = new Runnable() {
                @Override
                public void run() {
                    doAnimationFondu(button);
                }
            };
            mainHandler.post(runAnimation);
        }
    }
}