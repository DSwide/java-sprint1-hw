import java.util.Scanner;

public class Converter {
    Scanner scanner;
    int distance;
    int kKal;

    public Converter() {
    }

    int convertToKm(int steps) {
        this.distance = steps * 75 / 100000;
        return this.distance;
    }

    int convertStepsToKkal(int steps) {
        this.kKal = steps * 50 / 1000;
        return this.kKal;
    }
}
