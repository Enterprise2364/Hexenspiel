package trinat.hexenspiel.hexenspiel;

public class Usefull {
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
        return Min+=Math.random()*(Max-Min);
    }
}
