package day3;

import java.util.List;

public class Landscape {

    private List<String> landscapeMap;

    public Landscape(List<String> landscapeMap) {
        this.landscapeMap = landscapeMap;
    }

    public List<String> getLandscapeMap() {
        return landscapeMap;
    }

    public void setLandscapeLocation(int x, int y, char character) {

    }

    public char getCharacterAtLocation(int x, int y) {
        return landscapeMap.get(x).charAt(y);
    }
}
