public class Mono {
    private int coefficient;
    private int grade;


    public Mono(int coefficient, int grade) {
        this.coefficient = coefficient;
        this.grade = grade;
    }


    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }




    public Mono d(Mono monomial)

    {
        Mono result = new Mono(this.coefficient/monomial.getCoefficient(),this.grade- monomial.getGrade());
        return result;
    }
}
