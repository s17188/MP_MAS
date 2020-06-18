package code;

public class Zalacznik_Pilkarz extends MainExtenstion {
    public String url;
    public Pilkarz soccer;

    public Zalacznik_Pilkarz(String url) {
        this.url = url;
    }

    public void addPilkarz(Pilkarz pilkarz){
        if(this.soccer != pilkarz){
            this.soccer = pilkarz;
            pilkarz.addAttachment(this);
        }
    }

    @Override
    public String toString() {
        return "Zalacznik_Pilkarz{" +
                "url='" + url + '\'' +
                ", soccer=" + soccer +
                '}';
    }
}
