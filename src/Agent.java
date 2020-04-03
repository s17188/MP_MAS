import java.util.*;

public class Agent extends Osoba {

    int id;
    boolean contract;
    String email;
    List<String> contracts = new ArrayList<>();

    public Agent(int id,String email,String name, String surname,boolean contract,Adres address){
        super(name, surname, address);
        this.id=id;
        this.email=email;
        this.contract=contract;
    }

    public void addContract(String name){
        this.contracts.add(name);
    }

    public String getAddress(){
        return "Adres agent: " + this.address.city + " " + this.address.street + " " + this.address.buildNo;
    }

    public String toString() {
        return id + " " + name + " " + surname + " " + contract + ", " + email + " " +(address.city==""?"Brak adresu":address.city) + " " + contracts.get(0) ;
    }

}
