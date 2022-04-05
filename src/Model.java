public class Model {
    Poly rezultat;


    public Model(){
        this.rezultat=new Poly();
    }


    public Poly addition(Poly poli1,Poly poli2){

        Poly pol1= poli1;
        Poly pol2= poli2;

        rezultat = new Poly();

        while (pol1.getPoly().size()!=0 && pol2.getPoly().size()!=0)
        {
            int gradP1=pol1.getPoly().get(0).getGrade();
            int gradP2=pol2.getPoly().get(0).getGrade();


            if (gradP1==gradP2){
                int coef=pol1.getPoly().get(0).getCoefficient()+pol2.getPoly().get(0).getCoefficient();
                pol1.getPoly().remove(0);
                pol2.getPoly().remove(0);
                rezultat.add(new Mono(coef,gradP1));
            }

            else if(gradP1<gradP2){

                rezultat.add(new Mono(pol2.getPoly().get(0).getCoefficient(),pol2.getPoly().get(0).getGrade()));
                pol2.getPoly().remove(0);
            }

            else{

                rezultat.add(new Mono(pol1.getPoly().get(0).getCoefficient(),pol1.getPoly().get(0).getGrade()));
                pol1.getPoly().remove(0);
            }
        }


        while(pol1.getPoly().size()!=0){

            rezultat.add(new Mono(pol1.getPoly().get(0).getCoefficient(),pol1.getPoly().get(0).getGrade()));
            pol1.getPoly().remove(0);
        }


        while(pol2.getPoly().size()!=0){

            rezultat.add(new Mono(pol2.getPoly().get(0).getCoefficient(),pol2.getPoly().get(0).getGrade()));
            pol2.getPoly().remove(0);
        }

        return rezultat;
    }



    public Poly subtraction(Poly poli1,Poly poli2){
        Poly pol1= poli1;
        Poly pol2=poli2;
        rezultat = new Poly();

        while (pol1.getPoly().size()!=0 && pol2.getPoly().size()!=0)
        {
            int gradepol1=pol1.getPoly().get(0).getGrade();
            int gradepol2=pol2.getPoly().get(0).getGrade();

            if(gradepol1==gradepol2)
            {
                int coeficient=pol1.getPoly().get(0).getCoefficient()- pol2.getPoly().get(0).getCoefficient();
                pol1.getPoly().remove(0);
                pol2.getPoly().remove(0);
                if(coeficient != 0)
                    rezultat.add(new Mono(coeficient,gradepol1));
            }

            else if(gradepol1>gradepol2){
                rezultat.add(pol1.getPoly().get(0));
                pol1.getPoly().remove(0);
            }
            else
            {
                rezultat.add(new Mono(-pol2.getPoly().get(0).getCoefficient(),pol2.getPoly().get(0).getGrade()));
                pol2.getPoly().remove(0);
            }
        }

        while(pol1.getPoly().size()!=0)
        {
            rezultat.add(pol1.getPoly().get(0));
            pol1.getPoly().remove(0);
        }


        while(pol2.getPoly().size()!=0)
        {
            rezultat.add(new Mono(-pol2.getPoly().get(0).getCoefficient(),pol2.getPoly().get(0).getGrade()));
            pol2.getPoly().remove(0);
        }

        return  rezultat;
    }


    public Poly derivative(Poly pol)
    {
        for (Mono m:pol.getPoly()) {
            if(m.getGrade()!=0) {
                int coeficient = m.getCoefficient() * m.getGrade();
                int grad = m.getGrade() - 1;
                rezultat.add(new Mono(coeficient, grad));
            }

        }
        return rezultat;
    }

    public Poly division(Poly p1, Poly p2, Poly rest){
        Poly cat =new Poly();

        while(p1.getPoly().size()!=0 && p1.getPoly().get(0).getGrade() >= p2.getPoly().get(0).getGrade() ) {
            Poly monon = new Poly();
            cat.getPoly().add(new Mono(p1.getPoly().get(0).getCoefficient()/p2.getPoly().get(0).getCoefficient(),p1.getPoly().get(0).getGrade()-p2.getPoly().get(0).getGrade()));
            monon.add(cat.getPoly().get(cat.getPoly().size()-1));
            p1 = subtraction(p1,multiplication(monon,p2));
        }
        rest.getPoly().addAll(p1.getPoly());
        return cat;
    }

    public Poly multiplication(Poly poli1,Poly poli2){
        rezultat = new Poly();
        for (Mono m1:poli1.getPoly()) {
            for (Mono m2:poli2.getPoly()) {

                int coeficient=m1.getCoefficient()*m2.getCoefficient();
                int grad=m1.getGrade()+m2.getGrade();
                rezultat.add(new Mono(coeficient,grad));
            }

        }
        return rezultat;
    }

    public Poly integral(Poly pol){
        for(Mono m: pol.getPoly()){
        }
        return null;
    }


}
