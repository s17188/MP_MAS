package code;

import java.time.LocalDate;

public class Favourite_Trener extends MainExtenstion  {

    public Agent agent;
    public Trener trener;
    public LocalDate addedDate;

    public Favourite_Trener(LocalDate addedDate, Agent agent, Trener trener){
        this.agent = agent;
        this.trener = trener;
        this.addedDate = addedDate;
        trener.addFavTrener(this);
        agent.addFavTrener(this);
    }

    public void removeTrenerMecz(){
        trener.removeFavTrener(this);
        agent.removeFavTrener(this);
    }

    public void aktualnosci(){
        System.out.println("Informacje o agencie: " + agent);
        System.out.println("Informacje o trenerze: " + trener);
    }

    @Override
    public String toString() {
        return "Favourite_Trener{" +
                "agent=" + agent +
                ", trener=" + trener +
                ", addedDate=" + addedDate +
                '}';
    }
}
