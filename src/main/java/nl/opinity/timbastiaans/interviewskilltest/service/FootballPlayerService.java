package nl.opinity.timbastiaans.interviewskilltest.service;

import com.poiji.bind.Poiji;
import nl.opinity.timbastiaans.interviewskilltest.domain.FootBallPlayersExcel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FootballPlayerService implements IFootballService {

    @Override
    public List<FootBallPlayersExcel> getFootballPlayersFromExcel(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        List<FootBallPlayersExcel> players = Poiji.fromExcel(convFile, FootBallPlayersExcel.class);
        fos.close();

        return players;
    }
}
