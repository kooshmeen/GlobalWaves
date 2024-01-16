package app.user;

public class ArtistStats {
    private final Integer ranking;
    private final Integer merchRevenue;
    private final Integer songRevenue;
    private final String mostProfitableSong;

    public ArtistStats(final Integer ranking, final Integer merchRevenue, final Integer songRevenue, final String mostProfitableSong) {
        this.ranking = ranking;
        this.merchRevenue = merchRevenue;
        this.songRevenue = songRevenue;
        this.mostProfitableSong = mostProfitableSong;
    }
}
