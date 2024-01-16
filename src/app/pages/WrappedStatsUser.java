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
    private HashMap<Album, Integer> topAlbums = new HashMap<>();
    @Getter
    private HashMap<Song, Integer> topSongs = new HashMap<>();
    @Getter
    private HashMap<Artist, Integer> topArtists = new HashMap<>();
    @Getter
    private HashMap<Episode, Integer> topEpisodes = new HashMap<>();
    @Getter
    private HashMap<Enums.Genre, Integer> topGenres = new HashMap<>();
    public WrappedStatsUser(HashMap<Album, Integer> topAlbums,
                              HashMap<Song, Integer> topSongs,
                              HashMap<Artist, Integer> topArtists,
                              HashMap<Episode, Integer> topEpisodes,
                              HashMap<Enums.Genre, Integer> topGenres) {
        this.topAlbums = topAlbums;
        this.topSongs = topSongs;
        this.topArtists = topArtists;
        this.topEpisodes = topEpisodes;
        this.topGenres = topGenres;
    }
}
