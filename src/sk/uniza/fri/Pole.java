package sk.uniza.fri;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.Random;
//import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;

import static java.awt.BorderLayout.NORTH;

/**
 * 24.11.2021 - 9:23
 *
 * @author Andrej
 */
public class Pole implements ActionListener {

    private Random random = new Random();
    private JFrame frame = new JFrame();
    private JPanel title = new JPanel();
    private JPanel tlacitkovy = new JPanel();
    private JLabel textfield = new JLabel();
    private JButton[] tlacitok = new JButton[9];
    private boolean hrac1Pohyb;


    Pole() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 800);
        this.frame.getContentPane().setBackground(Color.red);
        this.frame.setLayout(new BorderLayout());
        this.frame.setVisible(true);

        this.textfield.setBackground(Color.blue);
        this.textfield.setForeground(Color.green);
        this.textfield.setHorizontalAlignment(JLabel.CENTER);
        this.textfield.setText("Piskvorky");
        this.textfield.setOpaque(true);

        this.title.setLayout(new BorderLayout());
        this.title.setBounds(0, 0, 800, 100 );

        this.tlacitkovy.setLayout(new GridLayout(3, 3));
        this.tlacitkovy.setBackground(new Color(150, 150, 25));

        for (int i = 0 ; i < 9 ; i++) {
            this.tlacitok[i] = new JButton();
            this.tlacitkovy.add(this.tlacitok[i]);
            this.tlacitok[i].setFocusable(false);
            this.tlacitok[i].addActionListener(this); }


        this.title.add(this.textfield);
        this.frame.add(this.title, NORTH);
        this.frame.add(this.tlacitkovy);

        this.prvyTah();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == this.tlacitok[i]) {
                if (this.hrac1Pohyb) {
                    if (this.tlacitok[i].getText().equals("")) {
                        this.tlacitok[i].setForeground(new Color(255, 0, 0));
                        this.tlacitok[i].setText("X");
                        this.hrac1Pohyb = false;//
                        this.textfield.setText("O tah");
                        this.kontrola();
                    }
                } else {
                    if (this.tlacitok[i].getText().equals("")) {
                        this.tlacitok[i].setForeground(new Color(0, 0, 255));
                        this.tlacitok[i].setText("O");
                        this.hrac1Pohyb = true;
                        this.textfield.setText("X tah");
                        this.kontrola();
                    }
                }
            }
        }
    }


    public void prvyTah() {
        if (this.random.nextInt(2) == 0) {
            this.hrac1Pohyb = true;
            this.textfield.setText("X na ťahu");
        } else {
            this.hrac1Pohyb = false;
            this.textfield.setText("O na ťahu");
        }

    }

    public void kontrola() {
        //X
        if (
                (this.tlacitok[0].getText().equals("X")) &&
                (this.tlacitok[1].getText().equals("X")) &&
                        (this.tlacitok[2].getText().equals("X"))
        ) {
            this.vyhraX(0, 1, 2);
        }

        if (
                (this.tlacitok[3].getText().equals("X")) &&
                        (this.tlacitok[4].getText().equals("X")) &&
                        (this.tlacitok[5].getText().equals("X"))
        ) {
            this.vyhraX(3, 4, 5);
        }

        if (
                (this.tlacitok[6].getText().equals("X")) &&
                        (this.tlacitok[7].getText().equals("X")) &&
                        (this.tlacitok[8].getText().equals("X"))
        ) {
            this.vyhraX(6, 7, 8);
        }

        if (
                (this.tlacitok[0].getText().equals("X")) &&
                        (this.tlacitok[3].getText().equals("X")) &&
                        (this.tlacitok[6].getText().equals("X"))
        ) {
            this.vyhraX(0, 3, 6);
        }

        if (
                (this.tlacitok[1].getText().equals("X")) &&
                        (this.tlacitok[4].getText().equals("X")) &&
                        (this.tlacitok[7].getText().equals("X"))
        ) {
            this.vyhraX(1, 4, 7);
        }

        if (
                (this.tlacitok[2].getText().equals("X")) &&
                        (this.tlacitok[5].getText().equals("X")) &&
                        (this.tlacitok[8].getText().equals("X"))
        ) {
            this.vyhraX(2, 5, 8);
        }

        if (
                (this.tlacitok[0].getText().equals("X")) &&
                        (this.tlacitok[4].getText().equals("X")) &&
                        (this.tlacitok[8].getText().equals("X"))
        ) {
            this.vyhraX(0, 4, 8);
        }

        if (
                (this.tlacitok[2].getText().equals("X")) &&
                        (this.tlacitok[4].getText().equals("X")) &&
                        (this.tlacitok[6].getText().equals("X"))
        ) {
            this.vyhraX(2, 4, 6);
        }

        //O
        if (
                (this.tlacitok[0].getText().equals("O")) &&
                        (this.tlacitok[1].getText().equals("O")) &&
                        (this.tlacitok[2].getText().equals("O"))
        ) {
            this.vyhraO(0, 1, 2);
        }

        if (
                (this.tlacitok[3].getText().equals("O")) &&
                        (this.tlacitok[4].getText().equals("O")) &&
                        (this.tlacitok[5].getText().equals("O"))
        ) {
            this.vyhraO(3, 4, 5);
        }

        if (
                (this.tlacitok[6].getText().equals("O")) &&
                        (this.tlacitok[7].getText().equals("O")) &&
                        (this.tlacitok[8].getText().equals("O"))
        ) {
            this.vyhraO(6, 7, 8);
        }

        if (
                (this.tlacitok[0].getText().equals("O")) &&
                        (this.tlacitok[3].getText().equals("O")) &&
                        (this.tlacitok[6].getText().equals("O"))
        ) {
            this.vyhraO(0, 3, 6);
        }

        if (
                (this.tlacitok[1].getText().equals("O")) &&
                        (this.tlacitok[4].getText().equals("O")) &&
                        (this.tlacitok[7].getText().equals("O"))
        ) {
            this.vyhraO(1, 4, 7);
        }

        if (
                (this.tlacitok[2].getText().equals("O")) &&
                        (this.tlacitok[5].getText().equals("O")) &&
                        (this.tlacitok[8].getText().equals("O"))
        ) {
            this.vyhraO(2, 5, 8);
        }

        if (
                (this.tlacitok[0].getText().equals("O")) &&
                        (this.tlacitok[4].getText().equals("O")) &&
                        (this.tlacitok[8].getText().equals("O"))
        ) {
            this.vyhraO(0, 4, 8);
        }

        if (
                (this.tlacitok[2].getText().equals("O")) &&
                        (this.tlacitok[4].getText().equals("O")) &&
                        (this.tlacitok[6].getText().equals("O"))
        ) {
            this.vyhraO(2, 4, 6);
        }

    }

    public void vyhraX(int a, int b, int c) {
        this.tlacitok[a].setBackground(Color.green);
        this.tlacitok[b].setBackground(Color.green);
        this.tlacitok[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            this.tlacitok[i].setEnabled(false);
        }
        this.textfield.setText("X vyhralo");
    }

    public void vyhraO(int a, int b, int c) {
        this.tlacitok[a].setBackground(Color.red);
        this.tlacitok[b].setBackground(Color.red);
        this.tlacitok[c].setBackground(Color.red);
        for (int i = 0; i < 9; i++) {
            this.tlacitok[i].setEnabled(false);
        }
        this.textfield.setText("O vyhralo");
    }



}