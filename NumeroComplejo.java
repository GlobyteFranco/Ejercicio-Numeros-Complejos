
public class NumeroComplejo {
    private double parteReal;
    private ParteImaginaria parteImaginaria;

    public double getParteReal() {
        return parteReal;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public ParteImaginaria getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(ParteImaginaria parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    public NumeroComplejo(double parteReal, double parteImaginaria) {
        if (parteReal == 0) {
            throw new IllegalArgumentException(
                    "La parte real ingresada es 0, el valor devuelto no sera complejo sino puramente imaginario");
        }
        this.parteReal = parteReal;
        this.parteImaginaria = new ParteImaginaria(parteImaginaria);
    }

    public NumeroComplejo devolverConjugado(NumeroComplejo numeroComplejo) {
        return new NumeroComplejo(numeroComplejo.getParteReal(), numeroComplejo.getParteImaginaria().getValor() * -1);
    }

    public NumeroComplejo sumar(NumeroComplejo parametro) {
        return new NumeroComplejo(this.parteReal + parametro.getParteReal(),
                this.parteImaginaria.getValor() + parametro.getParteImaginaria().getValor());
    }

    public NumeroComplejo restar(NumeroComplejo parametro) {
        return new NumeroComplejo(this.parteReal - parametro.getParteReal(),
                this.parteImaginaria.getValor() - parametro.getParteImaginaria().getValor());
    }

    public NumeroComplejo multiplicar(NumeroComplejo parametro) {

        double parametroParteReal = parametro.getParteReal();
        double parteImaginaria = this.parteImaginaria.getValor();
        double parametroParteImaginaria = parametro.parteImaginaria.getValor();

        return new NumeroComplejo(
                this.parteReal * parametroParteReal - parteImaginaria * parametroParteImaginaria,
                this.parteReal * parametroParteImaginaria + parteImaginaria * parametroParteReal);
    }

    public NumeroComplejo dividir(NumeroComplejo parametro) {
        NumeroComplejo conjugado = devolverConjugado(parametro);
        System.out.println("El parametro es: " + parametro);

        System.out.println("El conjugado es: " + conjugado);
        double denominador = parametro.multiplicar(conjugado).getParteReal();

        ParteImaginaria numeradorParteImaginaria = new ParteImaginaria(
                (this.getParteImaginaria().getValor() * parametro.getParteReal()
                        - this.parteReal * parametro.getParteImaginaria().getValor()));
        // NumeroComplejo numerador = this.multiplicar(conjugado);

        double numeradorParteReal = this.parteReal * parametro.getParteReal()
                + this.parteImaginaria.getValor() * parametro.getParteImaginaria().getValor();

        System.out.println(
                "El numeradorParteReal y denominador equivalen respectivamente a: " + numeradorParteReal + " y "
                        + denominador);
        double parteReal = numeradorParteReal / denominador;

        // numeradorParteImaginaria = parteImaginaria.getValor();

        parteImaginaria = new ParteImaginaria(numeradorParteImaginaria.getValor() / denominador);

        return new NumeroComplejo(parteReal, parteImaginaria.getValor()); // TODO
    }

    @Override
    public String toString() {
        String muestraParteImaginaria = this.getParteImaginaria().getValor() > 0
                ? String.valueOf(this.getParteImaginaria().getValor()) + "i"
                : "- " + String.valueOf(this.getParteImaginaria().getValor() * -1) + "i";

        return String.valueOf(this.getParteReal()) + " " + muestraParteImaginaria;
    }
    // En otro universo hubiesemos hecho un override del Equals...

}