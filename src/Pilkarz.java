import java.util.Date;
import java.util.List;


public class Pilkarz extends Osoba {
    public enum Sex{Male,Female}

    int id;
    Date birthDate;
    String nationality;
    double height;
    double weight;
    Sex sex;
    String club;
    double price;
    String desc;
    //Atrybut pochodny
    private static int countSoccer = 0;
    //Atrybut klasowy
    private static double avgPrice = 0;
    private static double biggestPrice = 0;

    public Pilkarz(int id,String name, String surname,Date birthDate,Adres address,String nationality,double height,double weight,String club,Sex sex,double price,String desc){
        super(name, surname, address);
        this.id=id;
        this.birthDate=birthDate;
        this.nationality=nationality;
        this.height=height;
        this.weight=weight;
        this.club=club;
        this.sex=sex;
        this.price=price;
        this.desc=desc;

        countSoccer++;
        avgPrice += (this.price - avgPrice) / countSoccer;
        biggestPrice = price > biggestPrice ? price : biggestPrice;
    }

    //Metoda klasowa
    public static double findTheBiggestPrice() {
        double biggestPrice = 0;
        int count = 0;

        for (Object soc : Pilkarz.getExtent(Pilkarz.class)) {
            count++;
            biggestPrice += ((Pilkarz) soc).price > biggestPrice ? ((Pilkarz) soc).price : biggestPrice;
        }
        System.out.println("Najdrozszy pilkarz: " +biggestPrice+"zl");
        return biggestPrice;
    }

    public static double avgPrice(){
        double avgPrice = 0;
        int count = 0;

        for (Object soc : Pilkarz.getExtent(Pilkarz.class)) {
            count++;
            avgPrice += (((Pilkarz) soc).price - avgPrice)/count;
        }

        System.out.println("Srednia wartosc pilkarza: " +avgPrice+"zl");
        return avgPrice;
    }

    //Przeciazenie metody getAddress() z klasy Osoba
    public String getAddress(){
        return "Adres pilkarza: " + this.address.city + " " + this.address.street + " " + this.address.buildNo;
    }

    @Override
    public String toString() {
        return "Pilkarz{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", nationality='" + nationality + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", sex=" + sex +
                ", club='" + club + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", avgPrice=" + avgPrice +
                '}';
    }
}
