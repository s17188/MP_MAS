package code;

import java.time.LocalDate;

public class Favourite_Pilkarz extends MainExtenstion  {

    public Agent agent;
    public Pilkarz soccer;
    public LocalDate addedDate;

    public Favourite_Pilkarz(LocalDate addedDate, Agent agent, Pilkarz soccer){
        this.agent = agent;
        this.soccer = soccer;
        this.addedDate = addedDate;
        soccer.addFavSoccer(this);
        agent.addFavSoccer(this);
    }

    public void removePilkarzMecz(){
        soccer.removeFavSoccer(this);
        agent.removeFavSoccer(this);
    }

    public void aktualnosci(){
        System.out.println("Informacje o agencie: " + agent);
        System.out.println("Informacje o pilkarzu: " + soccer);
    }

    @Override
    public String toString() {
        return "Favourite_Pilkarz{" +
                "agent=" + agent +
                ", soccer=" + soccer +
                ", addedDate=" + addedDate +
                '}';
    }
}
