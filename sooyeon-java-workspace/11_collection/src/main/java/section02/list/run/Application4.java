package section02.list.run;

import section02.list.comparator.AscendingTitle;
import section02.list.comparator.DescendingTitle;
import section02.list.dto.Music;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {

        List<String> fruits  = Arrays.asList("a", "b", "c");
        Collections.sort(fruits);
        //System.out.println(fruits);

       List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       //Collections.sort(numbers,Collections.reverseOrder());
       Collections.reverse(numbers); //내림차순이 아니라 그냥 뒤집는 것
       numbers.sort(Comparator.reverseOrder());
       // System.out.println(numbers);

        List<Music> musics = Arrays.asList(new Music("c","b"),
                new Music("a","c"),
                new Music("b","d"));

        /**
         * 모든 클래스에 Comparable이 정의되어있어야함. - compareTo
         */
        Collections.sort(musics);
        musics.sort(Music::compareTo);
       // System.out.println(musics);
        Collections.sort(musics,Comparator.reverseOrder());

        /// Collections.sort(List list Comparator c) 인자로 전달된 리스트 내의 요소들을 Comparator 클래스의 compare 메서드 기준으로 정렬
        Collections.sort(musics,new AscendingTitle());
        System.out.println(musics);


        //list객체.sort(Comparator c)
        musics.sort(new DescendingTitle());

        musics.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

    }
}
