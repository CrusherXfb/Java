package Records;

public class Product<T, U> {
    private T article;
    private U price;

    public Product(T article, U price) {
        this.article = article;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "article=" + article + ", price=" + price + '}';
    }

    public static void main(String[] args) {
        Product<String, Integer> product1 = new Product<>("ABC123", 100);
        Product<Integer, Double> product2 = new Product<>(456789, 199.99);

        System.out.println(product1);
        System.out.println(product2);
    }
}


