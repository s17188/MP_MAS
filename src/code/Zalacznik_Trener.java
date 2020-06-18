package code;

public class Zalacznik_Trener extends MainExtenstion {
    public String url;
    public Trener trener;

    public Zalacznik_Trener(String url) {
        this.url = url;
    }

    public void addTrener(Trener trener){
        if(this.trener != trener){
            this.trener = trener;
            trener.addAttachment(this);
        }
    }

    @Override
    public String toString() {
        return "Zalacznik_Trener{" +
                "url='" + url + '\'' +
                ", trener=" + trener +
                '}';
    }
}
