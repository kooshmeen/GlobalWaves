package app.pages;

import app.audio.Collections.Album;
import app.audio.Files.Episode;
import app.audio.Files.Song;
import app.user.Artist;
import app.user.User;
import app.utils.Enums;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.HashMap;

public class WrappedStatsUser {
    @Getter
    private HashMap<String, Integer> topAlbums = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topSongs = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topArtists = new HashMap<>();
    @Getter
    private HashMap<Episode, Integer> topEpisodes = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topGenres = new HashMap<>();
    public WrappedStatsUser(HashMap<String, Integer> topAlbums,
                              HashMap<String, Integer> topSongs,
                              HashMap<String, Integer> topArtists,
                              HashMap<Episode, Integer> topEpisodes,
                              HashMap<String, Integer> topGenres) {
        this.topAlbums = topAlbums;
        this.topSongs = topSongs;
        this.topArtists = topArtists;
        this.topEpisodes = topEpisodes;
        this.topGenres = topGenres;
    }
}
