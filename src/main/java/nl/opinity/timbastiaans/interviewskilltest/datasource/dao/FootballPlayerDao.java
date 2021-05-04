package nl.opinity.timbastiaans.interviewskilltest.datasource.dao;


import nl.opinity.timbastiaans.interviewskilltest.enums.Positions;
import nl.opinity.timbastiaans.interviewskilltest.mo.FootballPlayer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class FootballPlayerDao implements Dao<FootballPlayer>{

    private List<FootballPlayer> footballPlayers = new ArrayList<>();

    public Optional<FootballPlayer> get(long id) {
        return Optional.ofNullable(footballPlayers.get((int) id));
    }

    public List<FootballPlayer> getAll() {
        return footballPlayers;
    }

    public void add(FootballPlayer player) {
        footballPlayers.add(player);
    }

    public void update(FootballPlayer player, Object[] params) {
        player.setFirstname(Objects.requireNonNull(
                params[0].toString(), "Firstname cannot be null"));
        player.setLastname(Objects.requireNonNull(
                params[1].toString(), "Lastname cannot be null"));
        player.setClub(Objects.requireNonNull(
                params[2].toString(), "Club cannot be null"));
        player.setCountry(Objects.requireNonNull(
                params[3].toString(), "Country cannot be null"));
        Positions position = Enum.valueOf(Positions.class, params[5].toString());
        player.setPosition(Objects.requireNonNull(
                position, "Position cannot be null"));
        player.setBackNumber((int) params[4]);
        footballPlayers.add(player);
    }

    @Override
    public void delete(FootballPlayer player) {

    }

    public void delete(Optional<FootballPlayer> player) {
        footballPlayers.remove(player);
    }
}
