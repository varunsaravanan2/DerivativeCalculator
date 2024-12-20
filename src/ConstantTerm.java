public class ConstantTerm implements ITerm{
    private int x;
    public ConstantTerm(int value) 
    {
        x = value;
    }
    public ITerm derivative() 
    {
        return new ConstantTerm(0);
    }
    public double evaluate(double d) 
    {
        return x;
    }
    public String toString() 
    {
        if(x>0)
            return "+ " + String.valueOf(x);
        else
            return "- " + String.valueOf(Math.abs(x)); 
    }
}