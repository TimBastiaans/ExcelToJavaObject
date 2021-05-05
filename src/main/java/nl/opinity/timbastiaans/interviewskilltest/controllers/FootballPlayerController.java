package nl.opinity.timbastiaans.interviewskilltest.controllers;

import nl.opinity.timbastiaans.interviewskilltest.dtos.FootballPlayersResponse;
import nl.opinity.timbastiaans.interviewskilltest.service.FootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FootballPlayerController {

    @Autowired
    private FootballPlayerService footballPlayerService;

    @PostMapping("/")
    public ResponseEntity<FootballPlayersResponse> getFootballPlayersFromExcel(@RequestPart("file") MultipartFile file) throws IOException {
        return new ResponseEntity(footballPlayerService.getFootballPlayersFromExcel(file), HttpStatus.OK);
    }
}
