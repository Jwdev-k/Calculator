package calc;

import calc.enums.EOperator;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Apr 27 17:33:35 KST 2022
 */

/**
 * @author GomGom
 */
public class CalcFrame extends JFrame {
    private final StringBuilder sb = new StringBuilder();
    private final ArrayList<String> calcHistory = new ArrayList<>(); //계산 했던 목록.

    public CalcFrame() {
        initComponents();
        calc.setBackground(Color.DARK_GRAY); // 버튼을 배열으로 하면 코드 짧아짐
        calc.setForeground(new Color(187,187,187));
        button1.setBackground(new Color(60,63,65));
        button1.setForeground(new Color(187,187,187));
        button2.setBackground(new Color(60,63,65));
        button2.setForeground(new Color(187,187,187));
        button3.setBackground(new Color(60,63,65));
        button3.setForeground(new Color(187,187,187));
        button4.setBackground(new Color(60,63,65));
        button4.setForeground(new Color(187,187,187));
        button5.setBackground(new Color(60,63,65));
        button5.setForeground(new Color(187,187,187));
        button6.setBackground(new Color(60,63,65));
        button6.setForeground(new Color(187,187,187));
        button7.setBackground(new Color(60,63,65));
        button7.setForeground(new Color(187,187,187));
        button8.setBackground(new Color(60,63,65));
        button8.setForeground(new Color(187,187,187));
        button9.setBackground(new Color(60,63,65));
        button9.setForeground(new Color(187,187,187));
        button10.setBackground(new Color(60,63,65));
        button10.setForeground(new Color(187,187,187));
        button11.setBackground(new Color(60,63,65));
        button11.setForeground(new Color(187,187,187));
        button12.setBackground(new Color(60,63,65));
        button12.setForeground(new Color(187,187,187));
        button13.setBackground(new Color(60,63,65));
        button13.setForeground(new Color(187,187,187));
        button14.setBackground(new Color(60,63,65));
        button14.setForeground(new Color(187,187,187));
        button15.setBackground(new Color(60,63,65));
        button15.setForeground(new Color(187,187,187));
        button16.setBackground(new Color(60,63,65));
        button16.setForeground(new Color(187,187,187));
        button17.setBackground(new Color(60,63,65));
        button17.setForeground(new Color(187,187,187));
        setVisible(true);
    }

    private void setText(String t) {
        int count = 0;
        sb.append(t);
        for (int i = 1; i < sb.toString().length(); i++) { //연산자 갯수 체크
            if(sb.toString().charAt(i) == '+') {
                count++;
            }
            if(sb.toString().charAt(i) == '-') {
                count++;
            }
            if(sb.toString().charAt(i) == '×') {
                count++;
            }
            if(sb.toString().charAt(i) == '÷') {
                count++;
            }
        }
       if (count > 1) { // 연산자가 두개이상 입력될경우 하나 지우고 계산후 결과 출력
           sb.deleteCharAt(sb.length() - 1); // 연산자가 두개일때 작동하므로 입력시 한줄 지워야 이전 연산자를 알수있음
           String last = String.valueOf(sb.charAt(sb.length() - 1));
           if (last.equals("+") || last.equals("-") || last.equals("×") || last.equals("÷")) { //마지막 값이 연산자인데 또 연산자를 입력했을경우 지우고 바꿈
               sb.deleteCharAt(sb.length() - 1);
               sb.append(t);
               calc.setText(sb.toString());
               return;
           }
           if (sb.length() > 0) { // 1 + 1 입력후 또 연산자 를 입력하면 마지막 값 지우고 계산후 다음 입력값에 결과값과 연산자를 넘겨줌.
               result(sb.toString());
               sb.append(t);
               calc.setText(sb.toString());
           }
       } else {
           calc.setText(sb.toString());
       }
    }

