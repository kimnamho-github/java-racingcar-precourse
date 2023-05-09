package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

//    public Car(String name, int position){
//        this.name= name;
//        this.position= position;
//    }

    public String getName() {
        return name;
    }

//    public int getPosition(){
//        return position;
//    }

    public int move(){
        int random = Randoms.pickNumberInRange(0,9);

        if(random >= 4){
            position++;
        }

        return position;
    }

}