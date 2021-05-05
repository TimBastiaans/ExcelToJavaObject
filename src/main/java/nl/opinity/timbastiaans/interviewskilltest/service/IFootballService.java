package nl.opinity.timbastiaans.interviewskilltest.service;

import nl.opinity.timbastiaans.interviewskilltest.domain.FootBallPlayersExcel;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface IFootballService {
    List<FootBallPlayersExcel> getFootballPlayersFromExcel(MultipartFile file) throws IOException;
}
