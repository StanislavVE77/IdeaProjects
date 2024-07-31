import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");
        int maxProducts = 8;
        String[] shoppingList = new String[maxProducts];
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
                // проверка на дубликат товара
                for (int i = 0; i < productCount; i++) {
                    if (shoppingList[i].equalsIgnoreCase(product)) {
                        productExist = true;
                        break;
                    }
                }
                if (!productExist) {
                    // увеличение размера массива вдвое с сохранением списка товаров
                    if (productCount == maxProducts) {
                        String[] tempShoppingList = new String[maxProducts * 2];
                        System.arraycopy(shoppingList, 0, tempShoppingList, 0, productCount);
                        shoppingList = tempShoppingList;
                    }
                    shoppingList[productCount] = product;
                    productCount++;
                    System.out.println("Товар " + product + " добавлен в список под номером " + productCount);
                } else {
                    System.out.println("Такой товар уже есть в списке.");
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
