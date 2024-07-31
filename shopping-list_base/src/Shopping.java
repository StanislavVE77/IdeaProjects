import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8];
        int productCount = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");
            System.out.print("--> ");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {
                System.out.println("Введите название товара:");
                System.out.print("--> ");
                String product = scanner.next();
                boolean productExist = false;
                if (productCount < 8) {
                    for (int i = 0; i < productCount; i++) {
                        System.out.println("Сравниваем с " + shoppingList[i]);
                        if (shoppingList[i].equals(product)) {
                            productExist = true;
                        }
                    }
                    if (!productExist) {
                        shoppingList[productCount] = product;
                        productCount++;
                        System.out.println("Товар " + product + " добавлен в список под номером " + productCount);
                    } else {
                        System.out.println("Такой товар уже есть в списке.");
                    }
                } else {
                    System.out.println("Список товаров заполнен. Отложите покупку до следующего раза.");
                }
            } else if (actionNumber == 2) {
                if (productCount == 0) {
                    System.out.println("Список товаров пуст!");
                } else {
                    for (int i = 0; i < productCount; i++) {
                        System.out.println((i + 1) + ". " + shoppingList[i]);
                    }
                }
            } else if (actionNumber == 3) {
                for (int i = 0; i < productCount; i++) {
                    shoppingList[productCount] = null;
                }
                productCount = 0;
                System.out.println("Список товаров очищен");
            } else if (actionNumber == 4) {
                System.out.println("До скорых встреч!");
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
