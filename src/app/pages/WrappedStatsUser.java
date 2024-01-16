package app.pages;

import app.audio.Collections.Album;
import app.audio.Files.Episode;
import app.audio.Files.Song;
import app.user.Artist;
import app.user.User;
import app.utils.Enums;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public WrappedStatsUser(HashMap<String, Integer> topAlbums,
                              HashMap<String, Integer> topSongs,
                              HashMap<String, Integer> topArtists,
                              HashMap<String, Integer> topEpisodes,
                              HashMap<String, Integer> topGenres) {
        this.topAlbums = getTopAlbums(topAlbums);
        this.topSongs = getTopSongs(topSongs);
        this.topArtists = getTopArtists(topArtists);
        this.topEpisodes = getTopEpisodes(topEpisodes);
        this.topGenres = getTopGenres(topGenres);
    }

    private HashMap<String, Integer> getTopAlbums(HashMap<String, Integer> albums) {
        return albums.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
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

    private HashMap<String, Integer> getTopArtists(HashMap<String, Integer> artists) {
        return artists.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private HashMap<String, Integer> getTopEpisodes(HashMap<String, Integer> episodes) {
        return episodes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private HashMap<String, Integer> getTopGenres(HashMap<String, Integer> genres) {
        return genres.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
