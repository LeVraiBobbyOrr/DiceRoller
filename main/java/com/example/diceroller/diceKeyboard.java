package com.example.diceroller;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

public class diceKeyboard extends LinearLayout implements View.OnClickListener {

    // constructors
    public diceKeyboard(Context context) {
        this(context, null, 0);
    }

    public diceKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public diceKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // keyboard keys (buttons)
    private Button mButtond4;
    private Button mButtond10;
    private Button mButtond;

    private Button mButtond6;
    private Button mButtond12;
    private Button mButtonPlus;

    private Button mButtond8;
    private Button mButtond20;
    private Button mButtonMinus;

    private Button mButtonDelete;
    private Button mButtonEnter;

    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    SparseArray<String> keyValues = new SparseArray<>();

    // Our communication link to the EditText
    InputConnection inputConnection;

    private void init(Context context, AttributeSet attrs) {

        // initialize buttons
        LayoutInflater.from(context).inflate(R.layout.dice_keyboard, this, true);

        mButtond4 = (Button) findViewById(R.id.button_d4);
        mButtond10 = (Button) findViewById(R.id.button_d10);
        mButtond = (Button) findViewById(R.id.button_d);

        mButtond6 = (Button) findViewById(R.id.button_d6);
        mButtond12 = (Button) findViewById(R.id.button_d12);
        mButtonPlus = (Button) findViewById(R.id.button_plus);

        mButtond8 = (Button) findViewById(R.id.button_d8);
        mButtond20 = (Button) findViewById(R.id.button_d20);
        mButtonMinus = (Button) findViewById(R.id.button_minus);

        mButtonDelete = (Button) findViewById(R.id.button_delete);
        mButtonEnter = (Button) findViewById(R.id.button_enter);

        // set button click listeners
        mButtond4.setOnClickListener(this);
        mButtond10.setOnClickListener(this);
        mButtond.setOnClickListener(this);

        mButtond6.setOnClickListener(this);
        mButtond12.setOnClickListener(this);
        mButtonPlus.setOnClickListener(this);

        mButtond8.setOnClickListener(this);
        mButtond20.setOnClickListener(this);
        mButtonMinus.setOnClickListener(this);

        mButtonDelete.setOnClickListener(this);
        mButtonEnter.setOnClickListener(this);

        // map buttons IDs to input strings
        keyValues.put(R.id.button_d4, "4");
        keyValues.put(R.id.button_d10, "10");
        keyValues.put(R.id.button_d, "d");

        keyValues.put(R.id.button_d6, "6");
        keyValues.put(R.id.button_d12, "12");
        keyValues.put(R.id.button_minus, "-");

        keyValues.put(R.id.button_d8, "8");
        keyValues.put(R.id.button_d20, "20");
        keyValues.put(R.id.button_plus, "+");


        keyValues.put(R.id.button_enter, "\n");
    }

    @Override
    public void onClick(View v) {

        // do nothing if the InputConnection has not been set yet
        if (inputConnection == null) return;

        // Delete text or input key value
        // All communication goes through the InputConnection
        if (v.getId() == R.id.button_delete) {
            CharSequence selectedText = inputConnection.getSelectedText(0);
            if (TextUtils.isEmpty(selectedText)) {
                // no selection, so delete previous character
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                // delete the selection
                inputConnection.commitText("", 1);
            }
        } else {
            String value = keyValues.get(v.getId());
            inputConnection.commitText(value, 1);
        }
    }

    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    public void setInputConnection(InputConnection ic) {
        this.inputConnection = ic;
    }
}