package day5;

import java.util.List;

public class Day5Main {

    public static void main(String[] args) {
        BoardingPassDataProvider provider = new BoardingPassDataProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day5\\inputDay5.txt");
        List<BoardingPass> boardingPasses = provider.getBoardingPassData();
        int maxSeatId = 0;

        for (BoardingPass boardingPass : boardingPasses) {
            int seatId = boardingPass.getSeatId(128, 8);
            if(seatId > maxSeatId) {
                maxSeatId = seatId;
            }
        }

        System.out.println(maxSeatId);
    }
}
