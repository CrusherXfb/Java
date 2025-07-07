package Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class NextElectionDay {

    public static LocalDate getElectionDay(int year) {
        LocalDate novemberFirst = LocalDate.of(year, 11, 1);
        LocalDate firstMonday = novemberFirst.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        return firstMonday.plusDays(1);
    }

    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();
        int nextElectionYear = currentYear % 4 == 0 ? currentYear : currentYear + (4 - currentYear % 4);

        LocalDate electionDay = getElectionDay(nextElectionYear);

        // Форматтер с русской локалью
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));

        System.out.println("Ближайшие выборы в США пройдут:");
        System.out.println(electionDay.format(formatter));

        System.out.println("\nБлижайшие 10 выборов в США пройдут:");

        for (int i = 0; i < 10; i++) {
            int currentYearCycle = LocalDate.now().getYear() + (4 * i);
            int nextElectionYearCycle = currentYearCycle % 4 == 0 ? currentYearCycle : currentYearCycle + (4 - currentYearCycle % 4);
            LocalDate electionDayCycle = getElectionDay(nextElectionYearCycle);
            System.out.println(electionDayCycle.format(formatter));
        }

    }
}

