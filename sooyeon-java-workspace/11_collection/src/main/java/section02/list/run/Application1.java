package section02.list.run;

import section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        /**
         * ## java.util.ArrayList
         * 1. 가장 많이 사용되는 컬렉션
         * 2. 선형 자료구조
         * 3. 내부적으로 배열을 이용하여 요소를 관리, 인덱스로 접근
         * 4. 크기 변경, 요소 추가, 삭제, 정렬 등 제공해줌
         * 5. 타입을 지정하는 것을 추천
         */

        ArrayList alist = new ArrayList();
        List list = new ArrayList();

        ///  add(E e) : 리스트 마지막에 추가
        list.add(1);
        list.add(1.1);
        list.add("wq");
        list.add(1);
        list.add(1,new Music("apt","rose"));
        System.out.println(list); //[1, Music{title='apt', artist='rose'}, 1.1, wq, 1]

        /// get(int index) : 리스트 내의 인자를 인덱스로하여 해당 위치의 요소를 반환함
        System.out.println(list.get(0));


        /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        /// size() 리스트 크기 반환

        for(int i=0; i<nums.size(); i++){
            System.out.println(nums.get(i));
        }

        List<String> seasons = new ArrayList<>();
        seasons.add("Spring");
        seasons.add("Summer");
        seasons.add("Autumn");
        seasons.add("Winter");

        for(String season : seasons){
            System.out.println(season);
        }



    }
}
