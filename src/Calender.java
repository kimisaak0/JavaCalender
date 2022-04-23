import java.util.Scanner;
import java.util.InputMismatchException;

public class Calender {
    static int[] monthEnd = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] leapMonthEnd = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    static Scanner sc = new Scanner(System.in);

    static int inputYear() {
        int year;
        System.out.println("원하는 년도를 입력하세요.");
        while(true) {
            try {
                year = sc.nextInt();
                if(year > 0){
                    break;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("숫자를 입력하세요.");
            }
        }

        return year;
    }

    static boolean leapYear(int year){
        if(year%4==0 && year%100==0 && year%400!=0) {
            return true;
        } else {
            return false;
        }
    }

    static int inputMonth() {
        int month;
        System.out.println("원하는 월을 입력하세요.");
        while(true) {
            try {
                month = sc.nextInt();
                if(month>=1 && month<=12){
                    break;
                } else {
                    System.out.println("0에서 12사이의 수를 입력하세요");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("숫자를 입력하세요.");
            }
        }
        return month;
    }

    static void printCalender(int year, int month) {
        System.out.printf("%d년 %d월\n",year,month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        if(leapYear(year)) {
            for(int i = 1; i <= monthEnd[month-1]; i++ ) {
                System.out.printf("%d\t",i);
                if(i%7==0){
                    System.out.println();
                }
            }
            System.out.println();
            if(month!=2) {
                System.out.println();
            }

        } else {
            for(int i = 1; i <= leapMonthEnd[month-1]; i++ ) {
                System.out.printf("%d\t",i);
                if(i%7==0){
                    System.out.println();
                }
            }
            System.out.println();
            if(month!=2) {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        while(true) {
            printCalender(inputYear(),inputMonth());
            try{
                System.out.println("나가려면 0이나 아무 문자나 입력하세요.");
                int exit = sc.nextInt();
                if(exit == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                break;
            }


        }
    }
}