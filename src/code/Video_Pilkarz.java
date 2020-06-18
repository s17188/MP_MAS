package code;

public class Video_Pilkarz extends MainExtenstion {
    public String url;
    public Pilkarz soccer;

    public Video_Pilkarz(String url) {
        this.url = url;
    }

    public void addPilkarz(Pilkarz pilkarz){
        if(this.soccer != pilkarz){
            this.soccer = pilkarz;
            pilkarz.addVideo(this);
        }
    }

    @Override
    public String toString() {
        return "Video_Pilkarz{" +
                "url='" + url + '\'' +
                ", soccer=" + soccer +
                '}';
    }
}
