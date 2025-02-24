package section02.list.run;

import java.util.Arrays;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        String[] seasonArray = {"Spring", "Summer", "Autumn", "Winter"};
        List<String> seasonList = Arrays.asList(seasonArray);

        /**
         * asList 주의
         * - fixed-size로 반환함 - 크기 변경 불가
         * - 새로운 요소 추가 삭제 불가 기존 데이터 변경은 가능
         */

        //list.set(int index, E e) : 인자로 전달된 인덱스 위치와 요소를 새로이 전달된 요소로 변경
        seasonList.set(0,"spring");

        //Array.asList로 바로 담아서 저장
        List<String> cars = Arrays.asList("제네시스","벤츠","비엠더블유");
        List<String> hobbys = List.of("운동","게임","타투");
        cars.set(0,"변경");
        System.out.println(cars);
        System.out.println(hobbys);
    }
}
