package trinat.hexenspiel.hexenspiel;

public class Usfull {
    public static void Wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public static double Random(double Max,double Min){
        double random=Math.random()*(Max-Min);
        return random;
    }
}
