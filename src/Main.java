import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchFieldException {
        Adres adres1 = new Adres("Warsaw","Zlota","44");
        Adres adres2 = new Adres("Cracow","Zakopianska","62");
        Agent a1 = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true,adres1);
        Agent a2 = new Agent(2,"a2@mail.com","Krzysztof","Krawczyk",false,adres2);

        a2.setAdres("Warsaw","Zlota","44");
        a1.addContract("Kontrakt Fifa 2020");
        a2.addContract("Kontrakt Fifa 2020");

        Pilkarz p1 = new Pilkarz(1,"Pawel","Szczesny",new Date(),adres1,"Poland",190,78,"Legia", Pilkarz.Sex.Male,190000,"Dobry pilkarz");
        Pilkarz p2 = new Pilkarz(1,"Pawel","Szczesny",new Date(),null,"Poland",190,78,"Legia", Pilkarz.Sex.Male,290000,"Dobry pilkarz");

        System.out.println(a1.getAddress());
        System.out.println(p1.getAddress());

        File file = new File("Save.obj");

        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        Agent.writeFile(out);
        out.close();
        Pilkarz.findTheBiggestPrice();
        Agent.showExtent();

    }
}
