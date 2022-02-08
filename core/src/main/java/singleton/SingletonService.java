package singleton;

public class SingletonService {

    //java static 영역 공부하기
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //다른 클래스에서 사용못하게 하기위해 private 선언
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
