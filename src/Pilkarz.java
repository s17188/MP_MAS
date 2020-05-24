import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Pilkarz extends Osoba {

    public enum Sex{Male,Female}

    public int id;
    private LocalDate birthDate;
    private String nationality;
    private double height;
    private double weight;
    private Sex sex;
    public String club;
    private double price;
    //Atrybut opcjonalny
    private String desc;
    //Atrybut klasowy
    private double fifaMultipler=0.14;
    //Atrybut pochodny
    private int age;
    private int countSoccer = MainExtenstion.getCount(this.getClass());
    private double avgPrice = 0;
    private static double biggestPrice = 0;
    //Checked Pilkarz - Zalacznik_Pilkarz
    //Asocjacja zwykla
    private ArrayList<Zalacznik_Pilkarz> attachment;
    //Checked Pilkarz - PilkarzMecz - Mecz
    //Asocjacja z atrybutem
    public List<PilkarzMecz> list_match = new ArrayList<>();
    //Checked Pilkarz - (id)Pozycja_Pilkarz
    //Asocjacja kwalifikowana
    private Pozycja_Pilkarz position;


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
        this.attachment = new ArrayList<Zalacznik_Pilkarz>();
//        this.soccer_match = new ArrayList<PilkarzMecz>();

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

    //Asocjacja zwykla - metoda dodawania zalacznika
    public void addAttachment(Zalacznik_Pilkarz zalacznik){
        if(!attachment.contains(zalacznik)){
            attachment.add(zalacznik);

            zalacznik.addPilkarz(this);
        }
    }

    //Asocjacja z atrybutem - metoda dodawania pilkarza do pilkarzmecz
    public void addPilkarzMecz(PilkarzMecz pilkarzMecz){
        if(!list_match.contains(pilkarzMecz)){
            list_match.add(pilkarzMecz);
        }
    }

    public void removePilkarzMecz(PilkarzMecz pilkarzMecz){
        if(list_match.contains(pilkarzMecz)){
            list_match.remove(pilkarzMecz);
        }
    }

    //Asocjacja kwalifikowana - Pilkarz - (id)Pozycja_Pilkarz
    public void setPosition(Pozycja_Pilkarz position) {
        if(this.position != position){
            this.position=position;

            position.addSoccerPosition(this);
        }

    }

    //Asocjacja z atrybutem - metoda dodawania pilkarza do meczu
//    public void addSoccerToMatch(int playtime,int red_cards,int yellow_cards,Mecz match){
//        if(!soccer_match.matchList.contains(match)){
//            soccer_match.matchList.add(match);
//            match.addSoccer(playtime,red_cards,yellow_cards,this);
//        }
//    }


//    //Asocjacja kwalifikowana - Pilkarz - (Club)Pozycja_Pilkarz
//    public void addSoccerPosition(Pozycja_Pilkarz position){
//        if(!soccerQualif.containsKey(position.club)){
//            soccerQualif.put(position.club,position);
//
//            position.addPosition(this);
//        }
//    }
//
//    public Pozycja_Pilkarz findSoccerQualif(String club) throws Exception{
//        if(!soccerQualif.containsKey(club)){
//            throw new Exception("Unable to find a soccer with club: " + club);
//        }
//
//        return soccerQualif.get(club);
//    }



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
        String info = "Pilkarz{" +
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
                ", pozycja='" + position.position + '\'' +
                ", zalacznik='[";
        for(Zalacznik_Pilkarz z:attachment){
            info+= "" +  z.url + ",";
        }
        info+="]" +
                ", mecze='[";
        for(PilkarzMecz m:list_match){
            info+= "Miejsce: " +  m.match.stadium + " ,Zolte kartki: " + m.yellow_cards + "," + " Czas gry: " + m.playtime;
        }
        info+="]";
        return info;
    }
}
