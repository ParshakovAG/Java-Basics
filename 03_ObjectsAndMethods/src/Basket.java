public class Basket {

    private static int count = 0;
    private String items = "";
    private double price = 0;
    private double totalPrice = 0;
    private int limit;
    private double weight = 0;
    private double totalWeight = 0;
    private static double totalPriceBasket;
    private static double totalWeightBasket;
    private static double totalQuantityAllGoods;

    public Basket() {
        increaseCount(1);
        items = "Список товаров: \n";
        this.limit = 1000000;
    }

    public Basket(int limit, double price, double weight) {
        this();
        this.limit = limit;
        this.weight = weight;
        this.price = price;
    }

    public Basket(String items, double price, double totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static void addTotalPriceBasket(double price) {
        totalPriceBasket += price;
    }

    public static void addTotalWeightBasket(double weight) {
        totalWeightBasket += weight;
    }

    public static void addTotalQuantityAllGoods(double totalQuantityAllGoods) {
        totalQuantityAllGoods += count;
    }

    public void add(String name, double price, double weight) {
        add(name, price, weight);
    }

    public void add(String name, double price, int count, double weight, double totalQuantityAllGoods) {
        items += "\n" + name + " - " + count + " шт. - " + price + " р. " + weight + " гр."
                + "\n" + "Общее количество товаров" + " - " + totalQuantityAllGoods + "шт.";
        this.totalPrice += price * count;
        this.totalWeight += weight * count;
        addTotalPriceBasket(price);
        addTotalWeightBasket(weight);
        addTotalQuantityAllGoods (count);
    }

    public static String getTotalWeightBasket() {
        String total;
        total = "Общий вес всех корзин: " + totalWeightBasket;
        return total;
    }

    public static String getTotalPriceBasket() {
        String total;
        total = "Общая стоимость всех корзин: " + totalPriceBasket;
        return total;
    }

    public static String getTotalQuantityAllGoods() {
        String total;
        total = "Общее количество всех товаров: " + totalQuantityAllGoods;
        return total;
    }

    public static String getTotalCostAllBasketToTotalQuantityAllGoods() {
        String total;
        total = "Отношение общей стоимости всех корзин к общему количеству всех товаров: "
                + (totalPriceBasket / totalQuantityAllGoods);
        return total;
    }

    public static String getTotalPriceBasketToCountBasket() {
        String total;
        total = "Отношение общей стоимости всех корзин к количеству корзин: "
                + (totalPriceBasket / count);
        return total;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }



    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
        totalQuantityAllGoods = 0;
    }


    public boolean contains(String name) {

        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
            System.out.println("Вес корзины - 0");
        } else {
            System.out.println(items);
        }
    }
}
