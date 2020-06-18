package gui;

import code.Main;
import code.MainExtenstion;
import code.Pilkarz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class InitSoccer {
    private JTextField textField1;
    private JTextField textField2;
    private JButton stworzPilkarzaButton;
    public JPanel mainPanel;
    public static String initSoccerName;
    public static String initSoccerSurname;

    public InitSoccer() {
        stworzPilkarzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initSoccerName = textField1.getText();
                initSoccerSurname = textField2.getText();

                System.out.println("Name: " + initSoccerName + " Surname: " + initSoccerSurname);
                JFrame jFrame = new JFrame("Dodawanie pilkarza");
                jFrame.setContentPane(new AddSoccer().mainPanel);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                jFrame.setLocationRelativeTo(null);
                jFrame.setVisible(true);
            }
        });
    }
}
