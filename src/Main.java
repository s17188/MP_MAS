import java.io.*;
import java.util.Date;
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

                a2.setAdres("Warsaw","Zlota","44");
                a1.addContract("Kontrakt Fifa 2020");
                a2.addContract("Kontrakt Fifa 2020");

                Pilkarz p1 = new Pilkarz(1,"Pawel","Szczesny",new Date(),adres1,"Poland",190,78,"Legia", Pilkarz.Sex.Male,190000,"Dobry pilkarz");
                Pilkarz p2 = new Pilkarz(2,"Pawel","Szczesny",new Date(),null,"Poland",190,78,"Legia", Pilkarz.Sex.Male,490000,"Dobry pilkarz");

                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                MainExtenstion.write(out);
                MainExtenstion.showExtent();
                out.close();
                Pilkarz.findTheBiggestPrice();
                Pilkarz.avgPrice();
                break;
            case 2:
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                MainExtenstion.read(in);
                MainExtenstion.showExtent();
                Pilkarz.avgPrice();
        }

    }
}
