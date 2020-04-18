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
                Pilkarz p1 = new Pilkarz(1,"Pawel","Szczesny",LocalDate.of(1989,1,20),adres1,"Poland",190,78,"Legia", Pilkarz.Sex.Male,190000);
                Pilkarz p2 = new Pilkarz(2,"Pawel","Szczesny",LocalDate.of(1995,1,20),adres2,"Poland",190,78,"Legia", Pilkarz.Sex.Male,490000);

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
                break;
            case 2:
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                MainExtenstion.read(in);
                MainExtenstion.showExtent();
                Pilkarz.avgPrice();
        }

    }
}
