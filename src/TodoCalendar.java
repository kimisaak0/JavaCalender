import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.RandomAccessFile;



public class TodoCalendar extends InputCalendarData {

    static HashMap<String, ArrayList<String>> todolist = new HashMap<>();

    final int EOF = -1;

    public void consoleUI() {
        while(true) {
            System.out.println("1. 일정 등록");
            System.out.println("2. 일정 검색");
            System.out.println("3. 전체 일정 출력");
            System.out.println("4. 달력 보기");
            System.out.println("5. 프로그램 종료");

            Integer whatYear;
            Integer whatMonth;
            Integer whatDate;
            String dayString;

            try {
                switch(sc.nextInt()) {
                    case 1:
                        //일정등록 함수 호출
                        whatYear = inputYear();
                        whatMonth = inputMonth();
                        whatDate = inputDate(whatYear,whatMonth);
                        dayString = whatYear.toString() + whatMonth.toString() +whatDate.toString();
                        System.out.println("일정을 입력하세요.");
                        sc.nextLine();
                        String todoString = sc.nextLine();
                        todoUpdate(dayString,todoString );
                        break;
                    case 2:
                        //일정검색 함수3
                        whatYear = inputYear();
                        whatMonth = inputMonth();
                        whatDate = inputDate(whatYear,whatMonth);
                        printTodo(whatYear.toString() + whatMonth.toString() +whatDate.toString());

                        break;
                    case 3:
                        printAllTodo();
                        break;
                    case 4:
                        LocalDate now = LocalDate.now();
                        int nowYear = now.getYear();
                        int nowMonth = now.getMonthValue();
                        int nowDay = circulateDay(nowYear,nowMonth);
                        printCalendar(nowYear,nowMonth);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("메뉴를 다시 선택해주세요.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("메뉴를 다시 선택해주세요.");
                sc.nextLine();

            }
        }
    }


    private void todoUpdate(String date, String todo) {
        try {
            RandomAccessFile saveTxt = new RandomAccessFile(".\\save\\todoSave.txt", "rw");

            int pf = saveTxt.read();
            while(pf != EOF) {
                pf = saveTxt.read();
            }

            saveTxt.write(date.getBytes());
            saveTxt.write(" ".getBytes());
            saveTxt.write(todo.getBytes());
            saveTxt.write("\n".getBytes());


        } catch(Exception e) {
            System.out.println(e);
        }

        if(!todolist.containsKey(date)) {
            todolist.put(date,new ArrayList<String>());
            todolist.get(date).add(todo);
        } else {
            todolist.get(date).add(todo);
        }
    }

    private void printAllTodo() {
        try {
            RandomAccessFile saveTxt = new RandomAccessFile(".\\save\\todoSave.txt", "rw");
            byte[] oneChar = new byte[2];

            int pf = saveTxt.read(oneChar);

            while (pf != EOF) {
                String ch = new String(oneChar);
                System.out.print(ch);
                pf = saveTxt.read(oneChar);
            }

        } catch(Exception e) {
            System.out.println(e);

        }
    }

    private void printTodo(String date) {


        if(!todolist.containsKey(date)) {
            System.out.println("일정이 없습니다.");
        } else {
            int i = 1;
            for(String todo:todolist.get(date)){
                System.out.printf("%d. %s \n",i++,todo);
            }
        }
    }

    private void printComma(Integer year, Integer month, int cali) {
        Integer date;
        for(int i = 0; i < 7; i++) {
            date = cali - 6 + i;
            if (date-6+i >= 1) {
                if (todolist.containsKey(year.toString()+month.toString()+date.toString())) {
                    System.out.print("`\t");
                } else {
                    System.out.print("\t");
                }
            } else {
                System.out.print("\t");
            }
        }
        System.out.println();
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
                printComma(year, month, i-1);
            }
        }

        System.out.println();
        calendarUI(year, month);

    }

    void calendarUI(int year, int month) {
        boolean keep = true;
        while(keep) {
            System.out.println("1. 이전\t2. 다음\t3. 돌아가기");
            try {
                switch(sc.nextInt()) {
                    case 1:
                        if(month == 1) {
                            printCalendar(year-1, 12);
                        } else {
                            printCalendar(year,month-1);
                        }
                        break;
                    case 2:
                        if (month == 12) {
                            printCalendar(year + 1, 1);
                        }else {
                            printCalendar(year,month+1);
                        }
                        break;
                    case 3:
                        keep = false;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            } catch(InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                sc.nextLine();
            }
        }
    }

}
