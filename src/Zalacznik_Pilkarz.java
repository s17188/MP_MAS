public class Zalacznik_Pilkarz extends MainExtenstion {
    private String url;
    public Pilkarz soccer;

    public Zalacznik_Pilkarz(String url,Pilkarz soccer) {
        this.url = url;
        this.soccer = soccer;
    }

    @Override
    public String toString() {
        return "Zalacznik_Pilkarz{" +
                "url='" + url + '\'' +
                ", soccer=" + soccer +
                '}';
    }
}
