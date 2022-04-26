import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class JsonCalendar extends TodoCalendar{
    public void consoleUI() {
        while(true) {
            System.out.println("1. 일정 등록");
            System.out.println("2. 일정 검색");
            System.out.println("3. 달력 보기");
            System.out.println("4. 일정 불러오기");
            System.out.println("5. 일정 저장");
            System.out.println("6. 프로그램 종료");

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
                        LocalDate now = LocalDate.now();
                        int nowYear = now.getYear();
                        int nowMonth = now.getMonthValue();
                        int nowDay = circulateDay(nowYear,nowMonth);
                        printCalendar(nowYear,nowMonth);
                        break;
                    case 4:
                        //일정 불러오기
                        break;
                    case 5:
                        //일정 저장
                        break;
                    case 6:
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
        if(!todolist.containsKey(date)) {
            todolist.put(date,new ArrayList<String>());
            todolist.get(date).add(todo);
        } else {
            todolist.get(date).add(todo);
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

    private void saveTodo() {
        Gson saveGson = new Gson();
    }
}
