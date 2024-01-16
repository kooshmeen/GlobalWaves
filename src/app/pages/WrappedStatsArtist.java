package app.pages;

import app.audio.Collections.Album;
import app.audio.Files.Song;
import app.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.HashMap;

public class WrappedStatsArtist {
    @Getter
    private HashMap<String, Integer> topAlbums = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topSongs = new HashMap<>();
    @Getter
    private HashMap<User, Integer> topFans = new HashMap<>();
    @Getter
    @JsonIgnore
    private HashMap<User, Boolean> uniqueListeners = new HashMap<>();
    @Getter
    private Integer listeners;
    public WrappedStatsArtist(HashMap<String, Integer> topAlbums,
                              HashMap<String, Integer> topSongs,
                              HashMap<User, Integer> topFans,
                              HashMap<User, Boolean> uniqueListeners,
                              Integer listeners) {
        this.topAlbums = topAlbums;
        this.topSongs = topSongs;
        this.topFans = topFans;
        this.uniqueListeners = uniqueListeners;
        this.listeners = listeners;
    }
}
