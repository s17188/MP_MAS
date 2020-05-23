import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PilkarzMecz extends MainExtenstion {

    public int playtime;
    public int red_cards;
    public int yellow_cards;
    public Set<Pilkarz> soccerList = new HashSet<>();
    public Set<Mecz> matchList = new HashSet<>();


    public PilkarzMecz(int playtime,int red_cards, int yellow_cards){
        this.playtime = playtime;
        this.red_cards = red_cards;
        this.yellow_cards = yellow_cards;
    }

    @Override
    public String toString() {
        return "PilkarzMecz{" +
                "playtime=" + playtime +
                ", red_cards=" + red_cards +
                ", yellow_cards=" + yellow_cards +
                ", soccer=" + soccerList +
                ", match=" + matchList +
                '}';
    }
}
