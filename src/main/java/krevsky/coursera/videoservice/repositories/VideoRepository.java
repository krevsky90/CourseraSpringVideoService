package krevsky.coursera.videoservice.repositories;

import krevsky.coursera.videoservice.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
    //will use 'save' method of CrudRepository
//    boolean addVideo(Video v);

    //will use 'saveAll' method of CrudRepository
//    boolean addAllVideos(Collection<Video> videos);

    //will use 'findAll' method of CrudRepository
//    Collection<Video> getAllVideos();

    // Find all videos with a matching title (e.g., Video.name)
    //need to rename the method since CrudRepository requires special naming convention to create appropriate method automatically
    //i.e. since the field of Video class is 'name' => we have to call method findByName
    Collection<Video> findByName(String title);
}
