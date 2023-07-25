import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        System.out.println("Добро пожаловать в StepSocks, для продолжения введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Рады знакомству! " + name + "!");


        while(true) { //Убрал один из циклов, он появился в результате декомпиляции, не заметил когда восстанавливал код
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else {
                if (command == 4) {
                    System.out.println("Молодцом " + name + "! До скорых встреч!");
                    return;
                }

                System.out.println("Такой команды еще не существует, пожалуйста выберите команду из списка!");
                }
            }
        }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1- Ввести количество пройденных шагов");
        System.out.println("2- Изменить цель по количеству шагов");
        System.out.println("3- Вывести статистику за Месяц");
        System.out.println("4- Выйти из приложения");
    }
}
