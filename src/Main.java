import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("Data.obj");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Aby uzupelnic system danymi, wpisz 1");
        System.out.println("Aby wczytac dane, wpisz 2");

        int option = scanner.nextInt();

        switch (option){
            case 1:
                Adres adres1 = new Adres("Warsaw","Zlota","44");
                Adres adres2 = new Adres("Cracow","Zakopianska","62");
                Agent a1 = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true,adres1);
                Agent a2 = new Agent(2,"a2@mail.com","Krzysztof","Krawczyk",false,adres2);
//                Zalacznik_Pilkarz z1 = new Zalacznik_Pilkarz(1,"asd");
//                Zalacznik_Pilkarz z2 = new Zalacznik_Pilkarz(2,"asd");
                Pilkarz p1 = new Pilkarz(1,"Pawel","Szczesny",LocalDate.of(1989,1,20),adres1,"Poland",190,78,"Wisla", Pilkarz.Sex.Male,190000);
                Pilkarz p2 = new Pilkarz(2,"Pawel","Szczesny",LocalDate.of(1995,1,20),adres2,"Poland",190,78,"Legia", Pilkarz.Sex.Male,490000);

                Mecz m1 = new Mecz(LocalDate.now(),"Warszawa");
                Mecz m2 = new Mecz(LocalDate.now(),"Cracow");

                p1.addAttachment("asd");
                p2.addAttachment("22222");
                p1.addAttachment("dddd");

//                p1.addSoccerToMatch(20,2,1);
//                p1.addSoccerToMatch(30,3,1);
//                p2.addSoccerToMatch(10,1,1);

                PilkarzMecz p1m = new PilkarzMecz(20,0,0,p1,m1);
                PilkarzMecz p2m = new PilkarzMecz(20,0,0,p1,m2);
                PilkarzMecz p3m = new PilkarzMecz(20,0,0,p2,m2);

                Pozycja_Pilkarz pz = new Pozycja_Pilkarz("L POM","Wisla");
                Pozycja_Pilkarz pz2 = new Pozycja_Pilkarz("N","Legia");
                Pozycja_Pilkarz pz3 = new Pozycja_Pilkarz("P POM","Poznan");

                p1.addSoccerPosition(pz);
                p2.addSoccerPosition(pz2);
                p2.addSoccerPosition(pz3);

                p1.setDesc("Dobry pilkarz");
                a2.setAdres("Warsaw","Zlota","44");
                a1.addContract("Kontrakt Fifa 2020",LocalDate.of(2012,6,20));
                a2.addContract("Kontrakt Fifa 2020");

                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                MainExtenstion.write(out);
                MainExtenstion.showExtent();
                out.close();
                Pilkarz.findTheBiggestPrice();
                Pilkarz.avgPrice();
                System.out.println(a1.getAddress());
                System.out.println(p1.getAddress());

                System.out.println(p2.findSoccerQualif("Legia"));
                System.out.println(p2.findSoccerQualif("Poznan"));
                System.out.println(p1.findSoccerQualif("Wisla"));
                break;
            case 2:
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                MainExtenstion.read(in);
                MainExtenstion.showExtent();
                Pilkarz.avgPrice();
        }

    }
}
