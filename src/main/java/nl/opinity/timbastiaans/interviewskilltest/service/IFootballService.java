package nl.opinity.timbastiaans.interviewskilltest.service;

import nl.opinity.timbastiaans.interviewskilltest.mo.FootballPlayer;

import java.util.List;
import java.util.Optional;

public interface IFootballService {
        Optional<FootballPlayer> getOneFootballPlayer(int id);
        List<FootballPlayer> getAllFootballPlayers();
        void addFootballPlayerToList(FootballPlayer player);
        void removeFootballPlayerFromList(long id);
}
