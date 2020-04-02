import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Agent a1 = new Agent(1,"a1@mail.com","Piotr","Kwiatek",true);
        Agent a2 = new Agent(2,"a2@mail.com","Krzysztof","Krawczyk",false);

        File file = new File("Save.obj");

        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        Agent.writeFile(out);
        out.close();
        Agent.showExtent();

    }
}
