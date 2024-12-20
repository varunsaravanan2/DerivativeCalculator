import java.util.*;
public class Expression {
    private ProjLinkedList<ITerm> list;
    public Expression()
    {
        list = new ProjLinkedList<>();
    }
    public Expression getDerivative()
    {
        Expression ex = new Expression();
        int i =0;
        while(list.getAt(i) != null)
        {
            ex.add(list.getAt(i).derivative());
            i++;
        }
        return ex;  
    }
    public void add(ITerm term)
    {
        list.add(term);
    }
    public double getEvaluation(double d)
    {
        double result = 0;
        int i = 0;
        while(list.getAt(i) != null)
        {
            result = result + list.getAt(i).evaluate(d);
            i++;
        }
        return result;
    }
    public String toString()
    {
            // We will categorize and sort terms in the desired order:
            ArrayList<PolynomialTerm> polynomials = new ArrayList<>();
            ArrayList<LinearTerm> linearTerms = new ArrayList<>();
            ArrayList<ConstantTerm> constantTerms = new ArrayList<>();
            ArrayList<TrigTerm> trigTerms = new ArrayList<>();
    
            // Categorize terms into their respective lists
            int i = 0;
            ITerm term;
            while ((term = list.getAt(i)) != null) {
                if (term instanceof PolynomialTerm) {
                    polynomials.add((PolynomialTerm) term);
                } else if (term instanceof LinearTerm && !(term instanceof PolynomialTerm)) {
                    linearTerms.add((LinearTerm) term);
                } else if (term instanceof ConstantTerm) {
                    constantTerms.add((ConstantTerm) term);
                } else if (term instanceof TrigTerm) {
                    TrigTerm trigTerm = (TrigTerm) term;
                    if (trigTerm.type == TrigType.SINE) {
                        sineTerms.add(trigTerm);
                    } else {
                        cosineTerms.add(trigTerm);
                    }
                }
                i++;
            }
    
            // Sort polynomials by descending exponents
            Collections.sort(polynomials, new Comparator<PolynomialTerm>() {
                @Override
                public int compare(PolynomialTerm o1, PolynomialTerm o2) {
                    return Integer.compare(o2.getExponent(), o1.getExponent()); // descending order
                }
            });
    
            // Now construct the final string based on sorted terms
            StringBuilder result = new StringBuilder();
    
            // Append polynomials
            for (PolynomialTerm poly : polynomials) {
                result.append(poly.toString()).append(" ");
            }
    
            // Append linear terms
            for (LinearTerm lin : linearTerms) {
                result.append(lin.toString()).append(" ");
            }
    
            // Append constants
            for (ConstantTerm con : constantTerms) {
                result.append(con.toString()).append(" ");
            }
    
            // Append sine terms
            for (TrigTerm sine : sineTerms) {
                result.append(sine.toString()).append(" ");
            }
    
            // Append cosine terms
            for (TrigTerm cosine : cosineTerms) {
                result.append(cosine.toString()).append(" ");
            }
    
            return result.toString().trim(); // remove trailing space
        }

}
