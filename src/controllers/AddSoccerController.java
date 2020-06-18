package controllers;

import code.*;
import gui.InitSoccer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.List;

public class AddSoccerController {
    public static Pilkarz soccer;

    public static Pilkarz AddSoccer(
            String birthdate,String nationality,
            String height,String weight,String club,String comboBox1,
            String price,String desc,String city,String street,String buildNo
    ){
        int countId=0;
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(Main.file)));
            MainExtenstion.read(in);
            countId = MainExtenstion.getCount(Pilkarz.class);
        } catch (Exception exception) {
            countId = 0;
        }

        int finalCountId = countId;

        Adres adres = new Adres(city,street,buildNo);
        String date = birthdate;
        soccer = new Pilkarz(finalCountId,
                InitSoccer.initSoccerName,
                InitSoccer.initSoccerSurname,
                LocalDate.parse(date),
                adres,
                nationality,
                Integer.parseInt(height),
                Integer.parseInt(weight),
                club,
                comboBox1,
                Integer.parseInt(price));
        soccer.setDesc(desc);

        List<Agent> list = Agent.getExtent(Agent.class);

        for(Agent o: list){
            System.out.println("Agent " + o);
            if(o.getId() == Main.agent.getId()) {
                o.addSoccer(soccer);
            }
        }

        System.out.println(soccer.toString());
        return soccer;
    }
}
