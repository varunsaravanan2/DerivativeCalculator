public class LinearTerm extends ConstantTerm {
    private int x;
    public LinearTerm(int value)
    {
        super(value);
        x = value;
    }
    @Override
    public ITerm derivative() 
    {
        return new ConstantTerm(x);
    }
    @Override
    public double evaluate(double v) 
    {
        return x * v;
    }
    @Override
    public String toString() 
    {
       if(x>0)
        return "+ " + String.valueOf(x) + "x";
       else
        return "- " + String.valueOf(Math.abs(x)) + "x";
    }
    
}
