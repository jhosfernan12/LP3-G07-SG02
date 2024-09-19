class VocalException extends Exception {
    public VocalException(String message) {
        super(message);
    }
}


class NumeroException extends Exception {
    public NumeroException(String message) {
        super(message);
    }
}


class BlancoException extends Exception {
    public BlancoException(String message) {
        super(message);
    }
}


class SalidaException extends Exception {
    public SalidaException(String message) {
        super(message);
    }
}


public class ExcepcionesDemo {
    public static void verificarCaracter(char c) throws VocalException, NumeroException, BlancoException, SalidaException {
        if (Character.isDigit(c)) {
            throw new NumeroException("Se encontró un número: " + c);
        } else if (Character.isWhitespace(c)) {
            throw new BlancoException("Se encontró un espacio en blanco.");
        } else if (c == 'q' || c == 'Q') {
            throw new SalidaException("Se encontró un carácter de salida: " + c);
        } else if ("AEIOUaeiou".indexOf(c) != -1) {
            throw new VocalException("Se encontró una vocal: " + c);
        }
    }


    public static void main(String[] args) {
        char[] caracteres = {'a', '1', ' ', 'q', 'b'};
       
        for (char c : caracteres) {
            try {
                verificarCaracter(c);
            } catch (VocalException | NumeroException | BlancoException | SalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


