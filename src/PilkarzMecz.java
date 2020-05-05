import java.time.LocalDate;
import java.util.ArrayList;

public class PilkarzMecz extends MainExtenstion {

    private int playtime;
    private int red_cards;
    private int yellow_cards;
    private Pilkarz soccer;
    private Mecz match;

    public PilkarzMecz(int playtime,int red_cards, int yellow_cards,Pilkarz soccer,Mecz match){
        this.playtime = playtime;
        this.red_cards = red_cards;
        this.yellow_cards = yellow_cards;
        this.soccer = soccer;
        this.match = match;
    }

    @Override
    public String toString() {
        return "PilkarzMecz{" +
                "playtime=" + playtime +
                ", red_cards=" + red_cards +
                ", yellow_cards=" + yellow_cards +
                ", soccer=" + soccer +
                ", match=" + match +
                '}';
    }
}
