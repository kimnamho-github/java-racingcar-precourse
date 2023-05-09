package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Input {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public static int numOfStage(){

        int tryCount;

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            tryCount = Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            new IllegalArgumentException("[Error] 입력 오류\n 숫자를 입력해주세요.");
            return numOfStage();
        }

        return tryCount;
    }

    public static ArrayList<Car> addCars() throws IllegalArgumentException{

        ArrayList<Car> carList;

        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carName = Console.readLine();
            String[] carArr = carName.split(",");

            carList = new ArrayList<>(carArr.length);

            for (String name : carArr){
                CarNameLimit(name);
                Car c = new Car(name,0);

                carList.add(c);
            }

        }catch (IllegalArgumentException e){
            new IllegalArgumentException("[Error] 입력 오류");
            return addCars();
        }

        return carList;
    }

    public static void CarNameLimit(String name) throws IllegalArgumentException {
        if(name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR]자동차 이름 글자제한 오류\n 1~5자 이하로 입력해주세요.");
        }
    }



}
