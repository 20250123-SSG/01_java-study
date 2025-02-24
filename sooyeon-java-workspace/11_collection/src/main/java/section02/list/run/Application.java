package section02.list.run;

import java.util.HashSet;
import java.util.Set;

public class Application {
    /**
     * ## 컬렉션
     * 1. 방대한 데이터를 효과적으로 처리할 수 있도록 표준화된 방법을 제공하는 클래스의 집합
     * 2. 데이터를 효율적으로 저장하는 자료구조와 데이터를 효율적으로 처리하는 알고리즘이 미리 구현
     *
     * ## 배열 vs 컬렉션
     * - 배열
     *      1. 크기 제약 많음 (크기 지정, 변경 불가)
     *      2. 중간 위치에 추가 삭제 복잡함 (알고리즘 직접 구현)
     *      3. 한 타입의 데이터만 저장 가능
     * - 컬렉션
     *      1. 크기에 대한 제약이 없음 - 유동적으로 크기 변경
     *      2. 중간 위치에 데이터 추가 및 삭제 쉬움
     *      3. 여러 타입의 데이터 저장 가능 - 제네릭/ 타입을 지정하고 사용하는 게 좋음
     *
     * ## 컬렉션 인터페이스
     *       - List와 Set 인터페이스는 Collection인터페이스를 상속받고 있다. - Map은 다름
     *
     * 1. List
     *      - 순서가 있음
     *      - 중복 저장 허용
     *      - 하위 클래스 : Vector, ArrayList, LinkedList, Stack ...
     *
     * 2. Set
     *      - 순서가 없음
     *      - 중복을 허용하지 않음 *********
     *      - 하위 클래스 : HashSet, TreeSet ...
     *
     * 3. Map
     *      - Key-Value가 한 쌍으로 이루어짐
     *      - key : set 방식으로 관리 - 순서x,중복x
     *      - value : 중복허용
     *      - 하위 클래스 : HashMap, TreeMap, HashTable, Properties
     */

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

    }
}
