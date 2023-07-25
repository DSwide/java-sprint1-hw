public class MonthData {
    int[] days = new int[30];

    MonthData() {
        for(int i = 0; i < days.length; i++) { // Мы еще не проходили списки на момент ТЗ, поэтому я старался не использовать знания полученные после ТЗ, чтобы понять базу
            days[i] = 0;
        }

    }

    void printDaysAndStepsFromMonth() { //Да, теперь вижу что переменная goalStepsPerDay тут совсем не нужна.
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
        int daysCount = 0;// c Count вместо Qount читать гораздо проще, самого смущало в момент создания переменной было Q
        int averageStepsInMonth;

        for(int i = 0; i < days.length; ++i) {
            if (days[i] != 0) {
                ++daysCount;
            }
        }

        if (daysCount == 0) {
            daysCount = 1;
        }
        averageStepsInMonth = sumStepsFromMonth() / daysCount;
        return averageStepsInMonth;
    }
}