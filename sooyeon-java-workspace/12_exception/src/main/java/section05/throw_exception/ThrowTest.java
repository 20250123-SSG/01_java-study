package section05.throw_exception;

import section05.userexception.IncorrectAgeException;
import section05.userexception.IncorrectGradeException;
import section05.userexception.IncorrectScoreException;

public class ThrowTest {
    /**
     * 자바에서는 예외 X, but 프로그램상에서는 예외처리하고싶다면
     * 직접 throw로 예외 발생
     */
    public void checkScore(int score) {
        if (score < 0 || score > 100) {
            throw new IncorrectScoreException(score + "점은 잘못된 점수입니다.");
        }
        System.out.println(score + "땀");
    }

    public void checkAge(int age) {
        if (age < 0 || age > 120) {
//            throw new RuntimeException(age + "는 잘못된 나이입니다.");
            throw new IncorrectAgeException(age+"살은잘못됐어요");
        }
        System.out.println(age + "살");
    }


    public void checkGrade(char grade) throws Exception {
       if(!(grade>='A' && grade<='D')) {
           throw new IncorrectGradeException(grade + "는 잘못된 등급입니다");
       }
        System.out.println(grade+"등급");
    }
}
