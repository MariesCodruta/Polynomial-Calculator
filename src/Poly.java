import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poly {
    private ArrayList<Mono> poly;

    public Poly() {
        this.poly = new ArrayList<Mono>();
    }

    public Poly(String inp) {
        this.poly = parseString(inp);
    }

    public ArrayList<Mono> getPoly() {
        return poly;
    }

    public void setPoly(ArrayList<Mono> poly) {
        this.poly = poly;
    }


    public void add(Mono mono) {
        poly.add(mono);
    }


    public static ArrayList<Mono> parseString(String inp) {

        ArrayList<Mono> s = new ArrayList<Mono>();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(inp);
        String p;
        while (matcher.find()) {
            Mono aux = new Mono(0, 0);
            p = matcher.group(1);


            int coefficient = 0;
            int grade = 0;

            if (p.indexOf('x') == -1) {
                coefficient = Integer.parseInt(p);
                grade = 0;

            }

            else {
                coefficient = Integer.parseInt(p.substring(0, p.indexOf('x')));
                grade = Integer.parseInt(p.substring(p.indexOf('^') + 1,p.length()));
            }

            aux.setCoefficient(coefficient);
            aux.setGrade(grade);
            s.add(aux);
        }
        return s;

    }


    public String toString ()
    {
        String out = "";

        while (getPoly().size() != 0) {


            int coefficient = getPoly().get(0).getCoefficient();
            int grade = getPoly().get(0).getGrade();

            if(coefficient > 0 && coefficient != 1){

                if (grade == 0)
                    out += "+" + coefficient;
                else if(grade == 1)
                    out += "+" + coefficient + "x";
                else
                    out += "+"+ coefficient + "x^" + grade;

            } else if (coefficient == 1) {
                if (grade == 0)
                    out += "+" + coefficient;
                else if (grade == 1)
                    out += "+" + "x";
                else
                    out += "+" + "x^" + grade;
            } else {
                if (grade == 0)

                    out += coefficient;

                else if (grade == 1)

                    out += coefficient + "x";

                else

                    out += coefficient + "x^" + grade;
            }
            getPoly().remove(0);
        }
        return out;
    }


}



