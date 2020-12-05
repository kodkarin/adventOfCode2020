package day5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {

    private int numberOfRows = 128;
    private int seatsPerRow = 8;

    @Test
    public void getSeatIdReturns567ForBoardingPassBFFFBBFRRR() {

        BoardingPass boardingPass = new BoardingPass("BFFFBBFRRR");

        int seatId = boardingPass.getSeatId(numberOfRows, seatsPerRow);

        assertEquals(567, seatId);
    }

    @Test
    public void getSeatIdReturns119ForBoardingPassFFFBBBFRRR() {

        BoardingPass boardingPass = new BoardingPass("FFFBBBFRRR");

        int seatId = boardingPass.getSeatId(numberOfRows, seatsPerRow);

        assertEquals(119, seatId);
    }

    @Test
    public void getSeatIdReturns820ForBoardingPassBBFFBBFRLL() {

        BoardingPass boardingPass = new BoardingPass("BBFFBBFRLL");

        int seatId = boardingPass.getSeatId(numberOfRows, seatsPerRow);

        assertEquals(820, seatId);
    }
}