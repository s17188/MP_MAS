public class Adres extends MainExtenstion{

    String city,street,buildNo;
    //Atrybut zlozony
    public Adres(String city, String street, String buildNo){
        this.city=city;
        this.street=street;
        this.buildNo=buildNo;
    }

    public String toString() {
        return city + " " + street + " " + buildNo;
    }
}
