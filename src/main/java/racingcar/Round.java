package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Round {

    ArrayList<Car> carList; // 자동차 이름 List
    int tryCount; //  시도 횟수

    public void input(){
        this.carList = Input.addCars();
        this.tryCount = Input.numOfStage();
    }

    public void run(){
        String[] result = new String[carList.size()];
        System.out.println("\n실행결과");

        for(int i = 0; i < tryCount; i++){
            for(int j = 0; j < carList.size(); j++){
                Car c = new Car(carList.get(j).getName());

                // c.move(); 난수를 받은 후 4이상일 경우 position++
                result[j] += moveState(c.move());

                // 진행 상황 출력
                System.out.println(carList.get(j).getName() + " : " + result[j].substring(4)); // 왜인지 앞에 "null"(String)이 들어감

            }
            System.out.println();
        }

        // 우승자 출력
        winner(result);
    }

    // 전진 상태
    public String moveState(int position){
        String str = "";

        if(position == 1){
            str = "-";
        }

        return str;
    }

    // 전진을 가장 많이 한 자동차 구하기
    public void winner(String[] result){
        String winner = "";
        int max = 0;

        for(int i = 0; i < result.length; i++){
            if(max < result[i].length()){
                max = result[i].length();
                winner = carList.get(i).getName();
            }

            if(max == result[i].length()){
                if(!winner.equals(carList.get(i).getName())){
                    winner = winner + ", " + carList.get(i).getName();
                }
            }
        }

        System.out.println("최종 우승자 : " + winner);

    }

}
