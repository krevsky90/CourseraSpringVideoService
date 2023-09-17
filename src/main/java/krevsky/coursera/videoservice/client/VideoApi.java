package krevsky.coursera.videoservice.client;

import krevsky.coursera.videoservice.model.Video;

import java.util.Collection;

//API - contract for potential client

public interface VideoApi {
    String VIDEO_PATH = "/video";
    String VIDEO_FIND_PATH = VIDEO_PATH + "/find";
    String VIDEO_ADD_ALL_PATH = VIDEO_PATH + "/addAll";
    String TITLE_PARAMETER = "title";

    Collection<Video> getAllVideos();

    Collection<Video> findByTitle(String title);

    boolean addVideo(Video v);

    boolean addAllVideos(Collection<Video> videos);
}
