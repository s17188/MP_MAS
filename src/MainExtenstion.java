import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainExtenstion implements Serializable {

    private static List<MainExtenstion> extent = new ArrayList<>();

    public MainExtenstion(){
        add(this);
    }

    protected static void add(MainExtenstion myextension) {
        extent.add(myextension);
    }


    protected static void remove(MainExtenstion myextension) {
        extent.remove(myextension);
    }


    public static void writeFile(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }


    public static void readFile(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<MainExtenstion>) stream.readObject();
    }


    public String toString() {
        return "String";
    }

    public static void showExtent() {
        System.out.println("Extent of the class: " + MainExtenstion.class.getName());
        for (MainExtenstion myextension : extent) {
            System.out.println(myextension);
        }
    }
}
