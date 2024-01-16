package app.pages;

import java.util.LinkedHashMap;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WrappedStatsUser {
    @Getter
    private HashMap<String, Integer> topAlbums = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topSongs = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topArtists = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topEpisodes = new HashMap<>();
    @Getter
    private HashMap<String, Integer> topGenres = new HashMap<>();
    private int maxItems = 5;
    public WrappedStatsUser(final HashMap<String, Integer> topAlbums,
                             final HashMap<String, Integer> topSongs,
                             final HashMap<String, Integer> topArtists,
                             final HashMap<String, Integer> topEpisodes,
                             final HashMap<String, Integer> topGenres) {
        this.topAlbums = getTopAlbums(topAlbums);
        this.topSongs = getTopSongs(topSongs);
        this.topArtists = getTopArtists(topArtists);
        this.topEpisodes = getTopEpisodes(topEpisodes);
        this.topGenres = getTopGenres(topGenres);
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

    private HashMap<String, Integer> getTopArtists(final HashMap<String, Integer> artists) {
        return artists.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(maxItems)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private HashMap<String, Integer> getTopEpisodes(final HashMap<String, Integer> episodes) {
        return episodes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(maxItems)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private HashMap<String, Integer> getTopGenres(final HashMap<String, Integer> genres) {
        return genres.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(maxItems)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
