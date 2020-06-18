package code;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trener extends Osoba {

    private String nationality;
    private LocalDate birthDate;
    private boolean available;
    private boolean contract;
    private String desc;
    //Kompozycja
    private List<Specjalizacja> specs = new ArrayList<>();
    private ArrayList<Video_Trener> videos;
    private ArrayList<Zalacznik_Trener> attachment;
    public List<Favourite_Trener> list_fav_treners = new ArrayList<>();

    public Trener(String name, String surname, Adres address, String nationality,LocalDate birthDate,boolean available,boolean contract,String desc) {
        super(name, surname, address);
        this.birthDate=birthDate;
        this.nationality=nationality;
        this.available=available;
        this.contract=contract;
        this.desc=desc;
        this.attachment = new ArrayList<Zalacznik_Trener>();
        this.videos = new ArrayList<Video_Trener>();
    }

    public Specjalizacja createSpec(String specName){
        Specjalizacja spec = new Specjalizacja(specName);
        specs.add(spec);

        return spec;
    }

    public static void wyszukaj(String narodowosc) {
        for (Object trener : Trener.getExtent(Trener.class)) {
            String dataNarodowosc = ((Trener) trener).surname;
            if(dataNarodowosc == narodowosc){
                System.out.println("Trener: " +trener);
            }
        }
    }

    public void addVideo(Video_Trener video_trener) {
        if(!videos.contains(video_trener)){
            videos.add(video_trener);

            video_trener.addTrener(this);
        }
    }

    public void addAttachment(Zalacznik_Trener zalacznik){
        if(!attachment.contains(zalacznik)){
            attachment.add(zalacznik);

            zalacznik.addTrener(this);
        }
    }

    public void addFavTrener(Favourite_Trener favTrener){
        if(!list_fav_treners.contains(favTrener)){
            list_fav_treners.add(favTrener);
        }
    }

    public void removeFavTrener(Favourite_Trener favTrener){
        if(list_fav_treners.contains(favTrener)){
            list_fav_treners.remove(favTrener);
        }
    }

    @Override
    public String toString() {
        String info = "Trener{" +
                "specs=" + specs +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", zalacznik='[";
        for(Zalacznik_Trener z:attachment){
            info+= "" +  z.url + ",";
        }
        info+="]" +
                ", wideo='[";
        for(Video_Trener v:videos){
            info+= "" +  v.url + ",";
        }
        return info;
    }

    public static class Specjalizacja extends MainExtenstion{
        private String name;

        public Specjalizacja(String name){
            this.name=name;
        }

        public static void wyszukajSpecjalizacje(String nazwa) {
            for (Object spec : Specjalizacja.getExtent(Specjalizacja.class)) {
                String specName = ((Specjalizacja) spec).name;
                if(specName == nazwa){
                    System.out.println("Specjalizacja: " +spec);
                }
            }
        }

        @Override
        public String toString() {
            return  "name='" + name + '\'' +
                    '}';
        }
    }

}
