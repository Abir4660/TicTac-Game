/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tic_tac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    private int player_no = 1;
    private int b[] = new int[9];

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;

    public TicTacToe() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setLayout(new GridLayout(3, 3));

        b1 = new JButton();
        b2 = new JButton();
        b3 = new JButton();
        b4 = new JButton();
        b5 = new JButton();
        b6 = new JButton();
        b7 = new JButton();
        b8 = new JButton();
        b9 = new JButton();

        addButtons();

        pack();
    }

    private void addButtons() {
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);

        b1.addActionListener(new ButtonAction(0));
        b2.addActionListener(new ButtonAction(1));
        b3.addActionListener(new ButtonAction(2));
        b4.addActionListener(new ButtonAction(3));
        b5.addActionListener(new ButtonAction(4));
        b6.addActionListener(new ButtonAction(5));
        b7.addActionListener(new ButtonAction(6));
        b8.addActionListener(new ButtonAction(7));
        b9.addActionListener(new ButtonAction(8));
    }

    private boolean checkWin(int player) {
        for (int ml = 0; ml < 7; ml += 3) {
            if (b[ml] == b[ml + 1] && b[ml] == b[ml + 2] && b[ml] == player) {
                return true;
            }
        }

        for (int ml = 0; ml < 3; ml++) {
            if (b[ml] == b[ml + 3] && b[ml] == b[ml + 6] && b[ml] == player) {
                return true;
            }
        }

        for (int ml = 0; ml < 2; ml++) {
            if (b[ml] == b[4] && b[ml] == b[8 - ml] && b[ml] == player) {
                return true;
            }
        }

        return false;
    }

    class ButtonAction implements ActionListener {
        private int pos;

        ButtonAction(int position) {
            pos = position;
        }

        public void actionPerformed(ActionEvent e) {
            JButton bx = (JButton) e.getSource();
            if (player_no == 1) {
                bx.setText("O");
                b[pos] = 1;
                if (checkWin(1)) {
                    JOptionPane.showMessageDialog(null, "Player 1 wins");
                }
                player_no = 2;
            } else {
                bx.setText("X");
                b[pos] = 2;
                if (checkWin(2)) {
                    JOptionPane.showMessageDialog(null, "Player 2 wins");
                }
                player_no = 1;
            }
            bx.setEnabled(false);

            boolean flag = true;
            for (int s = 0; s < 9; s++) {
                if (b[s] == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                JOptionPane.showMessageDialog(null, "Match has been tied");
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
