package gui;

import code.Pilkarz;
import controllers.AddSoccerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Label.setText(InitSoccer.initSoccerName + " " + InitSoccer.initSoccerSurname);
        zapiszDaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soccer = AddSoccerController.AddSoccer(
                        birthdate.getText(),nationality.getText(),height.getText(),
                        weight.getText(),club.getText(),String.valueOf(comboBox1.getSelectedItem()),
                        price.getText(),desc.getText(),city.getText(),street.getText(),buildNo.getText());

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
