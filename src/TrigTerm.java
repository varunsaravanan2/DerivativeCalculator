public class TrigTerm extends LinearTerm {
    private int x;
    private TrigType type;
    public TrigTerm(int value, TrigType ty)
    {
        super(value);
        x = value;
        type = ty;
    }
    public ITerm derivative() 
    {
        TrigTerm trig;
        if(type == TrigType.COSINE)
        {
            trig = new TrigTerm(-1*x, TrigType.SINE);
            type = TrigType.SINE;
            x = -1*x;
        }
        else
        {
            trig = new TrigTerm(x, TrigType.COSINE);
            type = TrigType.COSINE;
        }
        return trig;
    }
    public double evaluate(double y) 
    {
        double d;
        y = y * Math.PI / 180;
        if(type == TrigType.COSINE)
        {
            d = Math.cos(y) * x;
        }
        else
        {
            d = Math.sin(y) * x;
        }
        return d;
    }
    public String toString() 
    {
        String s;
        if(type == TrigType.COSINE)
        {
            if(x > 0)
                s = "+ " + x + "cos(x)";  
            else
                s = "- " + Math.abs(x) + "cos(x)";  

        }
        else
        {
           if(x >0)
            s = "+ " +  x + "sin(x)";  
           else
                s =  "- " + Math.abs(x) + "sin(x)";  
        }
        return s;
    }
}
