package Begin;

public class Begin36 {
    public static void main (String[] args) {
        int speed1 = 20; //km/h
        int speed2 = 50; //km/h
        int distance = 100; //kilometers
        int time = 4; //hours
        int distanceOverTime = distance + (speed1 + speed2) * time;
        System.out.println("Автомобиль-1 - " + speed1 + " км/ч");
        System.out.println("Автомобиль-2 - " + speed2 + " км/ч");
        System.out.println("Начальное расстояние - " + distance + " км");
        System.out.print("Дистанция между автомобилями через " + time + " часов: " + distanceOverTime + " км");
    }
}
