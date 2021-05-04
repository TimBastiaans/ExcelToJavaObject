package nl.opinity.timbastiaans.interviewskilltest.enums;

import java.io.Serializable;

public enum Positions implements Serializable {
    GOALKEEPER,
    DEFENDER,
    MIDFIELDER,
    FORWARD;

    public String getStatus(){
        return this.name();
    }

}
