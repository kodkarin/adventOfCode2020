package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5Main {

    public static void main(String[] args) {
        BoardingPassDataProvider provider = new BoardingPassDataProvider("C:\\Users\\Admin\\IdeaProjects\\adventOfCode2020\\src\\main\\day5\\inputDay5.txt");
        List<BoardingPass> boardingPasses = provider.getBoardingPassData();
        List<Integer> seatIds = new ArrayList<>();

        for (BoardingPass boardingPass : boardingPasses) {
            seatIds.add(boardingPass.getSeatId(128, 8));
        }

        Collections.sort(seatIds);

        for (int i = 0; i < seatIds.size() - 1; i++) {
            if(seatIds.get(i) != seatIds.get(i + 1) - 1) {
                System.out.println(seatIds.get(i) + 1);
            }
        }
    }
}
