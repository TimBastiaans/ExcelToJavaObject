package nl.opinity.timbastiaans.interviewskilltest.controllers;

import nl.opinity.timbastiaans.interviewskilltest.mo.FootballPlayer;
import nl.opinity.timbastiaans.interviewskilltest.service.FootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FootballPlayerController {

    @Autowired
    private FootballPlayerService footballPlayerService;

    @GetMapping("/{id}")
    public Optional<FootballPlayer> GetOneFootballPlayer(@PathVariable int id){
        return footballPlayerService.getOneFootballPlayer(id);
    }

    @GetMapping("/")
    public List<FootballPlayer> getAllFootballPlayers(){
        return footballPlayerService.getAllFootballPlayers();
    }

    @PostMapping("/")
    public FootballPlayer addFootballPlayer(@RequestBody FootballPlayer player){
        footballPlayerService.addFootballPlayerToList(player);
        System.out.println(player);
        return player;
    }
    @PostMapping("/{id}")
    public List<FootballPlayer> deleteFootballPlayer(@PathVariable int id){
        footballPlayerService.removeFootballPlayerFromList(id);
        return footballPlayerService.getAllFootballPlayers();
    }


}
