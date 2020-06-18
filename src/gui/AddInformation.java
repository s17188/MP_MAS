package gui;

import controllers.AddInformationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddInformation {
    private JTextField zalacznik;
    private JTextField video;
    private JTextField pozycja;
    private JTextField dataMeczu;
    private JTextField stadion;
    private JTextField czasGry;
    private JTextField kartaCzerwona;
    private JTextField kartaZolta;
    private JButton dodajPilkarzaButton;
    public JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JTabbedPane jtab;
    private JPanel panelTab;
    private JPanel panelTab1;
    private JPanel panelTab2;
    private JTextField dataMeczu2;
    private JTextField stadion2;
    private JTextField czasgry2;
    private JTextField kartkaczerwona2;
    private JTextField kartkazolta2;
    private JTextField dataMeczu3;
    private JTextField stadion3;
    private JTextField czasGry3;
    private JTextField kartkaCzerwona3;
    private JTextField kartkaZolta3;
    private JPanel repeater;
    public static int counter = 1;

    public AddInformation() {
        dodajPilkarzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddInformationController.AddInformtaion(
                        zalacznik.getText(),video.getText(),pozycja.getText(),
                        dataMeczu.getText(),stadion.getText(),czasGry.getText(),kartaCzerwona.getText(),kartaZolta.getText(),
                        dataMeczu2.getText(),stadion2.getText(),czasgry2.getText(),kartkaczerwona2.getText(),kartkazolta2.getText(),
                        dataMeczu3.getText(),stadion3.getText(),czasGry3.getText(),kartkaCzerwona3.getText(),kartkaZolta3.getText()
                );

                JFrame jFrame3 = new JFrame("Lista pilkarzy");
                jFrame3.setContentPane(new SoccersList().mainPanel);
                jFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame3.pack();
                jFrame3.setSize(300,400);
                jFrame3.setLocationRelativeTo(null);
                jFrame3.setVisible(true);

            }
        });
    }
}
