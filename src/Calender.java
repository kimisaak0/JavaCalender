import java.util.Scanner;

public class Calender {
    public static void main(String[] args) {
        int[] monthEnd = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);

        int end;
        System.out.println("반복 횟수를 입력하세요");
        end = sc.nextInt();

        for(int i = 0; i < end; i++) {
            System.out.println("원하는 달을 입력하세요.");
            int n;
            do {
                n = sc.nextInt();
                if(n < 1 || n > 12) {
                    System.out.println("1~12 사이의 값을 입력하세요.");
                    System.out.println("원하는 달을 입력하세요.");
                }
            } while(n < 1 || n > 12);

            System.out.printf("%d월은 %d일까지 있습니다. \n",n,monthEnd[n-1]);
        }


        System.out.println("일\t월\t화\t수\t목\t금\t토");
        System.out.println("--------------------------");
        System.out.println("1\t2\t3\t4\t5\t6\t7");
        System.out.println("8\t9\t10\t11\t12\t13\t14");
        System.out.println("15\t16\t17\t18\t19\t20\t21");
        System.out.println("22\t23\t24\t25\t26\t27\t28");
    }
}