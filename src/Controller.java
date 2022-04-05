import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Model model;
    private View view;


    public Controller(Model model, View view) {

        this.model = model;
        this.view = view;


        this.view.additionListener(new AdditionListener());
        this.view.subtractionListener(new SubtractionListener());
        this.view.divisionListener(new DivisionListener());
        this.view.derivativeListener(new DerivativeListener());
        this.view.multiplicationListener(new MultiplicationListener());

    }


    class AdditionListener implements ActionListener {

        public void actionPerformed(ActionEvent i) {

            Poly poli1 = new Poly();
            Poly poli2 = new Poly();

            try {
                String poli1String = view.firstPoli.getText();
                String poli2String = view.secondPoli.getText();


                poli1.setPoly(poli1.parseString(poli1String));
                poli2.setPoly(poli2.parseString(poli2String));


                Poly poliRezultat = model.addition(poli1, poli2);
                view.resultPoli.setText(poliRezultat.toString());


            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException);
            }
        }
    }



    class SubtractionListener implements ActionListener {

        public void actionPerformed(ActionEvent i) {

            Poly poli1 = new Poly();
            Poly poli2 = new Poly();

            try {
                String poli1String = view.firstPoli.getText();
                String poli2String = view.secondPoli.getText();


                poli1.setPoly(poli1.parseString(poli1String));
                poli2.setPoly(poli2.parseString(poli2String));


                Poly poliRezultat = model.subtraction(poli1, poli2);
                view.resultPoli.setText(poliRezultat.toString());


            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException);
            }
        }

    }


    class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Poly poli1 = new Poly();

            try {
                String pol1String = view.firstPoli.getText();

                poli1.setPoly(poli1.parseString(pol1String));

                Poly poliRezultat = model.derivative(poli1);
                view.resultPoli.setText(poliRezultat.toString());


            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException);
            }

        }
    }

    class MultiplicationListener implements ActionListener {

        public void actionPerformed(ActionEvent i) {
            Poly poli1 = new Poly();
            Poly poli2 = new Poly();

            try {
                String poli1String = view.firstPoli.getText();
                String poli2String = view.secondPoli.getText();


                poli1.setPoly(poli1.parseString(poli1String));
                poli2.setPoly(poli2.parseString(poli2String));


                Poly poliRezultat = model.multiplication(poli1, poli2);
                view.resultPoli.setText(poliRezultat.toString());


            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException);
            }
        }
    }

    class DerivativeListener implements ActionListener {

        public void actionPerformed(ActionEvent i) {

            Poly poli1 = new Poly();

            try {
                String poli1String = view.firstPoli.getText();
                poli1.setPoly(poli1.parseString(poli1String));

                Poly poliRezultat = model.derivative(poli1);
                view.resultPoli.setText(poliRezultat.toString());

            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException);
            }
        }
    }
}
