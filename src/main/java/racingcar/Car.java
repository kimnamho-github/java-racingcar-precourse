package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

//    public Car(String name, int position){
//        this.name= name;
//        this.position= position;
//    }

//    public String getName() {
//        return name;
//    }

    public int getPosition(){
        return position;
    }
    public void move(){
        int random = Randoms.pickNumberInRange(0,9);

        if(random >= 4){
            position++;
        }

    }

}
