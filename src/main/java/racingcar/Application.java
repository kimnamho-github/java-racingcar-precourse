package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        String[] name = carName.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println("\n실행결과");


        String[] str = new String[name.length];
        String result = "";
        int max = 0;

        for(int i = 0; i < tryCount; i++){
            for(int j = 0; j < name.length; j++){
                if(name[j].length() > 5){
                    System.out.println("자동차 이름은 5자 이하만 가능합니다.");
                    break;
                }

                Car c = new Car(name[j]);
                c.move();

                for(int k = 0 ; k < c.getPosition(); k++){
                    str[j] = str[j] + "-";
                }

                try {
                    System.out.println(name[j] + " : " + str[j].substring(4));
                }catch (Exception e){
                    System.out.println(name[j] + " : ");
                }

            }
            System.out.println();

        }

        for(int k = 0; k < name.length; k++){
            if(max < str[k].length()){
                max = str[k].length();
                result = name[k];
            }

            if(max == str[k].length()){
                if(!Objects.equals(result, name[k])){
                    max = str[k].length();
                    result = result + ", " + name[k];
                    System.out.println("result2 : " + result);
                }
            }
        }

        System.out.println("최종 우승자 : " + result);

    }
}
