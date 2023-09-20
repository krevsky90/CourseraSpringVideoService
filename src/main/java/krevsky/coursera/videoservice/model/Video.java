package krevsky.coursera.videoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Video {
    @Id                                             // mark the field as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // optional thing that provides unique generated ID
    private Long id;
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

    public Long getId() {
        return id;
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