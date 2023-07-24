public class MonthData {
    int[] days = new int[30];

    MonthData() {
        for(int i = 0; i < days.length; i++) {
            days[i] = 0;
        }

    }

    void printDaysAndStepsFromMonth(int goalByStepsPerDay) {
        for(int i = 0; i < days.length; i++) {
            int dayOfMonth = i + 1;
            System.out.println("День " + dayOfMonth + ". Пройдено: " + days[i] + " шагов. Молодцом!");
        }

    }

    int sumStepsFromMonth() {
        int sumSteps = 0;

        for(int i = 0; i < days.length; ++i) {
            sumSteps = sumSteps + days[i];
        }

        return sumSteps;
    }

    int maxSteps() {
        int maxStepsInMonth = 0;

        for(int i = 0; i < days.length; i++) {
            if (maxStepsInMonth < days[i]) {
                maxStepsInMonth = days[i];
            }
        }

        return maxStepsInMonth;
    }

    int bestSeries(int goalByStepPerDay) {
        int maxSeries = 0;
        int currentSeries = 0;

        for(int i = 0; i < days.length; i++) {
            if (days[i] == 0) {
                currentSeries = 0;
            } else if (days[i] > goalByStepPerDay) {
                ++currentSeries;
            }

            if (currentSeries > maxSeries) {
                maxSeries = currentSeries;
            }
        }

        return maxSeries;
    }

    int averageSteps() {
        int daysQount = 0;
        int averageStepsInMonth;

        for(int i = 0; i < days.length; ++i) {
            if (days[i] != 0) {
                ++daysQount;
            }
        }

        if (daysQount == 0) {
            daysQount = 1;
            averageStepsInMonth = sumStepsFromMonth() / daysQount;
        } else {
            averageStepsInMonth = sumStepsFromMonth() / daysQount;
        }

        return averageStepsInMonth;
    }
}