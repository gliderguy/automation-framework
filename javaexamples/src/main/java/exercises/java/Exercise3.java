package exercises.java;

import java.lang.reflect.Array;

/**
 * Created by Test on 3/28/2017.
 */
public class Exercise3 {
    public static void main(String argv[]){
        int[] numbers = {1,2,3,4,5};
        int sum = 0;

        for (int i = 0;i < numbers.length ;i++){
            sum = sum + numbers[i];
        }
        System.out.println(sum );
    }
}
