package controllers;

import code.*;
import gui.AddSoccer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class AddInformationController {
    public static void AddInformtaion(
            String zalacznik,String video,String pozycja,
            String dataMeczu,String stadion,String czasGry,String kartkaCzerwona,String kartkaZolta,
            String dataMeczu2,String stadion2,String czasGry2,String kartkaCzerwona2,String kartkaZolta2,
            String dataMeczu3,String stadion3,String czasGry3,String kartkaCzerwona3,String kartkaZolta3
        ){
        Zalacznik_Pilkarz zalacznikOb = new Zalacznik_Pilkarz(zalacznik);
        Video_Pilkarz videoOb = new Video_Pilkarz(video);
        Pozycja_Pilkarz position = new Pozycja_Pilkarz(pozycja, AddSoccer.soccer.club);


        AddSoccer.soccer.addAttachment(zalacznikOb);
        AddSoccer.soccer.addVideo(videoOb);
        AddSoccer.soccer.setPosition(position);

        System.out.println(AddSoccer.soccer);

        if(dataMeczu.length() > 0){
            LocalDate date = LocalDate.parse(dataMeczu);
            Mecz mecz = new Mecz(date,stadion);
            PilkarzMecz pilkarzmecz = new PilkarzMecz(Integer.parseInt(czasGry),Integer.parseInt(kartkaCzerwona),Integer.parseInt(kartkaZolta),AddSoccer.soccer,mecz);
        }

        if(dataMeczu2.length() > 0){
            LocalDate date2 = LocalDate.parse(dataMeczu2);
            Mecz mecz2 = new Mecz(date2,stadion2);
            PilkarzMecz pilkarzmecz2 = new PilkarzMecz(Integer.parseInt(czasGry2),Integer.parseInt(kartkaCzerwona2),Integer.parseInt(kartkaZolta2),AddSoccer.soccer,mecz2);
        }
        if(dataMeczu3.length() > 0){
            LocalDate date3 = LocalDate.parse(dataMeczu3);
            Mecz mecz3 = new Mecz(date3,stadion3);
            PilkarzMecz pilkarzmecz3 = new PilkarzMecz(Integer.parseInt(czasGry3),Integer.parseInt(kartkaCzerwona3),Integer.parseInt(kartkaZolta3),AddSoccer.soccer,mecz3);
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

    }
}
