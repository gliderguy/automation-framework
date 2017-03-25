import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Created by Test on 3/25/2017.
 */
public class RandomLongFloatIntegerDoubleTest {

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomLongUnbounded_thenCorrect() {
    long generatedLong = new Random().nextLong();
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomLongBounded_thenCorrect() {
    long leftLimit = 1L;
    long rightLimit = 10L;
    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    @Test
    public void givenUsingApacheCommons_whenGeneratingRandomLongBounded_thenCorrect() {
    long leftLimit = 10L;
    long rightLimit = 100L;
    long generatedLong = new RandomDataGenerator().nextLong(leftLimit, rightLimit);
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomIntegerUnbounded_thenCorrect() {
    int generatedInteger = new Random().nextInt();
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomIntegerBounded_thenCorrect() {
    int leftLimit = 1;
    int rightLimit = 10;
    int generatedInteger = leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomFloatUnbouned_thenCorrect() {
    float generatedFloat = new Random().nextFloat();
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomFloatBouned_thenCorrect() {
    float leftLimit = 1F;
    float rightLimit = 10F;
    float generatedFloat = leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
    }

    @Test
    public void givenUsingApache_whenGeneratingRandomFloatBounded_thenCorrect() {
        float leftLimit = 1F;
        float rightLimit = 10F;
        float randomFloat = new RandomDataGenerator().getRandomGenerator().nextFloat();
        float generatedFloat = leftLimit + randomFloat * (rightLimit - leftLimit);
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomDoubleUnbounded_thenCorrect() {
    double generatedDouble = Math.random();
    }

    @Test
    public void givenUsingApache_whenGeneratingRandomDoubleUnbounded_thenCorrect() {
        double generatedDouble = new RandomDataGenerator().getRandomGenerator().nextDouble();
    }

    @Test
    public void givenUsingPlainJava_whenGeneratingRandomDoubleBounded_thenCorrect() {
    double leftLimit = 1D;
    double rightLimit = 10D;
    double generatedDouble = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
    }

    @Test
    public void givenUsingApache_whenGeneratingRandomDoubleBounded_thenCorrect() {
        double leftLimit = 1D;
        double rightLimit = 100D;
        double generatedDouble = new RandomDataGenerator().nextUniform(leftLimit, rightLimit);
    }

}