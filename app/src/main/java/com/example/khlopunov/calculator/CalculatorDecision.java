package com.example.khlopunov.calculator;

import java.util.ArrayList;

/**
 * Created by Admin on 22.09.2016.
 */

public class CalculatorDecision {
    ArrayList <String>  data = new ArrayList<>();

    String numeral="";
    String answer;
    boolean err=false;


    public String getResult(String message) {
        data.clear();
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i)!='+'&&(message.charAt(i)!='-'||i==0)&&message.charAt(i)!='*'&&message.charAt(i)!='/')
            numeral+=message.charAt(i);
            else {
                data.add(numeral);
                data.add(String.valueOf(message.charAt(i)));
                numeral="";
            }
        }
        data.add(numeral);
        numeral="";
        while (data.size()!=1){
            doDecide();
        }
        if(err) return "Error";
            else return data.get(0);
    }

    public void doDecide(){

        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).equals("*")||data.get(i).equals("/")){


                if(data.get(i).equals("*")) answer=String.valueOf(multiply(Double.parseDouble(data.get(i-1)), Double.parseDouble(data.get(i+1))));
                if(data.get(i).equals("/")) answer =String.valueOf(divide(Double.parseDouble(data.get(i-1)), Double.parseDouble(data.get(i+1))));
                data.set(i-1, answer);
                data.remove(i);
                data.remove(i);
                answer="";
                doDecide();
            }

        }
        for (int i = 1; i < data.size(); i++) {
            if(data.get(i).equals("+")||data.get(i).equals("-")){
                if(data.get(i).equals("+")) answer=String.valueOf(plus(Double.parseDouble(data.get(i-1)), Double.parseDouble(data.get(i+1))));
                if(data.get(i).equals("-")) answer =String.valueOf(minus(Double.parseDouble(data.get(i-1)), Double.parseDouble(data.get(i+1))));
                data.set(i-1, answer);
                data.remove(i);
                data.remove(i);
                answer="";
                doDecide();
            }
        }
    }

    private double multiply(double a,double b) {
        return a*b;
    }
    private double divide(double a,double b) {
        if(b==0) {
            err=true;
            return 0;
        }
            else return a/b;
    }
    private double minus(double a,double b) {
        return a-b;
    }
    private double plus(double a,double b) {
        return a+b;
    }
}
