package app.user;

import app.audio.Collections.Podcast;
import app.audio.Files.Episode;
import app.pages.HostPage;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Host.
 */
public final class Host extends ContentCreator {
    private ArrayList<Podcast> podcasts;
    private ArrayList<Announcement> announcements;

    @Getter
    private HashMap<Episode, Integer> topEpisodes = new HashMap<>();
    @Getter
    private HashMap<User, Boolean> uniqueListeners = new HashMap<>();
    @Getter
    private Integer listeners;


    /**
     * Instantiates a new Host.
     *
     * @param username the username
     * @param age      the age
     * @param city     the city
     */
    public Host(final String username, final int age, final String city) {
        super(username, age, city);
        podcasts = new ArrayList<>();
        announcements = new ArrayList<>();

        super.setPage(new HostPage(this));
    }

    /**
     * Gets podcasts.
     *
     * @return the podcasts
     */
    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    /**
     * Sets podcasts.
     *
     * @param podcasts the podcasts
     */
    public void setPodcasts(final ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    /**
     * Gets announcements.
     *
     * @return the announcements
     */
    public ArrayList<Announcement> getAnnouncements() {
        return announcements;
    }

    /**
     * Sets announcements.
     *
     * @param announcements the announcements
     */
    public void setAnnouncements(final ArrayList<Announcement> announcements) {
        this.announcements = announcements;
    }

    /**
     * Gets podcast.
     *
     * @param podcastName the podcast name
     * @return the podcast
     */
    public Podcast getPodcast(final String podcastName) {
        for (Podcast podcast: podcasts) {
            if (podcast.getName().equals(podcastName)) {
                return podcast;
            }
        }

        return null;
    }

    /**
     * Gets announcement.
     *
     * @param announcementName the announcement name
     * @return the announcement
     */
    public Announcement getAnnouncement(final String announcementName) {
        for (Announcement announcement: announcements) {
            if (announcement.getName().equals(announcementName)) {
                return announcement;
            }
        }

        return null;
    }

    @Override
    public String userType() {
        return "host";
    }

    public void listenedEpisode(Episode episode) {
        topEpisodes.put(episode, topEpisodes.getOrDefault(episode, 0) + 1);
    }
    public void listenedUser(User user) {
        if (!uniqueListeners.containsKey(user)) {
            uniqueListeners.put(user, true);
            listeners++;
        }
    }
}
