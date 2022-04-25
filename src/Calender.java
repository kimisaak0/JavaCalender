import java.time.MonthDay;
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
        return (year%400==0 && year%100!=0 && year%4!=0);
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
                    System.out.println("1에서 12사이의 수를 입력하세요");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("숫자를 입력하세요.");
            }
        }
        return month;
    }

    static int inputDay() {
        int day;
        System.out.println("입력한 달의 시작 요일을 입력하세요.");
        System.out.println("일=0 월=1 화=2 수=3 목=4 금=5 토=6");
        while(true) {
            try {
                day = sc.nextInt();
                if(day>=0&&day<=6) {
                    break;
                } else {
                    System.out.println("0부터 6사이의 수를 입력하세요.");
                }
            } catch(InputMismatchException e) {
                sc.nextLine();
                System.out.println("숫자를 입력하세요.");
            }
        }
        return day;
    }

    static int circulateDay(int year, int month) {
        int retDay = 6;
        for(int i = 1583; i < year; i++) {
            if(i%400 == 0) {
                retDay += 2;
            } else if (i%100 == 0) {
                retDay += 1;
            } else if (i%4 == 0) {
                retDay += 2;
            } else {
                retDay += 1;
            }
        }

        for (int i = 1; i <month; i++) {
            if(leapYear(year)) {
                retDay += leapMonthEnd[i-1];
            } else {
                retDay += monthEnd[i-1];
            }
        }

        return retDay%7;

    }


    static void printCalender(int year, int month, int day) {
        System.out.printf("%d년 %d월\n",year,month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        if(leapYear(year)) {
            for(int i = 1; i <= monthEnd[month-1]+day; i++ ) {
                if(i<=day) {
                    System.out.printf("\t");
                    continue;
                }
                System.out.printf("%d\t",i-day);
                if(i%7==0){
                    System.out.println();
                }
            }
            System.out.println();
            if(month!=2) {
                System.out.println();
            }

        } else {
            for(int i = 1; i <= leapMonthEnd[month-1]+day; i++ ) {
                if(i<=day){
                    System.out.printf("\t");
                    continue;
                }
                System.out.printf("%d\t",i-day);
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
        int nowYear, nowMonth;

        while(true) {
            nowYear = inputYear();
            nowMonth = inputMonth();

            printCalender(nowYear,nowMonth,circulateDay(nowYear, nowMonth));
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