import java.util.Map;
import java.util.TreeMap;

public class Pozycja_Pilkarz extends MainExtenstion{

    private String position;
    public String club;
    private Pilkarz soccer;

    public Pozycja_Pilkarz(String postion,String club){
        this.position=postion;
        this.club=club;
    }

    public void addPosition(Pilkarz pilkarz) {
        this.soccer=pilkarz;
    }

    @Override
    public String toString() {
        return "Pozycja_Pilkarz{" +
                "position='" + position + '\'' +
                ", club='" + club + '\'' +
                ", soccer=" + soccer +
                '}';
    }
}
