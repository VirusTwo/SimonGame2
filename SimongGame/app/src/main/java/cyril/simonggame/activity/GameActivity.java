package cyril.simonggame.activity;


import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

import cyril.simonggame.view.Game_View;

public class GameActivity extends Activity {
    static Game_View game_View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        game_View = new Game_View(this);
        setContentView(game_View);
    }

}
