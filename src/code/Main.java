package code;

import gui.*;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Agent agent;
    public static File file = new File("Data.obj");

    public static void main(String[] args) throws Exception {

        File file = new File("Data.obj");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Aby uzupelnic system danymi, wpisz 1");
        System.out.println("Aby wczytac dane, wpisz 2");
        System.out.println("Aby uruchomic proces dodawania Pilkarza, wpisz 3");
        System.out.println("Aby zobaczyc Pilkarzy pierwszego Agenta w systemie, wpisz 4");

        int option = scanner.nextInt();
        Adres adresAgent = new Adres("Cracow","Zakopianska","62");

        switch (option){
            case 1:
                Adres adres1 = new Adres("Warsaw","Zlota","44");
                Adres adres2 = new Adres("Cracow","Zakopianska","62");
                Agent a1 = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true,adres1);
                Agent a2 = new Agent(2,"a2@mail.com","Krzysztof","Krawczyk",false,adres2);
//                code.Zalacznik_Pilkarz z1 = new code.Zalacznik_Pilkarz(1,"asd");
//                code.Zalacznik_Pilkarz z2 = new code.Zalacznik_Pilkarz(2,"asd");
                Pilkarz p1 = new Pilkarz(1,"Pawel","Szczesny",LocalDate.of(1989,1,20),adres1,"Poland",190,78,"Wisla", "Mezczyzna",190000);
                Pilkarz p2 = new Pilkarz(2,"Pawel","Szczesny",LocalDate.of(1995,1,20),adres2,"Poland",190,78,"Legia", "Mezczyzna",490000);

                Mecz m1 = new Mecz(LocalDate.now(),"Warszawa");
                Mecz m2 = new Mecz(LocalDate.now(),"Cracow");
                //Kompozycja
                Trener t1 = new Trener("Krzysztof","Papuga",adres1,"Polska",LocalDate.of(1989,1,20),true,true,"Dobry trener");

                a1.addSoccer(p1);
                a1.addSoccer(p2);

                //a1.countSoccers();

                System.out.println("COUNT -----");

                //Asocjacja zwykla
                Zalacznik_Pilkarz z1 = new Zalacznik_Pilkarz("Zalacznik1");
                Zalacznik_Pilkarz z2 = new Zalacznik_Pilkarz("Zalacznik2");
                Zalacznik_Pilkarz z3 = new Zalacznik_Pilkarz("Zalacznik3");

                Video_Pilkarz v1 = new Video_Pilkarz("Video3");

                p1.addAttachment(z1);
                p2.addAttachment(z2);
                p1.addAttachment(z3);

                p1.addVideo(v1);



                //Asocjacja z atrybutem
                PilkarzMecz p1m = new PilkarzMecz(30,0,0,p1,m1);
                PilkarzMecz p2m = new PilkarzMecz(20,0,0,p1,m1);

                Favourite_Pilkarz a1p = new Favourite_Pilkarz(LocalDate.now(),a1,p1);

                Favourite_Trener a1t = new Favourite_Trener(LocalDate.now(),a1,t1);



//                code.PilkarzMecz p2m = new code.PilkarzMecz(20,0,0,p1,m2);
//                code.PilkarzMecz p3m = new code.PilkarzMecz(20,0,0,p2,m2);


                //Asocjacja kwalifikowana
                Pozycja_Pilkarz pz = new Pozycja_Pilkarz("L POM","Wisla");
                Pozycja_Pilkarz pz2 = new Pozycja_Pilkarz("N","Legia");
                Pozycja_Pilkarz pz3 = new Pozycja_Pilkarz("P POM","Poznan");
                Pozycja_Pilkarz pz4 = new Pozycja_Pilkarz("S POM","Poznan");

//                p1.addSoccerPosition(pz);
//                p2.addSoccerPosition(pz2);
//                p2.addSoccerPosition(pz3);
//                p2.addSoccerPosition(pz4);

                pz.addSoccerPosition(p1);
                pz2.addSoccerPosition(p2);
                pz3.addSoccerPosition(p2);
                pz4.addSoccerPosition(p2);

                p1.setDesc("Dobry pilkarz");
                a2.setAdres("Warsaw","Zlota","44");
                a1.addContract("Kontrakt Fifa 2020",LocalDate.of(2012,6,20));
                a2.addContract("Kontrakt Fifa 2020");




                Zalacznik_Trener z1t = new Zalacznik_Trener("Zalacznik1");

                Video_Trener v1t = new Video_Trener("Video3");

                t1.createSpec("Rzut kula");
                t1.createSpec("Testowanie");

                t1.addAttachment(z1t);
                t1.addVideo(v1t);

                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                MainExtenstion.write(out);
                MainExtenstion.showExtent();
                out.close();
//                code.Pilkarz.findTheBiggestPrice();
//                code.Pilkarz.avgPrice();
//                System.out.println(a1.getAddress());
//                System.out.println(p1.getAddress());


//                System.out.println(pz2.findSoccerQualif(1));
//                System.out.println(p2.findSoccerQualif("Legia"));
//                System.out.println(p2.findSoccerQualif("Poznan"));

                //Asocjacja kwalifikowana zwroc pilkarza z id
                System.out.println(pz.findSoccerQualif(1));
                System.out.println(pz2.findSoccerQualif(2));

                Agent.wyszukaj("Krawczyk");

                a1p.aktualnosci();

                a1t.aktualnosci();

                Trener.Specjalizacja.wyszukajSpecjalizacje("Rzut kula");
                a1.countSoccers();
                a2.countSoccers();
                break;
            case 2:
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                MainExtenstion.read(in);
                MainExtenstion.showExtent();
                Pilkarz.avgPrice();
                break;
            case 3:
                try {
                    ObjectInputStream in3 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                    MainExtenstion.read(in3);
                    MainExtenstion.showExtent();

                    List<Agent> list = Agent.getExtent(Agent.class);

                    for(Agent o: list){
                        if(o.getId() == 1) {
                            agent = o;
                        }else{
                            agent = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true,adresAgent);
                        }
                    }

                } catch (Exception e) {
                    agent = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true,adresAgent);
                }

                JFrame jFrame1 = new JFrame("Dodawanie pilkarza");
                jFrame1.setContentPane(new InitSoccer().mainPanel);
                jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame1.pack();
                jFrame1.setSize(300,200);
                jFrame1.setLocationRelativeTo(null);
                jFrame1.setVisible(true);
                break;

            case 4:
                try {
                    ObjectInputStream in4 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                    MainExtenstion.read(in4);
                    MainExtenstion.showExtent();

                    List<Agent> list = Agent.getExtent(Agent.class);

                    for(Agent o: list){
                        if(o.getId() == 1) {
                            agent = o;
                        }else{
                            agent = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true,adresAgent);
                        }
                    }

                } catch (Exception e) {
                    agent = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true,adresAgent);
                }

                JFrame jFrame3 = new JFrame("Lista pilkarzy");
                jFrame3.setContentPane(new SoccersList().mainPanel);
                jFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame3.pack();
                jFrame3.setSize(400,350);
                jFrame3.setLocationRelativeTo(null);
                jFrame3.setVisible(true);



        }

    }
}
