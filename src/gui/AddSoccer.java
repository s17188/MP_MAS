package gui;

import code.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.List;

public class AddSoccer {
    public JPanel mainPanel;
    private JLabel label;
    private JTextField birthdate;
    private JTextField height;
    private JTextField weight;
    private JTextField nationality;
    private JTextField club;
    private JTextField price;
    private JTextArea desc;
    private JComboBox comboBox1;
    private JButton zapiszDaneButton;
    private JLabel Label;
    private JTextField city;
    private JTextField street;
    private JTextField buildNo;
    public static Pilkarz soccer;

    public AddSoccer() {
        int countId=0;
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(Main.file)));
            MainExtenstion.read(in);
            countId = MainExtenstion.getCount(Pilkarz.class);
        } catch (Exception exception) {
            countId = 0;
        }

        Label.setText(InitSoccer.initSoccerName + " " + InitSoccer.initSoccerSurname);
        int finalCountId = countId;
        zapiszDaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adres adres = new Adres(city.getText(),street.getText(),buildNo.getText());
                String date = birthdate.getText();
                soccer = new Pilkarz(finalCountId,
                        InitSoccer.initSoccerName,
                        InitSoccer.initSoccerSurname,
                        LocalDate.parse(date),
                        adres,
                        nationality.getText(),
                        Integer.parseInt(height.getText()),
                        Integer.parseInt(weight.getText()),
                        club.getText(),
                        String.valueOf(comboBox1.getSelectedItem()),
                        Integer.parseInt(price.getText()));
                soccer.setDesc(desc.getText());

                List<Agent> list = Agent.getExtent(Agent.class);

                for(Agent o: list){
                    System.out.println("Agent " + o);
                    if(o.getId() == Main.agent.getId()) {
                        o.addSoccer(soccer);
                    }
                }

                System.out.println(soccer.toString());

                JFrame jFrame2 = new JFrame("Dodawanie pilkarza");
                jFrame2.setContentPane(new AddInformation().mainPanel);
                jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame2.pack();
                jFrame2.setLocationRelativeTo(null);
                jFrame2.setVisible(true);
            }
        });
    }

}
