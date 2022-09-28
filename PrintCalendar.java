import java.util.Scanner;

public class PrintCalendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input year and month
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        System.out.println("Enter month(from 1 to 12): ");
        int month = scanner.nextInt();
        // print month
        printMonth(year, month);
    }

    public static void printMonth(int year, int month) {
        // print title
        printTitle(year, month);
        // print body
        printBody(year, month);
    }

    public static void printTitle(int year, int month) {
        System.out.println("     " + getMonthName(month) + "," + year);
        System.out.println("  ---------------------------");
        System.out.println("  Sun Mon Tue Wed Thu Fri Sat");
    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        ;
        return monthName;
    }

    public static void printBody(int year, int month) {
        int startDay = getStartDayOfMonth(year, month);
        int daysInMonth = getDaysInMonth(year, month);
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%4d", i);
            if ((i + startDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static int getStartDayOfMonth(int year, int month) {
        int START_DAY_FOR_JAN_1_1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        return (START_DAY_FOR_JAN_1_1800 + totalNumberOfDays) % 7;
    }

    public static int getDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) return 31;
        else if (month == 9 || month == 4 || month == 6 || month == 11) return 30;
        else if (isLeap(year)) return 29;
        else return 28;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int totalNumberOfDays = 0;
        for (int i = 1800; i < year; i++) {
            if (isLeap(i)) {
                totalNumberOfDays += 366;
            } else {
                totalNumberOfDays += 365;
            }
        }
        for (int j = 1; j < month; j++) {
            totalNumberOfDays += getDaysInMonth(year, j);
        }
        return totalNumberOfDays;
    }

    public static boolean isLeap(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}