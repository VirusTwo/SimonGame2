package cyril.simonggame.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cyril.simonggame.R;
import cyril.simonggame.controller.Game_Controller;
import cyril.simonggame.model.SimonGame;

/**
 * Created by Cyril on 12/03/2016.
 */
public class Game_View extends LinearLayout {
    public SimonGame simonGame;
    private Game_View itSelf;
    private Button buttons[] = new Button[4];
    private ImageView retrybutton;
    private TextView textViewScore;
    private TextView textViewFinalScore;
    private LinearLayout layoutButtons;
    private Animation animFondu;
    private Animation animApparitionFondu;
    private Animation animDipparitionFondu;
    private Animation animRotate;
    private Animation animStartGame;
    private Animation animBounceButton;
    private Animation animScaleToInvisible;
    private RelativeLayout layoutGameOver;
    private RelativeLayout layoutGameInProgress;
    final Context context;
    private Handler mainHandler = new Handler();

    public Game_View(Context context) {
        super(context);
        itSelf = this;
        this.context = context;

        inflate();
        bindView();
        initAnimation();

        simonGame = new SimonGame(this, buttons);
        doStartGameAnimation();

        initListener();
    }

    private void inflate() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.activity_game, this, true);
    }

    private void bindView() {
        //BindButton
        buttons[0] = (Button) findViewById(R.id.buttonBlue);
        buttons[1] = (Button) findViewById(R.id.buttonGreen);
        buttons[2] = (Button) findViewById(R.id.buttonPurple);
        buttons[3] = (Button) findViewById(R.id.buttonRed);
        textViewScore = (TextView) findViewById(R.id.textViewScoreNb);
        textViewFinalScore = (TextView) findViewById(R.id.textViewFinalScore);
        layoutButtons = (LinearLayout) findViewById(R.id.layoutButtons);
        layoutGameInProgress = (RelativeLayout) findViewById(R.id.layoutGameInProgress);
        layoutGameOver = (RelativeLayout) findViewById(R.id.layoutGameOver);
        retrybutton = (ImageView) findViewById(R.id.retrybutton);
    }

    public void initAnimation() {
        animFondu = AnimationUtils.loadAnimation(context, R.anim.alpha);
        animStartGame = AnimationUtils.loadAnimation(context, R.anim.startgame);
        animStartGame.setAnimationListener(new Animation.AnimationListener() {
           @Override
            public void onAnimationStart(Animation animation) {

            }

           @Override
           public void onAnimationEnd(Animation animation) {
               layoutGameInProgress.setVisibility(View.VISIBLE);
               layoutButtons.setVisibility(View.VISIBLE);
           }

           @Override
           public void onAnimationRepeat(Animation animation) {

           }
        });
        animBounceButton = AnimationUtils.loadAnimation(context, R.anim.littlebounce);
        animApparitionFondu = AnimationUtils.loadAnimation(context, R.anim.apparitionfondu);
        animApparitionFondu.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layoutGameOver.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animDipparitionFondu = AnimationUtils.loadAnimation(context, R.anim.disparitionfondu);
        animDipparitionFondu.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layoutGameOver.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animScaleToInvisible = AnimationUtils.loadAnimation(context, R.anim.scaletoinvisible);
        animScaleToInvisible.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layoutGameInProgress.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void initListener() {
        for (final Button x : buttons) {
            x.setOnClickListener(new Game_Controller(this));
        }

        retrybutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(0);
                layoutGameOver.startAnimation(animDipparitionFondu);
                doStartGameAnimation();
            }
        });
    }



    public void doAnimationFondu(final Button button) {
        button.startAnimation(animFondu);
    }

    public void doAnimationBounce(final Button button) {
        button.startAnimation(animBounceButton);
    }

    public void startGamePartternAnimation() {
        GamePatternAnimation gamePatternAnimation = new GamePatternAnimation();
        gamePatternAnimation.start();
    }

    public void updateScore(int score) {
        textViewScore.setText(String.valueOf(score));
    }


    public void setTextViewFinalScore(int score){
        textViewFinalScore.setText(String.valueOf(score));
    }
    public class StartGameAnimation extends Thread {
        public void run() {
            try {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    layoutGameInProgress.setVisibility(View.VISIBLE);
                    layoutButtons.setVisibility(View.INVISIBLE);
                }
            };
            mainHandler.post(runnable);

            sleep(1000);

            runnable = new Runnable() {
                @Override
                public void run() {
                    layoutButtons.startAnimation(animStartGame);
                }
            };
            mainHandler.post(runnable);

            sleep(2000);

            runnable = new Runnable() {
                @Override
                public void run() {
                    simonGame.startGame();
                }
            };
            mainHandler.post(runnable);
            } catch (InterruptedException e) {

            }
        }

    }

    public class GamePatternAnimation extends Thread {
        public void run() {
            try {
                sleep(1000);
                simonGame.setInAnimation(true);
                int randnb;
                simonGame.addColorToPattern();
                for (final Button x : simonGame.getPattern()) {
                    doAnimInMainHandle(x);
                    sleep(700);
                }
                simonGame.setInAnimation(false);

            } catch (InterruptedException e) {
            }
        }

        public void doAnimInMainHandle(final Button button) {
            Runnable runAnimation = new Runnable() {
                @Override
                public void run() {
                    doAnimationFondu(button);
                }
            };
            mainHandler.post(runAnimation);
        }
    }
    public void doGameOverAnimation(){
        (new GameOverAnimation()).start();
    }
    public void doHiddenbuttonAnimation() {
        for (Button x : buttons) {
            x.startAnimation(animScaleToInvisible);
        }
    }

    public class GameOverAnimation extends Thread {
        public void run() {
            Runnable runAnimation = new Runnable() {
                @Override
                public void run() {
                    doHiddenbuttonAnimation();
                }
            };
            mainHandler.post(runAnimation);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            runAnimation = new Runnable() {
                @Override
                public void run() {
                    layoutGameOver.startAnimation(animApparitionFondu);
                }
            };
            mainHandler.post(runAnimation);
        }
    }

    public void doStartGameAnimation(){
        (new StartGameAnimation()).start();
    }

}