package section01.generic;

public class Application {
    public static void main(String[] args) {
        Container<String> stringContainer = new Container<>();
        stringContainer.setItem("ewwwwwwwwwwwwwwwwwwwwwww");

       // Container<int> intContainer  = new Container<int>(); ///기본 자료형은 불가함
        Container<Integer> intContainer  = new Container<>(); ///기본 자료형은 불가함
        intContainer.setItem(1); //AutoBoxing (int -> Integer)

        Container<String[]> stringArrayContainer = new Container<>();
        stringArrayContainer.setItem(new String[]{"ewwwwwwwwwwwwwwwwwww","fffffffffffffffff"});

        /**
         * 타입을 지정하지 않을시 Object타입으로 설정된다.
         * 이는 raw타입을 설정한거라 추천하지 않는 방식. 명확히 지정해주는 것이 좋다.
         */
        Container wholeContainer = new Container(); ///
        wholeContainer.setItem("그냥추가");
        wholeContainer.setItem(2);

    }
}
