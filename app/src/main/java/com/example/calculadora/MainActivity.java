package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;

/**
 * this class sets all the view's funcionalities
 * @Author: João Pedro ALmeida Santos Secundino
 * */
public class MainActivity extends AppCompatActivity {
    Button b0,
            b1,
            b2,
            b3,
            b4,
            b5,
            b6,
            b7,
            b8,
            b9,
            bPoint,
            bEqual,
            bOpSum,
            bOpSub,
            bOpMul,
            bOpDiv,
            bBksp,
            bCE;
    TextView result, operator;
    EditText firstOp, secondOp, aux;
    Toast invalidOperands, invalidOperator, divisionByZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link all the view's components with java objects
        setComponents();

        //set the buttons funcs
        setButtonsFuncs();

        //create all the toasts
        invalidOperands = Toast.makeText(this, "Digite operandos válidos", Toast.LENGTH_SHORT);
        invalidOperator = Toast.makeText(this, "Digite um operador", Toast.LENGTH_SHORT);
        divisionByZero = Toast.makeText(this, "Divisão por 0: NaN", Toast.LENGTH_SHORT);
    }

    private void setComponents() {
        b0 = (Button) findViewById(R.id.button0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        bPoint = (Button) findViewById(R.id.buttonPoint);
        bEqual = (Button) findViewById(R.id.buttonEq);
        bOpSum = (Button) findViewById(R.id.buttonSum);
        bOpSub = (Button) findViewById(R.id.buttonSub);
        bOpMul = (Button) findViewById(R.id.buttonMul);
        bOpDiv = (Button) findViewById(R.id.buttonDiv);
        bBksp = (Button) findViewById(R.id.buttonDel);
        bCE = (Button) findViewById(R.id.buttonCE);
        result = (TextView) findViewById(R.id.resultado);
        operator = (TextView) findViewById(R.id.operador);
        firstOp = (EditText) findViewById(R.id.operando1);
        secondOp = (EditText) findViewById(R.id.operando2);
    }

    private void setButtonsFuncs(){

         b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //choose the EditText component to edit
                aux = firstOp.isFocused() ? firstOp : secondOp;
                //check the cursor position to append the new char
                int pos = aux.getSelectionStart();
                //insert the new char at pos
                aux.getEditableText().insert(pos, "0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, "9");
            }
        });

        bPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;

                //if a point already exists, abort
                if( pointCounter(aux.getText().toString()) >= 1) return;

                int pos = aux.getSelectionStart();
                aux.getEditableText().insert(pos, ".");
            }
        });

        bOpSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("+");
            }
        });

        bOpSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("-");
            }
        });

        bOpMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("x");
            }
        });

        bOpDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.setText("÷");
            }
        });

        bCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear all the text fields
                operator.setText("");
                firstOp.setText("");
                secondOp.setText("");
                result.setText("Resultado");
            }
        });

        bBksp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = firstOp.isFocused() ? firstOp : secondOp;
                int pos = aux.getSelectionStart();

                //if we're trying to delete an alement at the position 0, abort
                if (pos == 0) return;

                aux.getEditableText().delete(pos-1, pos);
            }
        });

        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstOpContent = firstOp.getText().toString(),
                        secondOpContent = secondOp.getText().toString();
                int lenField1 = firstOpContent.length(),
                        lenField2 = secondOpContent.length();
                boolean invalidDecimalSeparator = pointCounter(firstOpContent) > 1 || pointCounter(secondOpContent) > 1,
                        invalidLen = lenField1 == 0 || lenField2 == 0,
                        invalidOperatorContent = operator.getText().length() == 0;

                //check if the operands or operators are null or invalid
                if (invalidLen || invalidDecimalSeparator){
                    invalidOperands.show();
                    return;
                }else if (invalidOperatorContent) {
                    invalidOperator.show();
                    return;
                }


                Double op1 = Double.parseDouble(firstOp.getText().toString()),
                        op2 = Double.parseDouble(secondOp.getText().toString()),
                        res;

                switch (operator.getText().charAt(0)){
                    case '+':
                        res = op1 + op2;
                        result.setText(res.toString());
                        break;
                    case '-':
                        res = op1 - op2;
                        result.setText(res.toString());
                        break;
                    case 'x':
                        res = op1 * op2;
                        result.setText(res.toString());
                        break;
                    case '÷':
                        if(op2 == 0){
                            result.setText("nan");
                            divisionByZero.show();
                        }else{
                            res = op1 / op2;
                            result.setText(res.toString());
                        }
                        break;
                }
            }
        });

    }

    /**
     * Manual filter to check how many '.' already exists in s
     *
     */
    private int pointCounter(String s){
        int count = 0;
        for (int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '.'){
                count ++;
            }
        }
        return count;
    }


}
