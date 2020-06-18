package code;

public class Video_Trener extends MainExtenstion {
    public String url;
    public Trener trener;

    public Video_Trener(String url) {
        this.url = url;
    }

    public void addTrener(Trener trener){
        if(this.trener != trener){
            this.trener = trener;
            trener.addVideo(this);
        }
    }

    @Override
    public String toString() {
        return "code.Video_Trener{" +
                "url='" + url + '\'' +
                ", trener=" + trener +
                '}';
    }
}
