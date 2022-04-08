package Practice0404;
import java.util.*;
public class practice4 {
    public static void main(String[] args) {
        // 금고 인스턴스 만들기
        StrongBox guard = new StrongBox();
        // 비밀 단어 변수 선언
        String secret = null ;
        try {
            // 첫 번째 보물 저장
            secret = "sgf01" ;
            guard.store(secret, new Treasure( "다이어링" ));
            // 두 번째 보물을 저장
            secret = "zkq02" ;
            guard.store(secret, new Treasure( "진주 목걸이" ));
            // 세 번째 보물을 저장
            secret = "xrt03" ;
            guard.store(secret, new Treasure( "금 팔찌" ));
            // 네 번째 보물을 저장 (비밀 단어 중복)
            secret = "xrt03" ;
            guard.store (secret, new Treasure ( "백금 귀걸이" ));
        } catch (DuplicateSecretException e) {
            System.out.println( "비밀 단어 " + secret + "는 이미 붙어 있습니다" );
        }
        System.out.println();
        try {
            // 첫 번째 보물 획득
            secret = "sgf01" ;
            Treasure treasure1 = guard.getTreasure(secret);
            System.out.println(treasure1 + "을 받았습니다!" );
            // 두 번째 보물 획득
            secret = "zkq02" ;
            Treasure treasure2 = guard.getTreasure(secret);
            System.out.println(treasure2 + "을 받았습니다!" );
            // 세 번째 보물을 얻는다 (비밀의 말이 부정)
            secret = "xrr03" ;
            Treasure treasure3 = guard.getTreasure(secret);
            System.out.println(treasure3 + "을 받았습니다!" );
        } catch (IllegalSecretException e) {
            System.out.println( "비밀 단어 " + secret + "는 악성" );
        }
    }
}

// 여기에 보물 클래스를 만드세요.
class Treasure{
    public String type;

    public Treasure(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
// 여기에 비밀 단어 부정 예외 클래스를 만듭니다.
class IllegalSecretException extends Exception{}
// 여기에 비밀 단어 중복 예외 클래스를 만듭니다.
class DuplicateSecretException extends Exception{}
// 여기에 금고 클래스를 만듭니다
class StrongBox{
    private HashMap<String, Treasure> treasureHashMap;

    public StrongBox(){
        treasureHashMap =  new HashMap<String , Treasure>();
    }
    public void store(String secret, Treasure treasure) throws DuplicateSecretException{
        if(treasureHashMap.containsKey(secret)){
            throw new DuplicateSecretException();
        }else{
            System.out.println(treasure + "을 금고에 저장했습니다.");
            treasureHashMap.put(secret, treasure);
        }
    }

    public Treasure getTreasure(String secret) throws IllegalSecretException{
        Treasure treasure = treasureHashMap.get(secret);

        if(treasure == null){
            throw new IllegalSecretException();
        }else{
            return treasure;
        }
    }
}