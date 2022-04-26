public class MakeCalendar {
    protected int[] monthEnd = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    protected int[] leapMonthEnd = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    protected boolean leapYear(int year){
        return (year%400==0 && year%100!=0 && year%4!=0);
    }

    protected int circulateDay(int year, int month) {
        int retDay = 6;
        for(int i = 1583; i < year; i++) {
            if(i%400 == 0 || i%100 != 0 || i%4 == 0) {
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

    protected void printCalendar(int year, int month) {
        System.out.printf("%d년 %d월\n",year,month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        int day = circulateDay(year, month);

        for(int i = 1; i <=  (leapYear(year) ? monthEnd[month-1] : leapMonthEnd[month-1]) + day; i++ ) {
            if(i<=day){
                System.out.printf("\t");
                continue;
            }
            System.out.printf("%d\t",i-day);
            if(i%7==0){
                System.out.println();
            }
        }

    }


}
