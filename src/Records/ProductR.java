package Records;

public record ProductR<T, U>(T article, U price) {
    public static void main(String[] args) {
        ProductR<String, Integer> product1 = new ProductR<>("ABC123R", 100);
        ProductR<Integer, Double> product2 = new ProductR<>(456789, 199.99);

        System.out.println(product1);
        System.out.println(product2);
    }
}



