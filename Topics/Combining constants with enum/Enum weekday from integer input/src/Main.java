import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayNumber = scanner.nextInt();

        Weekday day = Weekday.values()[dayNumber - 1];
        System.out.println(day);
    }
}

enum Weekday {
    // Define the enum constants here
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

//    private final int value;


//    Weekday(int day) {
//        this.value = day;
//    }

//    @Override
//    public String toString() {
//        return ;
//    }

//    public int getValue(int value) {
//        return va;
//    }
}