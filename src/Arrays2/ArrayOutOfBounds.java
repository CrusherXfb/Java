package Arrays2;

public class ArrayOutOfBounds {
    public static void main(String[] strings) {
        try {
            int[] numbers = new int[3];
            numbers[4] = 45;
            System.out.println(numbers[4]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Возникла ошибка выхода за границы массива");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Программа завершена");

        int d = 0;
        //int g = 10 / d;
    }
}
