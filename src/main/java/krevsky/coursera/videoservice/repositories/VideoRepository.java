package krevsky.coursera.videoservice.repositories;

import krevsky.coursera.videoservice.client.VideoApi;
import krevsky.coursera.videoservice.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

import static krevsky.coursera.videoservice.client.VideoApi.*;

// This @RepositoryRestResource annotation tells Spring Data Rest to
// expose the VideoRepository through a controller and map it to the
// "/video" path. This automatically enables you to do the following:
//
// 1. List all videos by sending a GET request to /video
// 2. Add a video by sending a POST request to /video with the JSON for a video
// 3. Get a specific video by sending a GET request to /video/{videoId}
//    (e.g., /video/1 would return the JSON for the video with id=1)
// 4. Send search requests to our findByXYZ methods to /video/search/findByXYZ
//    (e.g., /video/search/findByName?title=Foo)
//
@RepositoryRestResource(path = VIDEO_PATH_WITHOUT_SLASH)
//todo: don't understand in what cases do we need to use collectionResourceRel="video:"
public interface VideoRepository extends CrudRepository<Video, Long> {
    //by default, it already 'contains' CRUD methods => we can add our methods according to special syntax to generate their implementation.
    //see http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html

    //will use 'save' method of CrudRepository
//    boolean addVideo(Video v);

    //will use 'saveAll' method of CrudRepository
//    boolean addAllVideos(Collection<Video> videos);

    //will use 'findAll' method of CrudRepository
//    Collection<Video> getAllVideos();

    // Find all videos with a matching title (e.g., Video.name)
    //need to rename the method since CrudRepository requires special naming convention to create appropriate method automatically
    //i.e. since the field of Video class is 'name' => we have to call method findByName
    Collection<Video> findByName(@Param(TITLE_PARAMETER) String title);

    // The @Param annotation tells Spring Data Rest which HTTP request
    // parameter it should use to fill in the "duration" variable used to
    // search for Videos
    Collection<Video> findByDurationLessThan(@Param(DURATION_PARAMETER) long maxDuration);
}
