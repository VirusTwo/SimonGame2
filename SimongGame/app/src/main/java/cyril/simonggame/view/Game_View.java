package cyril.simonggame.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import cyril.simonggame.R;
import cyril.simonggame.controller.Game_Controller;

/**
 * Created by Cyril on 12/03/2016.
 */
public class Game_View extends LinearLayout {
    private Button buttons[] =  new Button[4];
    private Animation animFondu;
    private Animation animRotate;
    private Animation animStartGame;
    private Animation animBounceButton;
    final Context context;
    public Game_View(Context context) {
        super(context);
        this.context = context;
        inflate();
        bindView();
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
        animFondu = AnimationUtils.loadAnimation(context, R.anim.alpha);
        animStartGame = AnimationUtils.loadAnimation(context, R.anim.startgame);
        animBounceButton = AnimationUtils.loadAnimation(context, R.anim.littlebounce);
        for(final Button x: buttons) {
            x.setOnClickListener(new Game_Controller(this));
        }
    }
    public void doAnimationFondu(final Button button) {
        button.startAnimation(animFondu);
    }
    public void doAnimationBounce(final Button button){
        button.startAnimation(animBounceButton);
    }
}