    private void delete(){
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            calc.setText(sb.toString());
        }
    }

    private void result(String t) {
        calcHistory.add(t);
        try {
            String calcdata = null;
            int idx = 0;
            if (t.contains("+")) {
                idx = t.indexOf("+");
                CalcData cd = new CalcData(Integer.parseInt(t.substring(0, idx)), Integer.parseInt(t.substring(idx+1)), EOperator.plus);
                calcdata = String.valueOf(cd.calc());
            } else if (t.contains("-")) {
                idx = t.indexOf("-");
                CalcData cd = new CalcData(Integer.parseInt(t.substring(0, idx)), Integer.parseInt(t.substring(idx+1)), EOperator.minus);
                calcdata = String.valueOf(cd.calc());
            } else if (t.contains("×")) {
                idx = t.indexOf("×");
                CalcData cd = new CalcData(Integer.parseInt(t.substring(0, idx)), Integer.parseInt(t.substring(idx+1)), EOperator.multiply);
                calcdata = String.valueOf(cd.calc());
            } else if (t.contains("÷")) {
                idx = t.indexOf("÷");
                CalcData cd = new CalcData(Integer.parseInt(t.substring(0, idx)), Integer.parseInt(t.substring(idx+1)), EOperator.division);
                calcdata = String.valueOf(cd.calc());
            }
            sb.setLength(0);
            if (calcdata != null) {
                calc.setText(calcdata);
                sb.append(calcdata);
            } else {
                calc.setText("ERROR");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void buttonKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 96 -> setText("0");
            case 97 -> setText("1");
            case 98 -> setText("2");
            case 99 -> setText("3");
            case 100 -> setText("4");
            case 101 -> setText("5");
            case 102 -> setText("6");
            case 103 -> setText("7");
            case 104 -> setText("8");
            case 105 -> setText("9");
            case 106 -> setText("×");
            case 107 -> setText("+");
            case 109 -> setText("-");
            case 111 -> setText("÷");
            case 10 -> result(sb.toString());
            case 8 -> delete();
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        delete();
    }

    private void button2MouseClicked(MouseEvent e) {
        sb.setLength(0);
        calc.setText("");
    }

    private void button3MouseClicked(MouseEvent e) {
        setText("÷");
    }

    private void button4MouseClicked(MouseEvent e) {
        setText("×");
    }

    private void button5MouseClicked(MouseEvent e) {
        setText("7");
    }

    private void button6MouseClicked(MouseEvent e) {
        setText("8");
    }

    private void button7MouseClicked(MouseEvent e) {
        setText("9");
    }

    private void button8MouseClicked(MouseEvent e) {
        setText("-");
    }

    private void button9MouseClicked(MouseEvent e) {
        setText("4");
    }

    private void button10MouseClicked(MouseEvent e) {
        setText("5");
    }

    private void button11MouseClicked(MouseEvent e) {
        setText("6");
    }

    private void button12MouseClicked(MouseEvent e) {
        setText("+");
    }

    private void button13MouseClicked(MouseEvent e) {
        setText("1");
    }

    private void button14MouseClicked(MouseEvent e) {
        setText("2");
    }

    private void button15MouseClicked(MouseEvent e) {
        setText("3");
    }

    private void button16MouseClicked(MouseEvent e) {
        result(sb.toString());
    }

    private void button17MouseClicked(MouseEvent e) {
        setText("0");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        calc = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        button14 = new JButton();
        button15 = new JButton();
        button16 = new JButton();
        button17 = new JButton();

        //======== this ========
        setTitle("Calculator");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(60, 63, 64));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        var contentPane = getContentPane();

        //---- calc ----
        calc.setEditable(false);
        calc.setFont(new Font("\ub9d1\uc740 \uace0\ub515", calc.getFont().getStyle() & ~Font.BOLD, 30));
        calc.setLineWrap(true);
        calc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });

        //---- button1 ----
        button1.setText("\u2190");
        button1.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });

        //---- button2 ----
        button2.setText("AC");
        button2.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("/");
        button3.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        //---- button4 ----
        button4.setText("X");
        button4.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });

        //---- button5 ----
        button5.setText("7");
        button5.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
            }
        });

        //---- button6 ----
        button6.setText("8");
        button6.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });

        //---- button7 ----
        button7.setText("9");
        button7.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button7MouseClicked(e);
            }
        });

        //---- button8 ----
        button8.setText("-");
        button8.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button8MouseClicked(e);
            }
        });

        //---- button9 ----
        button9.setText("4");
        button9.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button9MouseClicked(e);
            }
        });

        //---- button10 ----
        button10.setText("5");
        button10.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button10.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button10MouseClicked(e);
            }
        });

        //---- button11 ----
        button11.setText("6");
        button11.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button11.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button11MouseClicked(e);
            }
        });

        //---- button12 ----
        button12.setText("+");
        button12.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button12.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button12MouseClicked(e);
            }
        });

        //---- button13 ----
        button13.setText("1");
        button13.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button13.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button13MouseClicked(e);
            }
        });

        //---- button14 ----
        button14.setText("2");
        button14.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button14.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button14.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button14MouseClicked(e);
            }
        });

        //---- button15 ----
        button15.setText("3");
        button15.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button15.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button15.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button15MouseClicked(e);
            }
        });

        //---- button16 ----
        button16.setText("=");
        button16.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button16.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button16.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button16MouseClicked(e);
            }
        });

        //---- button17 ----
        button17.setText("0");
        button17.setFont(new Font("\ub9d1\uc740 \uace0\ub515", Font.PLAIN, 20));
        button17.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        button17.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button17MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button8, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button13, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button14, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button15, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addComponent(button17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button16, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(calc, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button10, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button11, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button12, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {button1, button10, button11, button12, button13, button14, button15, button16, button2, button3, button4, button5, button6, button7, button8, button9});
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(calc, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button10, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button11, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button12, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button13, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button14, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button15, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button17, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addComponent(button16, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JTextArea calc;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
