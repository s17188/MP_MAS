import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class MainExtenstion implements Serializable {
    //Ekstensja, Ekst. - trwalosc
    private static Map<Class, List<MainExtenstion>> allExtents = new Hashtable<>();

    public MainExtenstion(){
        List<MainExtenstion> extent = null;
        Class theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
        }
        else {
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static void write(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    public static void read(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }

    public String toString() {
        return "String";
    }

    public static void showExtent() {
        List<MainExtenstion> extent = null;
        System.out.println("Extent of the class: " + MainExtenstion.class.getName());
        for (Map.Entry<Class, List<MainExtenstion>> entry : allExtents.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }

    public static <T> List<T> getExtent(Class theClass) {
        List<MainExtenstion> extent = null;
        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
//            for (MainExtenstion ext : extent) {
//                System.out.println(theClass.toString() + " " + ext);
//            }
        } else {
            System.out.println("Brak klasy: " + theClass.toString());
        }
        return (List<T>) extent;
    }

    public static int getCount(Class theClass){
        int count = 0;
        List<MainExtenstion> extent = null;
        if(allExtents.containsKey(theClass)){
            extent = allExtents.get(theClass);
            for(MainExtenstion ext : extent){
                count++;
            }
        }else {
            System.out.println("Brak klasy: " + theClass.toString());
        }
        return count;
    }

}
