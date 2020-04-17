import java.util.*;

public class Agent extends Osoba {

    int id;
    boolean contract;
    String email;
    List<String> contracts = new ArrayList<>(); //Atrybut powtarzalny

    public Agent(int id,String email,String name, String surname,boolean contract,Adres address){
        super(name, surname, address);
        this.id=id;
        this.email=email;
        this.contract=contract;
    }

    public void addContract(String name){
        this.contracts.add(name);
    }

    //Przeciazenie metody getAddress() z klasy Osoba
    public String getAddress(){
        return "Adres agent: " + this.address.city + " " + this.address.street + " " + this.address.buildNo;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", contract=" + contract +
                ", email='" + email + '\'' +
                ", contracts=" + contracts +
                '}';
    }
}
