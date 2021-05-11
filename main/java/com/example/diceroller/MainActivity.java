package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText diceRollString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dice Roll String EditText
        diceRollString= (EditText) findViewById(R.id.diceRollString);
        diceRollString.setOnEditorActionListener(diceKeyboardListener);


        diceKeyboardNum diceKeyboard = (diceKeyboardNum) findViewById(R.id.keyboard);
        
        // ------------------------------
        // ---  Custom Roll Keyboard  ---

        // prevent system keyboard from appearing when EditText is tapped
        diceRollString.setRawInputType(InputType.TYPE_CLASS_TEXT);
        diceRollString.setTextIsSelectable(true);

        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = diceRollString.onCreateInputConnection(new EditorInfo());
        diceKeyboard.setInputConnection(ic);
        // ------------------------------


        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        
    }

    private TextView.OnEditorActionListener diceKeyboardListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
            rollDices(textView);
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void rollDices(View view) {

        if(!diceRollString.getText().toString().isEmpty()){
            try {
                String diceRoll = diceRollString.getText().toString();
                ((TextView)findViewById(R.id.resultWindow)).setText(printRoll(diceRoll));
                ((TextView)findViewById(R.id.resultWindow2)).setText(DiceResult.diceRoll(diceRoll).fullResultString());
                ((EditText)findViewById(R.id.diceRollString)).setText("");
            } catch (Exception e) {
                ((TextView)findViewById(R.id.resultWindow)).setText("");
                ((TextView)findViewById(R.id.resultWindow2)).setText(R.string.invalid_input_message);
                clearDiceRolLString(view);
            }
        }

    }

    public void clearDiceRolLString(View view) {
        ((EditText)findViewById(R.id.diceRollString)).setText("");
    }

    private String printRoll(String diceRoll){
        return getResources().getString(R.string.roll_colon).concat(DiceStringReader.formatString(diceRoll));
    }



}