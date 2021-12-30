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
                    }
                } else {
                    if (this.tlacitok[i].getText().equals("")) {
                        this.tlacitok[i].setForeground(new Color(0, 0, 255));
                        this.tlacitok[i].setText("O");
                        this.hrac1Pohyb = true;
                        this.textfield.setText("X tah");
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



}