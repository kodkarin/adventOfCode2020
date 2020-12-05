package day5;

public class BoardingPass {

    private String boardingCode;

    public BoardingPass(String boardingCode) {
        this.boardingCode = boardingCode;
    }

    public int getSeatId(int numberOfRows, int seatsPerRow) {
        int row = getRowNumber(numberOfRows);
        int seat = getSeat(seatsPerRow);
        return row * seatsPerRow + seat;
    }

    private int getRowNumber(int numberOfRows) {
        char[] letters = boardingCode.toCharArray();
        int minRow = 0;
        int maxRow = numberOfRows - 1;

        for (int i = 0; i < 7; i++) {
            char letter = letters[i];
            int difference = maxRow - minRow;

            if (letter == 'F') {
                maxRow -= (difference + 1) / 2;
            } else if (letter == 'B') {
                minRow += (difference + 1) / 2;
            } else {
                return -1;
            }
        }
        return maxRow == minRow ? maxRow : -1;
    }

    private int getSeat(int seatsPerRow) {
        char[] letters = boardingCode.toCharArray();
        int minSeat = 0;
        int maxSeat = seatsPerRow - 1;

        for (int i = 7; i < 10; i++) {
            char letter = letters[i];
            int difference = maxSeat - minSeat;

            if (letter == 'L') {
                maxSeat -= (difference + 1) / 2;
            } else if (letter == 'R') {
                minSeat += (difference + 1) / 2;
            } else {
                return -1;
            }
        }
        return maxSeat == minSeat ? maxSeat : -1;
    }
}
