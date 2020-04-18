import java.time.LocalDate;
import java.time.Period;

public class Pilkarz extends Osoba {

    public enum Sex{Male,Female}

    int id;
    LocalDate birthDate;
    String nationality;
    double height;
    double weight;
    Sex sex;
    String club;
    double price;
    //Atrybut opcjonalny
    String desc;
    //Atrybut klasowy
    double fifaMultipler=0.14;
    //Atrybut pochodny
    private int age;
    private int countSoccer = MainExtenstion.getCount(this.getClass());
    private double avgPrice = 0;
    private static double biggestPrice = 0;

    public Pilkarz(int id,String name, String surname,LocalDate birthDate,Adres address,String nationality,double height,double weight,String club,Sex sex,double price){
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
        avgPrice += (price - avgPrice) / countSoccer;
//        biggestPrice = price > biggestPrice ? price : biggestPrice;
        age = countAge();
    }

    //Metoda klasowa
    public static void findTheBiggestPrice() {
        double biggestPrice = 0;
        for (Object soccer : Pilkarz.getExtent(Pilkarz.class)) {
            biggestPrice = ((Pilkarz) soccer).price > biggestPrice ? ((Pilkarz) soccer).price : biggestPrice;
        }
        System.out.println("Najdrozszy pilkarz: " +biggestPrice+"zl");
    }

    //Metoda klasowa
    public static void avgPrice(){
        double avgPrice = 0;
        int count = 0;
        for (Object soc : Pilkarz.getExtent(Pilkarz.class)) {
            count++;
            avgPrice += (((Pilkarz) soc).price - avgPrice)/count;
        }
        System.out.println("Srednia wartosc pilkarza: " +avgPrice+"zl");
    }

    public int countAge(){
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    //Przesloniecie metody getAddress() z klasy Osoba
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
                ", age=" + age +
                ", sex=" + sex +
                ", club='" + club + '\'' +
                ", price=" + price +
                ", desc='" + (desc == null ? "brak opisu" : desc) + '\'' +
                ", fifaMultipler='" + fifaMultipler + '\'' +
                '}';
    }
}
