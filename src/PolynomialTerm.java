public class PolynomialTerm extends LinearTerm{
    private int x;
    private int y;
    public PolynomialTerm(int valueX, int valueY)
    {
        super(valueX);
        x = valueX;
        y = valueY;
    }
    public ITerm derivative() 
    {
        ITerm deriv;
        if(y > 2)
        {
           deriv = new PolynomialTerm(x * y,y -1);
           x = x*y;
           y-=1;
        }
        else
        {
           deriv = new LinearTerm(x * 2);
           y-=1;
        }
        return deriv;
    }
    public double evaluate(double v) 
    {
        if(y <= 1)
        {
            return x * v;
        }
        else
        {
          return Math.pow(v,y) * x;
        }
    }
    public String toString() 
    {
        String s;
        if(y == 1)
        {
            s = super.toString();
        }
        else
        {
          if(x>0)
            s = "+ " + x + "x^" + y;
           else
             s =  x + "x^" + y;
        }
        return s;
    }
    public int getExponent()
    {
        return y;
    }
}
