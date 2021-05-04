package nl.opinity.timbastiaans.interviewskilltest.mo;

import lombok.Data;
import nl.opinity.timbastiaans.interviewskilltest.enums.Positions;

public @Data class FootballPlayer {
    private int backNumber;
    private String firstname;
    private String lastname;
    private Positions position;
    private String club;
    private String country;
}

