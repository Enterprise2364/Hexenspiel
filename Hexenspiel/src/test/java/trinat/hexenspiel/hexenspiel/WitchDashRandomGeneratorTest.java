package trinat.hexenspiel.hexenspiel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WitchDashRandomGeneratorTest {
    private double max;
    private double min;

    @BeforeEach
    public void setUp(){
        min=0;
        max=400;
    }

    @Test
    public void testLimit(){

        assertEquals(min,WitchDashRandomGenerator.random(min,max),max);

    }
}
