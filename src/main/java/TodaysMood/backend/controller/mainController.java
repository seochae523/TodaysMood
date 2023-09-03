package TodaysMood.backend.controller;

import TodaysMood.backend.domain.TodaysMood;
import TodaysMood.backend.repository.MemoryContentsRepository;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class mainController {
    MemoryContentsRepository contentsRepository = new MemoryContentsRepository();


    @ResponseBody
    @PostMapping("todaysMood/save")
    public String saveContents(@RequestBody TodaysMood newMood){
        log.info("moods -> title = {},  date = {}, contents = {}, mood = {}", newMood.getTitle(), newMood.getDate(), newMood.getContext(), newMood.getMood());
        contentsRepository.saveContents(newMood);

        return "ok";
    }

    @ResponseBody
    @GetMapping("todaysMood/list")
    public List<TodaysMood> getAllTodaysMoods(){
        log.info("repo => {}", contentsRepository.findAll());
        return contentsRepository.findAll();

    }

    @ResponseBody
    @PostMapping("/todaysMood/delete")
    public String deleteContent(@RequestBody String date){
        log.info("date = {}", date.substring(0,10));
        contentsRepository.delete(date.substring(0,10));
        return "Deleted";
    }

    @ResponseBody
    @PostMapping("todaysMood/correction")
    public String correctContent(@RequestBody TodaysMood todaysMood){
        contentsRepository.correnction(todaysMood);
        return "corrected";
    }

}
