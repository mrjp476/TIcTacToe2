package edu.mtsu.csci3033.tictactoe2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.media.MediaPlayer;


import static edu.mtsu.csci3033.tictactoe2.R.id.board;

public class MainActivity extends AppCompatActivity {
    private BoardView boardView;
    private GameEngine gameEngine;
    private int tracku = 0;
    private int trackb = 0;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer click = MediaPlayer.create(MainActivity.this,R.raw.ding);
        boardView = (BoardView) findViewById(board);
        gameEngine = new GameEngine();
        boardView.setGameEngine(gameEngine);
        boardView.setMainActivity(this);
        click.setVolume(100,100);
        click.start();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.action_new_game) {
            newGame();
        }
        return super.onOptionsItemSelected(item);
    }

    public void gameEnded(char c){
        String msg = (c=='T') ? "Game Ended in a Tie" : "Game Over " + c + " wins!!";
        if(c=='X'){
            tracku+=1;
            Toast.makeText(MainActivity.this,tracku+" = Score = "+trackb,Toast.LENGTH_SHORT).show();
        }
        else if(c=='O'){
            trackb+=1;
            Toast.makeText(MainActivity.this,tracku+" = Score = "+trackb,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this,tracku+" = Score = "+trackb,Toast.LENGTH_SHORT).show();
        }

        new AlertDialog.Builder(this).setTitle("Tic Tac Toe").
                setMessage(msg).
                setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        newGame();
                    }

                }).show();
    }
    public void newGame(){
        gameEngine.newGame();
        boardView.invalidate();
    }

}
