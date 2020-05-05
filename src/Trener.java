import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trener extends Osoba {
    private List<Specjalizacja> specs = new ArrayList<>();

    public Trener(String name, String surname, Adres address) {
        super(name, surname, address);
    }

    public Specjalizacja createSpec(String specName){
        Specjalizacja spec = new Specjalizacja(specName);
        specs.add(spec);

        return spec;
    }

    @Override
    public String toString() {
        return "Trener{" +
                "specs=" + specs +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }

    public class Specjalizacja extends MainExtenstion{
        private String name;

        public Specjalizacja(String name){
            this.name=name;
        }

        @Override
        public String toString() {
            return  "name='" + name + '\'' +
                    '}';
        }
    }

}
