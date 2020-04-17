public class Osoba extends MainExtenstion {

    String name;
    String surname;
    Adres address;

    public Osoba(String name,String surname,Adres address){
        if(name == null)
        {
            throw new NullPointerException("Osoba musi miec imie");
        }
        this.name=name;
        if(surname == null)
        {
            throw new NullPointerException("Osoba musi miec nazwisko");
        }
        this.surname=surname;
        //Adres jako atrybut opcjonalny
        if(address == null){
            address= new Adres("","","");
        }
        this.address=address;
    }

    public void setAdres(String city,String street,String buildNo){
        this.address.city=city;
        this.address.street=street;
        this.address.buildNo=buildNo;
    }

    public String getAddress(){
        return this.address.city + " " + this.address.street + " " + this.address.buildNo;
    }

    public String toString() {
        return name + " " + surname;
    }

}
