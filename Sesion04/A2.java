package S4;
public class CuentaBancaria 
{
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) 
    {
        if (saldo < 0) 
        {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo :(");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() 
    {
        return numeroCuenta;
    }

    public String getTitular() 
    {
        return titular;
    }

    public double getSaldo() 
    {
        return saldo;
    }

    public void depositar(double monto) 
    {
        if (monto <= 0) 
        {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException 
    {
        if (monto <= 0) 
        {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        }
        if (monto > saldo) 
        {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
        }
        saldo -= monto;
    }


    public void transferir(CuentaBancaria cuentaDestino, double monto) 
            throws SaldoInsuficienteException, CuentaNoEncontradaException 
            {
        if (cuentaDestino == null) 
        {
            throw new CuentaNoEncontradaException("La cuenta destino no existe");
        }

        retirar(monto);
        cuentaDestino.depositar(monto);
    }

    public void cerrarCuenta() throws SaldoNoCeroException 
    {
        if (saldo > 0) 
        {
            throw new SaldoNoCeroException("No se puede cerrar la cuenta con saldo positivo");
        }
        
    }

    public static void main(String[] args) 
    {
        try 
        {
 
            CuentaBancaria cuenta1 = new CuentaBancaria("12345", "Juan Pérez", 1000.0);
            CuentaBancaria cuenta2 = new CuentaBancaria("67890", "Ana García", 500.0);

            System.out.println("Cuenta 1 creada con saldo: " + cuenta1.getSaldo());
            System.out.println("Cuenta 2 creada con saldo: " + cuenta2.getSaldo());

            cuenta1.transferir(cuenta2, 200.0);
            System.out.println("Saldo después de la transferencia en cuenta 1: " + cuenta1.getSaldo());
            System.out.println("Saldo después de la transferencia en cuenta 2: " + cuenta2.getSaldo());

            try {
                cuenta1.transferir(null, 50.0);
            } catch (CuentaNoEncontradaException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

            try 
            {
                cuenta1.transferir(cuenta2, 2000.0);
            } catch (SaldoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }

 
            try {
                cuenta1.cerrarCuenta();
            } catch (SaldoNoCeroException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

            cuenta1.depositar(-1000.0); 
            cuenta1.cerrarCuenta();
            System.out.println("Cuenta 1 cerrada exitosamente.");

        } catch (Exception e) 
        {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
