package cyril.simonggame.activity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import cyril.simonggame.R;

public class GameActivity extends AppCompatActivity {
    private Button[] buttons = new Button[4];
    private final Handler mainHandle = new Handler();
    Animation animRotate;
    Animation alphaRotate;
    private  GameStory thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        alphaRotate = AnimationUtils.loadAnimation(this, R.anim.alpha);
        buttons[0] = (Button)findViewById(R.id.buttonBlue);
        buttons[1] = (Button)findViewById(R.id.buttonGreen);
        buttons[2] = (Button)findViewById(R.id.buttonPurple);
        buttons[3] = (Button)findViewById(R.id.buttonRed);
        thread = new GameStory();
        thread.start();
    }

    public class GameStory extends Thread{
        private ArrayList<Integer> pattern = new ArrayList<Integer>();
        private int score = 0;
        public Integer random(int min, int max){
            return min + (int)(Math.random() * ((max - min) + 1));
        }

        public void run(){
            while(true){
                try{
                    sleep(400);
                }catch (InterruptedException e){
                }

                int randnb = random(0,3);
                startAnimation(randnb);
            }
        }

        public void startAnimation(final int nb){
            Runnable runAnimation = new Runnable() {
                @Override
                public void run() {
                    buttons[nb].startAnimation(alphaRotate);
                }
            };
            mainHandle.post(runAnimation);
        }
    }
}
