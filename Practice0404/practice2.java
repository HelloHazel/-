package Practice0404;
import java.util.*;
public class practice2 {
    public static void main(String[] args) {
        // 영숫자 단어 저장용 변수 선언 및 ArrayList 객체 생성
        ArrayList<String> number = new ArrayList<String>();
        // 영숫자 단어 저장
        number.add( "zero" );
        number.add( "one" );
        number.add( "two" );
        number.add( "three" );
        number.add( "four" );
        number.add( "five" );
        number.add( "six" );
        number.add( "seven" );
        number.add( "eight" );
        number.add( "nine" );
        number.add( "ten" );
        // 영어 단어 입력
        System.out.println ( "0에서 10까지의 영문 단어를 입력하십시오" );
        String input = System.console().readLine();



        boolean flag = false;//발견시 결정하는 플래그 변수
        for(int i=0; i <number.size(); i++){
            //문자열 등가 확인
            if(number.get(i).equals(input)){
                System.out.println(input + "는 숫자의 " + i + "입니다.");
                flag = true;
                break;
            }
        }
        //입력한 영어가 잘못된 경우
        if(!flag){
            System.out.println(input + "는 영어단어가 아닙니다.");
        }

        for(int i =0; i < number.size(); i++){
            System.out.println(input + "는 숫자의 " + i + "입니다.");
            return;
        }
    }



}
