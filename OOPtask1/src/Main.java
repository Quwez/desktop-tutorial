public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование MyHashSet ===");
        MyHashSet<String> fruits = new MyHashSet<>();

        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Груша");

        System.out.println("Список фруктов: " + fruits);
        System.out.println("Размер: " + fruits.size());

        boolean addedAgain = fruits.add("Яблоко");
        System.out.println("Получилось добавить 'Яблоко' еще раз? " + addedAgain);

        System.out.println("Есть ли 'Банан'? " + fruits.contains("Банан"));
        System.out.println("Есть ли 'Апельсин'? " + fruits.contains("Апельсин"));

        fruits.remove("Банан");
        System.out.println("После удаления банана: " + fruits);
        System.out.println("Размер после удаления: " + fruits.size());

        System.out.println("\n=== Тестирование MyHashMultiSet ===");
        MyHashMultiSet<String> cart = new MyHashMultiSet<>();

        cart.add("Хлеб");
        cart.add("Молоко");
        cart.add("Хлеб");
        cart.add("Хлеб");
        cart.add("Сыр");

        System.out.println("Товары в корзине: " + cart);
        System.out.println("Всего единиц товара: " + cart.size());
        System.out.println("Сколько батонов хлеба: " + cart.count("Хлеб"));

        System.out.println("\nУдаляем один 'Хлеб':");
        cart.remove("Хлеб");
        System.out.println("Осталось хлеба: " + cart.count("Хлеб"));
        System.out.println("Всего единиц товара теперь: " + cart.size());
        System.out.println("Текущее состояние: " + cart);
    }
}