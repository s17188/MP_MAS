import java.time.LocalDate;
import java.util.ArrayList;

public class Mecz extends MainExtenstion {
    private LocalDate date;
    private String stadium;
//    private ArrayList<PilkarzMecz> soccer_match;

    public Mecz(LocalDate date,String stadium){
        this.date = date;
        this.stadium = stadium;
//        this.soccer_match = new ArrayList<PilkarzMecz>();
    }

    @Override
    public String toString() {
        return "Mecz{" +
                "date=" + date +
                ", stadium='" + stadium + '\'' +
//                ", soccer_match=" + soccer_match +
                '}';
    }
}
