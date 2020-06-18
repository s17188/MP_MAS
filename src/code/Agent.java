package code;

import java.time.LocalDate;
import java.util.*;

public class Agent extends Osoba {

    int id;
    boolean contract;
    String email;
    //Atrybut powtarzalny
    List<String> contracts = new ArrayList<>();
    ArrayList<Pilkarz> soccers = new ArrayList<>();
    public List<Favourite_Pilkarz> list_fav_soccers = new ArrayList<>();
    public List<Favourite_Trener> list_fav_treners = new ArrayList<>();

    public Agent(int id,String email,String name, String surname,boolean contract,Adres address){
        super(name, surname, address);
        this.id=id;
        this.email=email;
        this.contract=contract;
    }

    public static void wyszukaj(String nazwisko) {
        for (Object agent : Agent.getExtent(Agent.class)) {
            String dataNazwisko = ((Agent) agent).surname;
            if(dataNazwisko == nazwisko){
                System.out.println("Agent: " +agent);
            }
        }
    }

    public void addSoccer(Pilkarz soccer){
        if(!this.soccers.contains(soccer)){
            this.soccers.add(soccer);

            soccer.addPilkarz(this);
        }
    }

    public int countSoccers(){
        int counter=0;
        for (Object soccerOb : Pilkarz.getExtent(Pilkarz.class)) {
            Agent agent = ((Pilkarz) soccerOb).agent;
            if(agent == this){
                counter++;
            }
        }
        System.out.println(counter);
        return counter;
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

    public void addFavTrener(Favourite_Trener favTrener){
        if(!list_fav_treners.contains(favTrener)){
            list_fav_treners.add(favTrener);
        }
    }

    public void removeFavTrener(Favourite_Trener favTrener){
        if(list_fav_treners.contains(favTrener)){
            list_fav_treners.remove(favTrener);
        }
    }

    public void addContract(String name){
        this.contracts.add(name);
    }
    //Przeciazanie metody
    public void addContract(String name, LocalDate date){
        this.contracts.add(name + " Uzyskano: " + date);
    }

    //Przesloniecie metody getAddress() z klasy Osoba
    public String getAddress(){
        return "Adres agent: " + this.address.city + " " + this.address.street + " " + this.address.buildNo;
    }

    public ArrayList<Pilkarz> getSoccers(){
        return soccers;
    }

    public int getId(){
        return id;
    }

    public String getname(){
        return name + " " + surname;
    }

    @Override
    public String toString() {
        String info =  "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contract=" + contract +
                ", email='" + email + '\'' +
                ", contracts=" + contracts +
                ", pilkarze='[";
        for(Pilkarz p:soccers){
            info+= "" +  p.name + "," + p.surname;
        }
        info+="]" +
                ", favPilkarze='[";
        for(Favourite_Pilkarz p:list_fav_soccers){
            info+= "" +  p.soccer + ",";
        }
        info+="]" +
                '}';
        return info;
    }
}
