package Types;

public class Integer21 {
    public static void main (String[] args) {
        int secondsN = 2445;
        int minutesN = secondsN / 60;
        int secondsNew = secondsN % 60;
        System.out.println("С начала суток прошло " + secondsN + " секунд");
        System.out.println("С начала суток прошло " + minutesN + " минут");
        System.out.println("С начала последней минуты прошло " + secondsNew + " секунд");
    }
}
