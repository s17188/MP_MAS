package gui;

import code.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SoccersList {
    public JPanel mainPanel;
    private JList list1;
    private JList list3;
    private JLabel header;

    public static Pilkarz soccer;
    public ArrayList<Pilkarz> pilkarzs = new ArrayList<>();

    public SoccersList(){

        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(Main.file)));
            MainExtenstion.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Agent> list = Agent.getExtent(Agent.class);

        for(Agent o: list){
            System.out.println("Agent " + o);
            if(o.getId() == Main.agent.getId()) {
                header.setText("Agent " + o.getname());
                for (Pilkarz p : o.getSoccers()) {
                    ((DefaultListModel) list1.getModel()).addElement(p.getName());
                    pilkarzs.add(p);
                    soccer = p;
                }
            }
        }

        MouseListener mouseListener1 = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ((DefaultListModel) list3.getModel()).clear();
                String selectedItem = (String) list1.getSelectedValue();
                int selectedId = list1.getSelectedIndex();
                soccer = pilkarzs.get(selectedId);
                    String attachmentString = " ";
                    for(Zalacznik_Pilkarz z:soccer.attachment){
                        attachmentString+= "" +  z.url + "";
                    }
                    attachmentString+="";
                    String videoString = " ";
                    for(Video_Pilkarz z:soccer.videos){
                        videoString+= "" +  z.url + "";
                    }
                    videoString+="";
                    ((DefaultListModel) list3.getModel()).addElement("Data urodzenia: " + soccer.birthDate.toString());
                    ((DefaultListModel) list3.getModel()).addElement("Narodowosc: " + soccer.nationality);
                    ((DefaultListModel) list3.getModel()).addElement("Wzrost: " + soccer.height);
                    ((DefaultListModel) list3.getModel()).addElement("Waga: " + soccer.weight);
                    ((DefaultListModel) list3.getModel()).addElement("Klub: " + soccer.club);
                    ((DefaultListModel) list3.getModel()).addElement("Plec: " + soccer.sex);
                    ((DefaultListModel) list3.getModel()).addElement("Wartosc: " + soccer.price);
                    ((DefaultListModel) list3.getModel()).addElement("Opis: " + soccer.desc);
                    ((DefaultListModel) list3.getModel()).addElement("Zalacznik: " + attachmentString);
                    ((DefaultListModel) list3.getModel()).addElement("Video: " + videoString);
                    ((DefaultListModel) list3.getModel()).addElement("Zobacz mecz");
            }
        };
        list1.addMouseListener(mouseListener1);

        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String selectedItem = (String) list3.getSelectedValue();
                if(selectedItem == "Zobacz mecz"){
                    JFrame jFrame5 = new JFrame("app");
                    jFrame5.setContentPane(new SoccerMatch().mainPanel);
                    jFrame5.pack();
                    jFrame5.setSize(400,350);
                    jFrame5.setLocationRelativeTo(null);
                    jFrame5.setVisible(true);
                }
            }
        };
        list3.addMouseListener(mouseListener);
    }
}
