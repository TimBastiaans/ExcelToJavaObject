package nl.opinity.timbastiaans.interviewskilltest.service;

import nl.opinity.timbastiaans.interviewskilltest.datasource.dao.FootballPlayerDao;
import nl.opinity.timbastiaans.interviewskilltest.mo.FootballPlayer;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class FootballPlayerService implements IFootballService {

    @Inject
    private FootballPlayerDao footballPlayerDao;

    public FootballPlayerService(FootballPlayerDao footballPlayerDao) {
        this.footballPlayerDao = footballPlayerDao;
    }
    public FootballPlayerService() {

    }

    public Optional<FootballPlayer> getOneFootballPlayer(int id){
        //Usually check for authorization here
        return footballPlayerDao.get(id);
    }

    public List<FootballPlayer> getAllFootballPlayers() {
        //Usually check for authorization here
        return footballPlayerDao.getAll();
    }

    public void addFootballPlayerToList(FootballPlayer player){
        //Usually check for authorization here
        footballPlayerDao.add(player);
    }

    public void removeFootballPlayerFromList(long id){
        //Usually check for authorization here
        footballPlayerDao.delete(footballPlayerDao.get(id));
    }
}
