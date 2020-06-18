package code;

import java.util.Map;
import java.util.TreeMap;

public class Pozycja_Pilkarz extends MainExtenstion{

    public String position;
    public String club;
//    private Pilkarz soccer;
    private Map<Integer,Pilkarz> soccerQualif = new TreeMap<>();

    public Pozycja_Pilkarz(String postion,String club){
        this.position=postion;
        this.club=club;
    }

    //Asocjacja kwalifikowana - Pilkarz - (id)Pozycja_Pilkarz
    public void addSoccerPosition(Pilkarz soccer){
        if(!soccerQualif.containsKey(soccer.id)){
            soccerQualif.put(soccer.id,soccer);

            soccer.setPosition(this);
        }
    }

    public Pilkarz findSoccerQualif(Integer id) throws Exception{
        if(!soccerQualif.containsKey(id)){
            throw new Exception("Unable to find a soccer with id: " + id);
        }

        return soccerQualif.get(id);
    }

//    public void addPosition(Pilkarz pilkarz) {
//        this.soccer=pilkarz;
//    }

    @Override
    public String toString() {
        return "Pozycja_Pilkarz{" +
                "position='" + position + '\'' +
                ", club='" + club + '\'' +
                ", soccer_qualif=" + soccerQualif +
                '}';
    }
}
