package app.pages;

import app.audio.Collections.Album;
import app.audio.Files.Song;
import app.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WrappedStatsArtist {
    @Getter
    private HashMap<String, Integer> topAlbums = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topSongs = new HashMap<>();
    @Getter
    private ArrayList<String> topFans = new ArrayList<>();
    @Getter
    @JsonIgnore
    private HashMap<User, Boolean> uniqueListeners = new HashMap<>();
    @Getter
    private Integer listeners;
    public WrappedStatsArtist(HashMap<String, Integer> topAlbums,
                              HashMap<String, Integer> topSongs,
                              HashMap<String, Integer> topFans,
                              HashMap<User, Boolean> uniqueListeners,
                              Integer listeners) {
        this.topAlbums = topAlbums;
        this.topSongs = getTopSongs(topSongs);
        this.topFans = getTopFans(topFans);
        this.uniqueListeners = uniqueListeners;
        this.listeners = listeners;
    }

    private HashMap<String, Integer> getTopSongs(HashMap<String, Integer> songs) {
        return songs.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private ArrayList<String> getTopFans(HashMap<String, Integer> fans) {
        return fans.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
