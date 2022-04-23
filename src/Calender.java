import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        int[] monthEnd = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);

        while (true) {
           System.out.println("원하는 달을 입력하세요. 0을 입력하면 종료됩니다.");
           int n = sc.nextInt();
           if(n==0) {
               break;
           }
           if(n<1 || n>12){
               System.out.println("0에서 12사이의 수를 입력하세요");
           } else {
               System.out.printf("%d월은 %d일까지 있습니다.\n", n, monthEnd[n - 1]);
           }
        }

        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.println("--------------------------");
        System.out.println("1\t2\t3\t4\t5\t6\t7");
        System.out.println("8\t9\t10\t11\t12\t13\t14");
        System.out.println("15\t16\t17\t18\t19\t20\t21");
        System.out.println("22\t23\t24\t25\t26\t27\t28");
    }
}