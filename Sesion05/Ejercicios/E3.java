
public class Main {
   
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par.toString());
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Texto", 123);
        Par<Double, Boolean> par2 = new Par<>(99.99, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Juan"), 25);
      
        imprimirPar(par1);  // Imprime: (Primero: Texto, Segundo: 123)
        imprimirPar(par2);  // Imprime: (Primero: 99.99, Segundo: true)
        imprimirPar(par3);  // Imprime: (Primero: Persona: Juan, Segundo: 25)
    }
}
