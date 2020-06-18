package code;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pilkarz extends Osoba {



    public enum Sex{Male,Female}

    public int id;
    public LocalDate birthDate;
    public String nationality;
    public double height;
    public double weight;
    public String sex;
    public String club;
    public double price;
    //Atrybut opcjonalny
    public String desc;
    //Atrybut klasowy
    public double fifaMultipler=0.14;
    //Atrybut pochodny
    public int age;
    public int countSoccer = MainExtenstion.getCount(this.getClass());
    public double avgPrice = 0;
    public static double biggestPrice = 0;
    //Checked Pilkarz - Zalacznik_Pilkarz
    //Asocjacja zwykla
    public ArrayList<Zalacznik_Pilkarz> attachment;
    //Checked Pilkarz - PilkarzMecz - Mecz
    //Asocjacja z atrybutem
    public List<PilkarzMecz> list_match = new ArrayList<>();
    //Checked Pilkarz - (id)Pozycja_Pilkarz
    //Asocjacja kwalifikowana
    public Pozycja_Pilkarz position;
    public List<Favourite_Pilkarz> list_fav_soccers = new ArrayList<>();
    public ArrayList<Video_Pilkarz> videos;
    public Agent agent;


    public Pilkarz(int id, String name, String surname, LocalDate birthDate, Adres address, String nationality, double height, double weight, String club, String sex, double price){
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
        this.videos = new ArrayList<Video_Pilkarz>();
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

    public void addVideo(Video_Pilkarz video_pilkarz) {
        if(!videos.contains(video_pilkarz)){
            videos.add(video_pilkarz);

            video_pilkarz.addPilkarz(this);
        }
    }

    public void addPilkarz(Agent agent){
        if(this.agent != agent){
            this.agent = agent;
            agent.addSoccer(this);
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

    public void addFavSoccer(Favourite_Pilkarz favSoccer){
        if(!list_fav_soccers.contains(favSoccer)){
            list_fav_soccers.add(favSoccer);
        }
    }

    public void removeFavSoccer(Favourite_Pilkarz favSoccer){
        if(list_fav_soccers.contains(favSoccer)){
            list_fav_soccers.remove(favSoccer);
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

    public int getId(){
        return this.id;
    }

    public Agent getAgent(){
        return agent;
    }

    public String getName(){
        return name + " " + surname;
    }

    @Override
    public String toString() {
        String info = "Pilkarz{" +
                "id=" + id +
                ", name=" + name +
                ", surname=" + surname +
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
                ", pozycja='" + (position == null ? "Brak pozycji" : position.position) + '\'' +
                ", agent='" + (agent == null ? "Brak agenta" : agent) + '\'' +
                ", zalacznik='[";
        for(Zalacznik_Pilkarz z:attachment){
            info+= "" +  z.url + ",";
        }
        info+="]" +
                ", wideo='[";
        for(Video_Pilkarz v:videos){
            info+= "" +  v.url + ",";
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
