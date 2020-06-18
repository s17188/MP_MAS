package code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mecz extends MainExtenstion {
    public LocalDate date;
    public String stadium;
    public List<PilkarzMecz> list_match = new ArrayList<>();

    public Mecz(LocalDate date,String stadium){
        this.date = date;
        this.stadium = stadium;
    }

    //Asocjacja z atrybutem - metoda dodawania meczu do pilkarzmecz
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

    @Override
    public String toString() {
        return "Mecz{" +
                "date=" + date +
                ", stadium='" + stadium + '\'' +
                ", soccer_match=" + list_match +
                '}';
    }
}
