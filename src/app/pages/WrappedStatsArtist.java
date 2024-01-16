package app.pages;

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
    private int maxItems = 5;
    public WrappedStatsArtist(final HashMap<String, Integer> topAlbums,
                             final HashMap<String, Integer> topSongs,
                             final HashMap<String, Integer> topFans,
                             final HashMap<User, Boolean> uniqueListeners,
                             final Integer listeners) {
        this.topAlbums = getTopAlbums(topAlbums);
        this.topSongs = getTopSongs(topSongs);
        this.topFans = getTopFans(topFans);
        this.uniqueListeners = uniqueListeners;
        this.listeners = listeners;
    }

    private HashMap<String, Integer> getTopSongs(final HashMap<String, Integer> songs) {
        return songs.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(maxItems)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private ArrayList<String> getTopFans(final HashMap<String, Integer> fans) {
        return fans.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(maxItems)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private HashMap<String, Integer> getTopAlbums(final HashMap<String, Integer> albums) {
        return albums.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(maxItems)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
