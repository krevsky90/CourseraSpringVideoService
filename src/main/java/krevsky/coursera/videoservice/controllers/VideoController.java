package krevsky.coursera.videoservice.controllers;

import krevsky.coursera.videoservice.client.VideoApi;
import krevsky.coursera.videoservice.model.Video;
import krevsky.coursera.videoservice.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class VideoController implements VideoApi {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    @RequestMapping(value=VIDEO_PATH, method= RequestMethod.GET)
    public @ResponseBody Collection<Video> getAllVideos() {
        return videoRepository.getAllVideos();
    }

    @Override
    @RequestMapping(value=VIDEO_FIND_PATH, method = RequestMethod.GET)
    public @ResponseBody Collection<Video> findByTitle(@RequestParam(TITLE_PARAMETER) String title) {
        return videoRepository.findByTitle(title);
    }

    @Override
    @RequestMapping(value = VIDEO_PATH, method = RequestMethod.POST)
    public @ResponseBody boolean addVideo(@RequestBody Video v) {
        return videoRepository.addVideo(v);
    }

    @Override
    @RequestMapping(value = VIDEO_ADD_ALL_PATH, method = RequestMethod.POST)
    public @ResponseBody boolean addAllVideos(@RequestBody Collection<Video> videos) {
        return videoRepository.addAllVideos(videos);
    }
}
