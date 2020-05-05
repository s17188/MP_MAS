//public class Specjalizacja extends MainExtenstion{
//    public String name;
//    private Trener trainer;
//
//    private Specjalizacja(Trener trainer,String name){
//        this.name=name;
//        this.trainer=trainer;
//    }
//
//    public static Specjalizacja createSpec(Trener trainer, String name) throws Exception{
//        if(trainer == null){
//            throw new Exception("Podany trener nie istnieje");
//        }
//
//        Specjalizacja spec = new Specjalizacja(trainer,name);
//
//        trainer.addSpec(spec);
//
//        return spec;
//    }
//
//    @Override
//    public String toString() {
//        return "Specjalizacja{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
