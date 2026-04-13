public class ParteImaginaria {
    public double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ParteImaginaria(double valor) {

        this.valor = valor;
    }

    public void mostrar() {
        // TODO
    }

    public double multiplicarImaginarios(double parametroImaginario) {
        return -(this.valor * parametroImaginario);
    }
}
