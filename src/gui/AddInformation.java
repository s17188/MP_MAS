package gui;

import code.*;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.scene.shape.Box;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

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
                Zalacznik_Pilkarz zalacznikOb = new Zalacznik_Pilkarz(zalacznik.getText());
                Video_Pilkarz videoOb = new Video_Pilkarz(video.getText());
                Pozycja_Pilkarz position = new Pozycja_Pilkarz(pozycja.getText(),AddSoccer.soccer.club);


                AddSoccer.soccer.addAttachment(zalacznikOb);
                AddSoccer.soccer.addVideo(videoOb);
                AddSoccer.soccer.setPosition(position);

                System.out.println(AddSoccer.soccer);

                if(dataMeczu.getText().length() > 0){
                    LocalDate date = LocalDate.parse(dataMeczu.getText());
                    Mecz mecz = new Mecz(date,stadion.getText());
                    PilkarzMecz pilkarzmecz = new PilkarzMecz(Integer.parseInt(czasGry.getText()),Integer.parseInt(kartaCzerwona.getText()),Integer.parseInt(kartaZolta.getText()),AddSoccer.soccer,mecz);
                }

                if(dataMeczu2.getText().length() > 0){
                    LocalDate date2 = LocalDate.parse(dataMeczu2.getText());
                    Mecz mecz2 = new Mecz(date2,stadion2.getText());
                    PilkarzMecz pilkarzmecz2 = new PilkarzMecz(Integer.parseInt(czasgry2.getText()),Integer.parseInt(kartkaczerwona2.getText()),Integer.parseInt(kartkazolta2.getText()),AddSoccer.soccer,mecz2);
                }
                if(dataMeczu3.getText().length() > 0){
                    LocalDate date3 = LocalDate.parse(dataMeczu3.getText());
                    Mecz mecz3 = new Mecz(date3,stadion3.getText());
                    PilkarzMecz pilkarzmecz3 = new PilkarzMecz(Integer.parseInt(czasGry3.getText()),Integer.parseInt(kartkaCzerwona3.getText()),Integer.parseInt(kartkaZolta3.getText()),AddSoccer.soccer,mecz3);
                }

                try {
                    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(Main.file)));
                    MainExtenstion.write(out);
                    MainExtenstion.showExtent();
                    MainExtenstion.getExtent(Agent.class);
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

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
