package com.example.khlopunov.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_0;
    private Button btn_clear;
    private Button btn_multiply;
    private Button btn_plus;
    private Button btn_minus;
    private Button btn_divide;
    private Button btn_comma;
    private Button btn_equals;
    private TextView tv_text;
    private String text="0";
    boolean nullChecked =false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CalculatorDecision decision = new CalculatorDecision();

        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);
        btn_3= (Button) findViewById(R.id.btn_3);
        btn_4= (Button) findViewById(R.id.btn_4);
        btn_5= (Button) findViewById(R.id.btn_5);
        btn_6= (Button) findViewById(R.id.btn_6);
        btn_7= (Button) findViewById(R.id.btn_7);
        btn_8= (Button) findViewById(R.id.btn_8);
        btn_9= (Button) findViewById(R.id.btn_9);
        btn_0= (Button) findViewById(R.id.btn_0);
        btn_clear= (Button) findViewById(R.id.btn_C);
        btn_multiply= (Button) findViewById(R.id.btn_multiply);
        btn_plus= (Button) findViewById(R.id.btn_plus);
        btn_minus= (Button) findViewById(R.id.btn_minus);
        btn_divide= (Button) findViewById(R.id.btn_divide);
        btn_comma= (Button) findViewById(R.id.btn_comma);
        btn_equals= (Button) findViewById(R.id.btn_equals);
        tv_text= (TextView) findViewById(R.id.tv_text);
        tv_text.setText(text);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('1');
                tv_text.setText(text);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('2');
                tv_text.setText(text);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('3');
                tv_text.setText(text);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('4');
                tv_text.setText(text);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('5');
                tv_text.setText(text);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('6');
                tv_text.setText(text);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('7');
                tv_text.setText(text);
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('8');
                tv_text.setText(text);
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('9');
//                text+="9";
                tv_text.setText(text);
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumeral('0');
                tv_text.setText(text);
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation('+');
                tv_text.setText(text);
            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation('*');
                tv_text.setText(text);
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation('-');
                tv_text.setText(text);
            }
        });
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOperation('/');
                tv_text.setText(text);
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text="0";
                tv_text.setText(text);
                nullChecked=false;
            }
        });
        btn_comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text.length()==0) text+="0,";
                else text+=",";
                tv_text.setText(text);
                nullChecked=true;
            }
        });
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char lastSymbol = text.charAt(text.length()-1);
                if(!(lastSymbol>='0'&&text.length()>0&&lastSymbol<='9')) text= text.substring(0, text.length()-1);
                tv_text.setText(decision.getResult(text));
                text=tv_text.getText().toString();
            }
        });
    }

    private void addOperation(char operation){
        checkedError();
        if(text.length()==0) text+=0;
        char lastSymbol = text.charAt(text.length()-1);
        if(lastSymbol>='0'&&lastSymbol<='9') text+= operation;
        else {
            text=text.substring(0,text.length()-1) + operation;
        }
        nullChecked=false;
    }
    private void addNumeral(char numeral){
        checkedError();
        if (nullChecked) text+=numeral;
        else {
            if (text.charAt(text.length()-1)=='0'){
                text=text.substring(0,text.length()-1) + numeral;
                if(numeral!='0')nullChecked=true;
            }
            else{
                text+=numeral;
                if(numeral!='0')nullChecked=true;
            }
        }
    }
    private void checkedError(){
        System.out.println(tv_text.getText());
        if (tv_text.getText().equals("Error")) tv_text.setText("0");

    }
}
