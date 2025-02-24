package section01.generic;

/**
 * 제네릭
 * 1. 클래스 내부에 사용할 타입을 클래스 외부에서 지정하는 기법
 * 2. 클래스 선언부에 <>에 표시해줘야함
 *   T : Type
 *   K : Key
 *   V : Value
 *   E : Element
 * 단, 타입 지정시 레퍼런스 타입만 가능 - Primitive Type
 * @param <T>
 */
public class Container<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Container{" +
                "item=" + item +
                '}';
    }

}
