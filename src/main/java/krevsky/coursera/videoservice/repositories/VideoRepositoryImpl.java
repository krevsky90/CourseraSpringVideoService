package krevsky.coursera.videoservice.repositories;

import krevsky.coursera.videoservice.model.Video;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class VideoRepositoryImpl implements VideoRepository {
    private Collection<Video> videos = new ArrayList<>();
    @Override
    public boolean addVideo(Video v) {
        return videos.add(v);
    }

    @Override
    public boolean addAllVideos(Collection<Video> vs) {
        return videos.addAll(vs);
    }

    @Override
    public Collection<Video> getAllVideos() {
        return videos;
    }

    @Override
    public Collection<Video> findByTitle(String title) {
        Set<Video> matches = new HashSet<>();
        for(Video video : videos){
            if(video.getName().equals(title)){
                matches.add(video);
            }
        }
        return matches;
    }
}
