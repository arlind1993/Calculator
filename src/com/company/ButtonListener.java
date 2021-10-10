package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextField textField;
    private JTextField resultField;
    private String name;

    public ButtonListener(JTextField textField,JTextField resultField, String name) {
        this.textField=textField;
        this.resultField=resultField;
        this.name=name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(name);
        if (!name.equals("Clear")){
            if (!name.equals("=")) {
                if (!name.equals("( )")) {
                    textField.setText(textField.getText() + name);
                }else {
                    int countLeftParenthesis=0;
                    int countRightParenthesis=0;
                    for (int i = 0; i < textField.getText().length(); i++) {
                        if(textField.getText().charAt(i)=='('){
                            countLeftParenthesis++;
                        }else if (textField.getText().charAt(i)==')'){
                            countRightParenthesis++;
                        }
                    }
                    if (countLeftParenthesis>countRightParenthesis){
                        textField.setText(textField.getText() + ')');
                    }else{
                        textField.setText(textField.getText() + '(');
                    }
                }
            }else {
                Calculator.calculate(resultField,textField);
            }
        }else{
            textField.setText("");
            resultField.setText("");
        }
    }

}
