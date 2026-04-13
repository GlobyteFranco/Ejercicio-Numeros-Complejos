import java.util.Scanner;

public class CalculadoraComplejos {
    NumeroComplejo valorA;
    NumeroComplejo valorB;
    int valorElegido;
    Scanner sc = new Scanner(System.in);

    // public CalculadoraComplejos() {
    // }

    public int menu() {
        System.out.println(
                "Por favor elegir una opcion \n\n 1 --> Sumar \n\n 2 --> Restar \n\n 3 --> Multiplicar \n\n 4 --> Dividir \n\n 5 --> Ingresar valores \n\n 6 --> Ingresar el primer valor \n\n 7 --> Ingresar el segundo valor \n\n 0 --> Salir");

        valorElegido = sc.nextInt();
        return valorElegido;

    }

    public void revisarValores() {
        if (valorA == null || valorB == null) {
            throw new IllegalArgumentException("Uno de los valores es nulo. \n Por favor definirlo");
        }
    }
}
