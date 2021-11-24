package trinat.hexenspiel.hexenspiel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNumberGeneratorTest {
    private double max;
    private double min;

    @BeforeEach
    public void setUp(){
        min=0;
        max=400;
    }

    @Test
    public void testLimit(){

        assertEquals(min, RandomNumberGenerator.random(min,max),max);

    }
}
