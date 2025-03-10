package section05.userexception;

public class IncorrectGradeException extends Exception {
    /**
     * 사용자 정의 예외클래스
     * 1. Exception, RuntimeException을 상속받아 구현
     * -Exception : 예외 처리 강제화 => Checked
     * -RuntimeException : 강제 아님 => Unchecked
     *
     */

    /// 기본생성자 :  예외메시지가 null
    public IncorrectGradeException() {
    }


    /// 매개변수로 매시지를 받아 부모로 전달
    public IncorrectGradeException(String message) {
        super(message);
    }


}
