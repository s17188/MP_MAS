import java.time.LocalDate;
import java.util.ArrayList;

public class Mecz extends MainExtenstion {
    public LocalDate date;
    public String stadium;
    public PilkarzMecz soccer_match = new PilkarzMecz(0,0,0);

    public Mecz(LocalDate date,String stadium){
        this.date = date;
        this.stadium = stadium;
    }

    //Asocjacja z atrybutem - metoda dodawania meczu do pilkarza
    public void addSoccer(int playtime,int red_cards,int yellow_cards,Pilkarz soccer){
        if(!soccer_match.soccerList.contains(soccer)){
            soccer_match.soccerList.add(soccer);
            soccer.addSoccerToMatch(playtime,red_cards,yellow_cards,this);
        }
    }

    @Override
    public String toString() {
        return "Mecz{" +
                "date=" + date +
                ", stadium='" + stadium + '\'' +
                ", soccer_match=" + soccer_match +
                '}';
    }
}
