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

public class diceKeyboardNum extends LinearLayout implements View.OnClickListener {

    // constructors
    public diceKeyboardNum(Context context) {
        this(context, null, 0);
    }

    public diceKeyboardNum(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public diceKeyboardNum(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // keyboard keys (buttons)
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    private Button mButton4;
    private Button mButton5;
    private Button mButton6;

    private Button mButton7;
    private Button mButton8;
    private Button mButton9;

    private Button mButtonPlus;
    private Button mButton0;
    private Button mButtonMinus;

    private Button mButtonDelete;
    private Button mButtonEnter;
    private Button mButtonD;


    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    SparseArray<String> keyValues = new SparseArray<>();

    // Our communication link to the EditText
    InputConnection inputConnection;

    private void init(Context context, AttributeSet attrs) {

        // initialize buttons
        LayoutInflater.from(context).inflate(R.layout.num_d_keyboard, this, true);

        mButton1 = (Button) findViewById(R.id.num1);
        mButton2 = (Button) findViewById(R.id.num2);
        mButton3 = (Button) findViewById(R.id.num3);

        mButton4 = (Button) findViewById(R.id.num4);
        mButton5 = (Button) findViewById(R.id.num5);
        mButton6 = (Button) findViewById(R.id.num6);

        mButton7 = (Button) findViewById(R.id.num7);
        mButton8 = (Button) findViewById(R.id.num8);
        mButton9 = (Button) findViewById(R.id.num9);

        mButtonPlus = (Button) findViewById(R.id.num_plus);
        mButton0 = (Button) findViewById(R.id.num0);
        mButtonMinus = (Button) findViewById(R.id.num_minus);

        mButtonDelete = (Button) findViewById(R.id.button_delete);
        mButtonEnter = (Button) findViewById(R.id.button_enter);
        mButtonD = (Button) findViewById(R.id.button_d);

        // set button click listeners
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);

        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);

        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);

        mButtonPlus.setOnClickListener(this);
        mButton0.setOnClickListener(this);
        mButtonMinus.setOnClickListener(this);

        mButtonDelete.setOnClickListener(this);
        mButtonEnter.setOnClickListener(this);
        mButtonD.setOnClickListener(this);

        // map buttons IDs to input strings
        keyValues.put(R.id.num1, "1");
        keyValues.put(R.id.num2, "2");
        keyValues.put(R.id.num3, "3");

        keyValues.put(R.id.num4, "4");
        keyValues.put(R.id.num5, "5");
        keyValues.put(R.id.num6, "6");

        keyValues.put(R.id.num7, "7");
        keyValues.put(R.id.num8, "8");
        keyValues.put(R.id.num9, "9");

        keyValues.put(R.id.num_plus, "+");
        keyValues.put(R.id.num0, "0");
        keyValues.put(R.id.num_minus, "-");


        keyValues.put(R.id.button_enter, "\n");
        keyValues.put(R.id.button_d, "d");
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