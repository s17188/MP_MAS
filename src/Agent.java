public class Agent extends Osoba {

    int id;
    boolean contract;
    String email;
    String name;
    String surname;

    public Agent(int id,String email,String name, String surname,boolean contract){
        super();
        this.id=id;
        this.email=email;
        this.name=name;
        this.surname=surname;
        this.contract=contract;
    }

    public String toString() {
        return id + " " + name + " " + surname + " " + contract + ", " + email;
    }
}
