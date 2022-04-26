import java.util.Scanner;
import java.util.InputMismatchException;

public class InputCalendarData extends MakeCalendar {
    Scanner sc = new Scanner(System.in);

    Integer inputYear() {
        int year;
        System.out.println("원하는 년도를 입력하세요.");
        while(true) {
            try {
                year = sc.nextInt();
                if(year > 1582 && year <2500){
                    break;
                } else {
                    System.out.println("1583이상 2500이하의 숫자를 입력하세요.");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("1583이상 2500이하의 숫자를 입력하세요.");
            }
        }

        return year;
    }

    Integer inputMonth() {
        int month;
        System.out.println("원하는 월을 입력하세요.");
        while(true) {
            try {
                month = sc.nextInt();
                if(month>=1 && month<=12){
                    break;
                } else {
                    System.out.println("1에서 12사이의 수를 입력하세요");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("1에서 12사이의 수를 입력하세요");
            }
        }
        return month;
    }

    Integer inputDate(int year, int month) {
        int date;
        System.out.println("날짜를 입력하세요.");
        while(true) {
            try {
                date = sc.nextInt();
                if (leapYear(year)) {
                    if (date > 0 && date <= leapMonthEnd[month]) {
                        return date;
                    } else {
                        System.out.println("실제로 있는 날짜를 입력하세요.");
                    }
                } else {
                    if (date > 0 && date <= monthEnd[month]) {
                        return date;
                    } else {
                        System.out.println("실제로 있는 날짜를 입력하세요.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("실제로 있는 날짜를 입력하세요.");
            }
        }
    }


}
