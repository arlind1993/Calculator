package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args){


        JFrame frame=new JFrame();
        frame.setLayout(null);
        frame.setSize(250,400);
        frame.getContentPane().setBackground(new Color(54,54,54));
        frame.setFont(new Font("",Font.PLAIN,20));
        frame.setResizable(true);
        frame.setTitle("Calculator");

        JTextField textField=new JTextField();
        textField.setBounds(10,10,215,30);
        textField.setBackground(new Color(150,150,150));
        frame.add(textField);

        JTextField resultField=new JTextField();
        resultField.setBounds(10,40,215,20);
        resultField.setBackground(new Color(150,150,150));
        frame.add(resultField);

        List<JButton> buttonList=new ArrayList<>();
        int xInitialPosition=10;
        int yInitialPosition=70;
        int xButtonPos=xInitialPosition;
        int yButtonPos=yInitialPosition;
        int buttonWidth=50;
        int buttonHeight=50;
        int xOffset=5;
        int yOffset=5;
        String value="";
        for (int i = 0; i < 16; i++) {
            switch (i) {
                case 0:
                    value += '1';
                    break;
                case 1:
                    value += '2';
                    break;
                case 2:
                    value += '3';
                    break;
                case 3:
                    value += '+';
                    break;
                case 4:
                    value += '4';
                    break;
                case 5:
                    value += '5';
                    break;
                case 6:
                    value += '6';
                    break;
                case 7:
                    value += '-';
                    break;
                case 8:
                    value += '7';
                    break;
                case 9:
                    value += '8';
                    break;
                case 10:
                    value += '9';
                    break;
                case 11:
                    value += '*';
                    break;
                case 12:
                    value += "( )";
                    break;
                case 13:
                    value += '0';
                    break;
                case 14:
                    value += '=';
                    break;
                case 15:
                    value += '/';
                    break;
            }
            buttonList.add(new JButton(value));
            buttonList.get(i).setBackground(new Color(220,220,220));
            buttonList.get(i).setBounds(xButtonPos,yButtonPos,buttonWidth,buttonHeight);

            buttonList.get(i).addActionListener(new ButtonListener(textField,resultField,buttonList.get(i).getText()));



            frame.add(buttonList.get(i));
            if (i%4==3){
                xButtonPos=xInitialPosition;
                yButtonPos=yButtonPos+buttonHeight+yOffset;
            }else {
                xButtonPos=xButtonPos+buttonWidth+xOffset;
            }
            value="";
        }

        JButton buttonClear=new JButton("Clear");
        buttonClear.setBounds(10,yButtonPos+yOffset,215,50);
        buttonClear.setBackground(new Color(220,220,220));
        buttonClear.addActionListener(new ButtonListener(textField,resultField,buttonClear.getText()));
        frame.add(buttonClear);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
