class Numero {
    private double valor;


    // Constructor que inicializa el valor
    public Numero(double valor) {
        setValor(valor);
    }


    // Método para obtener el valor
    public double getValor() {
        return valor;
    }


    // Método para establecer el valor, lanza IllegalArgumentException si el valor es negativo
    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo: " + valor);
        }
        this.valor = valor;
    }
}


public class GestionNumeros {
    public static void main(String[] args) {
        try {
            // Crear un objeto Numero con un valor positivo
            Numero numero = new Numero(10.5);
            System.out.println("Valor inicial: " + numero.getValor());


            // Intentar establecer un valor negativo
            numero.setValor(-5.3);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}






