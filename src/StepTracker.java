import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        this.scanner = scan;

        for(int i = 0; i < monthToData.length; ++i) {
            this.monthToData[i] = new MonthData();
        }

    }

    String checkGoalPerDay() {
        String text;
        if (goalByStepsPerDay <= 5000) {
            text = " Ты можешь лучше!";
            return text;
        } else if (goalByStepsPerDay > 5000 && goalByStepsPerDay <= 10000) {
            text = " Отличная цель, так держать!";
            return text;
        } else {
            text = " Очень амбициозно, можешь собой гордиться!";
            return text;
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Выберите месяц(1-12)");
        int month = this.scanner.nextInt();
        if (month >= 1 && month <= 12) {
            System.out.println("Выберите день(1-30)");
            int day = this.scanner.nextInt();
            if (day >= 1 && day <= 30) {
                System.out.println("Введите количество шагов");
                int steps = this.scanner.nextInt();
                if (steps > 0) {
                    this.monthToData[month - 1].days[day - 1] = steps;
                } else {
                    System.out.println("Введено некорректное количество шагов, пожалуйста введите целое число");
                }
            } else {
                System.out.println("Введен некорректный день, пожалуйста выберите день 1-30");
            }
        } else {
            System.out.println("Введен некорректный месяц, пожалуйста выберите месяц 1-12");
        }
    }

    void changeStepGoal() {
        System.out.println("Текущая цель: " + goalByStepsPerDay + " шагов в день." + checkGoalPerDay());
        System.out.println("Введите цель по количеству шагов в день: ");
        int goalSteps = scanner.nextInt();
        if (goalSteps <= 0) {
            System.out.println("Введена некорректная цель, цель не может быть меньше или равняться 0");
        } else {
            goalByStepsPerDay = goalSteps;
            System.out.println("Цель успешно сохранена, так держать!");
        }

    }

    void printStatistic() {
        System.out.println("Введите номер месяца (1-12):");
        int monthNum = scanner.nextInt();
        if (monthNum > 0 && monthNum <= 12) {
            MonthData monthData = monthToData[monthNum - 1];
            monthData.printDaysAndStepsFromMonth(this.goalByStepsPerDay);
            System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
            System.out.println("Максимальное количество шагов за месяц: " + monthData.maxSteps());
            System.out.println("Среднее количество шагов за месяц: " + monthData.averageSteps());

            System.out.println("Лучшая серия за месяц составила: " + monthData.bestSeries(goalByStepsPerDay) );

            System.out.println("Расстояние в километрах: " +converter.convertToKm(monthData.sumStepsFromMonth()));

            System.out.println("Всего сожжено Килокаллорий: " + converter.convertStepsToKkal(monthData.sumStepsFromMonth()));
        } else {
            System.out.println("Пожалуйста введите корректный номер месяца (1-12)");
        }

    }
}
