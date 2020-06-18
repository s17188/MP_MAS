package gui;

import code.PilkarzMecz;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SoccerMatch {
    private JList list1;
    private JList list2;
    public JPanel mainPanel;
    private JLabel soccerName;

    public ArrayList<PilkarzMecz> pilkarzMeczs = new ArrayList<>();

    public SoccerMatch(){
        soccerName.setText("Mecze - " + SoccersList.soccer.getName());

        for(PilkarzMecz pm:SoccersList.soccer.list_match){
            ((DefaultListModel) list1.getModel()).addElement(pm.match.stadium);
            pilkarzMeczs.add(pm);
        }

        MouseListener mouseListener1 = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int id = list1.getSelectedIndex();
                ((DefaultListModel) list2.getModel()).clear();
                ((DefaultListModel) list2.getModel()).addElement("Data meczu: " + pilkarzMeczs.get(id).match.date);
                ((DefaultListModel) list2.getModel()).addElement("Czas gry: " + pilkarzMeczs.get(id).playtime + "min");
                ((DefaultListModel) list2.getModel()).addElement("Kartki czerwone: " + pilkarzMeczs.get(id).red_cards);
                ((DefaultListModel) list2.getModel()).addElement("Kartki zolte: " + pilkarzMeczs.get(id).yellow_cards);
            }
        };
        list1.addMouseListener(mouseListener1);

    }
}
