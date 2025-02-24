package section02.list.run;

import section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        /**
         * 주로 List에는 DTO객체가 담긴다.
         */

        List<Music> musics = new ArrayList<>();
        musics.add(new Music("fw", "fwe"));
        musics.add(new Music("fewfwefw", "fwwesfe"));
        musics.add(new Music("fawefawefwfaewfefw", "fwawefaewfewfawefefe"));

        musics.add(1, new Music("nft", "fd"));
        musics.remove(musics.size() - 1);


        Music music = musics.get(0);
        System.out.println(music);

        for (Music m : musics) {
            System.out.println(m);
        }

        /// subList(int startIndex, int endIndex) : 해당 인덱스 범위까지의 새로운 인덱스로 반환
        List<Music> subMusics = musics.subList(0, 1); //0번 이상, 1번 미만 = 1개 담김
        System.out.println(subMusics);

        /// addAll(Collection c) : list,set 계열 등 컬렉션 하위 자료형을 추가시켜줌
        musics.addAll(subMusics);

        musics.clear();
        System.out.println(musics.isEmpty()); //t


        List nonTypeList = Arrays.asList(new Music("nft", "fd"),
                new Music("Sdf", "af"));
        Music nonType = (Music) nonTypeList.get(0);

    }
}
