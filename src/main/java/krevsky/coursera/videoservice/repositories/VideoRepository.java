package krevsky.coursera.videoservice.repositories;

import krevsky.coursera.videoservice.model.Video;

import java.util.Collection;

public interface VideoRepository {
    boolean addVideo(Video v);

    boolean addAllVideos(Collection<Video> videos);

    Collection<Video> getAllVideos();

    Collection<Video> findByTitle(String title);
}
