package section02.list.comparator;

import section02.list.dto.Music;

import java.util.Comparator;
import java.util.Map;

public class AscendingTitle implements Comparator<Music> {
    /**
     * Music객체 외부에서 비교하는 클래스이기 때문에 getter를 사용해야한다.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Music o1, Music o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
