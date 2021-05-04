package nl.opinity.timbastiaans.interviewskilltest.mo;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;
import nl.opinity.timbastiaans.interviewskilltest.enums.Positions;

public class FootBallPlayersExcel {

    @ExcelRow
    private int rowIndex;

    @ExcelCellName("Firstname")
    private String firstname;

    @ExcelCellName("Lastname")
    private String lastname;

    @ExcelCellName("Backnumber")
    private int backNumber;

    @ExcelCellName("Position")
    private Positions position;

    @ExcelCellName("Club")
    private String club;

    @ExcelCellName("Country")
    private String country;

    @Override
    public String toString() {
        return System.lineSeparator() +
                " firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", backNumber=" + backNumber +
                ", position=" + position +
                ", club='" + club + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
