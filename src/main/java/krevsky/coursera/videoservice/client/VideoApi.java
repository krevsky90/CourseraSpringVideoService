package krevsky.coursera.videoservice.client;

import krevsky.coursera.videoservice.model.Video;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

//API - contract for potential client

public interface VideoApi {
    String VIDEO_PATH = "/video";
    String VIDEO_PATH_WITHOUT_SLASH = "video";
    String VIDEO_FIND_PATH = VIDEO_PATH + "/find";
    String VIDEO_ADD_ALL_PATH = VIDEO_PATH + "/addAll";
    String TITLE_PARAMETER = "title";
    String DURATION_PARAMETER = "duration";

    Collection<Video> getAllVideos();

    Collection<Video> findByName(String title);

    boolean addVideo(Video v);

    boolean addAllVideos(Collection<Video> videos);

    Collection<Video> findByDurationLessThan(long maxDuration);
}
