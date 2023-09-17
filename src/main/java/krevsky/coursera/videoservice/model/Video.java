package krevsky.coursera.videoservice.model;

import java.util.Objects;

public class Video {
    private String name;
    private String url;
    private int duration;

    public Video() {}

    public Video(String name, String url, int duration) {
        super();
        this.name = name;
        this.url = url;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return duration == video.duration && Objects.equals(name, video.name) && Objects.equals(url, video.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, duration);
    }
}