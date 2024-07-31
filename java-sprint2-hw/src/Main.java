import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                tracker.addNewNumberStepsPerDay();
            } else if (cmd == 2) {
                tracker.changeStepGoal();
            } else if (cmd == 3) {
                tracker.printStatistic();
            } else if (cmd == 4) {
                System.out.println("Выход.");
                return;
            } else {
                System.out.println("Введена некорректная команда.");
            }
        }
    }

    static void printMenu() {
        System.out.println("");
        System.out.println("Введите команду :");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
        System.out.print("--> ");
    }
}

