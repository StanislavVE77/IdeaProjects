import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
// *** код для тестирования ( автозаполнение данными сразу двух месяцев)
//        MonthData monthData0 = monthToData[0];
//        monthData0.days = new int[]{101,100,100,11000,11000,100,100,11000,11000,11000,11000,11000,7100,100,100,11000,11000,11000,100,100,100,100,100,100,100,100,11000,100,100,100};
//        MonthData monthData1 = monthToData[1];
//        monthData1.days = new int[]{100,100,7100,11000,11000,100,100,11000,11000,11000,11000,11000,7100,7100,100,13000,13500,11000,100,100,100,100,7100,100,100,100,11000,7100,100,100};

        System.out.println("Введите номер месяца");
        System.out.print("--> ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неверный номер месяца");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        System.out.print("--> ");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Неверный номер дня");
            return;
        }
        System.out.println("Введите количество шагов" );
        System.out.print("--> ");
        int step = scanner.nextInt();
        if (step < 1) {
            System.out.println("Указано неверное количество шагов");
            return;
        }
        MonthData monthData = monthToData[month-1];
        monthData.days[day - 1] = step;
    }

    void changeStepGoal(){
        System.out.print("Введите новое значение цели: ");
        int stepGoal = scanner.nextInt();
        if (stepGoal <= 0) {
            System.out.println("Цель должна быть больше нуля!");
            return;
        }
        goalByStepsPerDay = stepGoal;
    }

    void printStatistic() {
        System.out.print("Для вывода статистики введите номер месяца от 1 до 12: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неверный номер месяца");
            return;
        }

        MonthData monthData = monthToData[month-1];

        System.out.println("Количество пройденных шагов по дням: ");
        monthData.printDaysAndStepsFromMonth();

        System.out.print("*** Общее количество шагов за месяц: ");
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println(sumSteps);

        System.out.print("*** Максимальное пройденное количество шагов за месяц: ");
        System.out.println(monthData.maxSteps());

        System.out.print("*** Среднее количество шагов: ");
        int averageNumberSteps = (int) monthData.sumStepsFromMonth() / 30;
        System.out.println(averageNumberSteps);

        System.out.print("*** Пройденная дистанция (в км): ");
        System.out.println(converter.convertToKm(sumSteps));

        System.out.print("*** Количество сожжённых килокалорий: ");
        System.out.println(converter.convertStepsToKilocalories(sumSteps));

        System.out.print("*** Лучшая серия: ");
        int bestSeries = monthData.bestSeries(goalByStepsPerDay);
        System.out.println(bestSeries);
    }
}