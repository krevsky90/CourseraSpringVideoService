package krevsky.coursera.videoservice.controllers;

import com.google.common.collect.Lists;
import krevsky.coursera.videoservice.client.VideoApi;
import krevsky.coursera.videoservice.model.Video;
import krevsky.coursera.videoservice.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class VideoController implements VideoApi {
    //no ideas why IDE marks videoRepository as dependency that can't be autowired, but in fact it is successfully resolved when the application starts
    @Autowired
    private VideoRepository videoRepository;

    @Override
    @RequestMapping(value=VIDEO_PATH, method= RequestMethod.GET)
    public @ResponseBody Collection<Video> getAllVideos() {
        return Lists.newArrayList(videoRepository.findAll());
    }

    @Override
    @RequestMapping(value=VIDEO_FIND_PATH, method = RequestMethod.GET)
    public @ResponseBody Collection<Video> findByTitle(@RequestParam(TITLE_PARAMETER) String title) {
        return videoRepository.findByName(title);
    }

    @Override
    @RequestMapping(value = VIDEO_PATH, method = RequestMethod.POST)
    public @ResponseBody boolean addVideo(@RequestBody Video v) {
        videoRepository.save(v);
        return true;
    }

    @Override
    @RequestMapping(value = VIDEO_ADD_ALL_PATH, method = RequestMethod.POST)
    public @ResponseBody boolean addAllVideos(@RequestBody Collection<Video> videos) {
        videoRepository.saveAll(videos);
        return true;
    }
}
