package s4;

public class CuentaBancaria 
{
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) 
    {
        if (saldo < 0) 
        {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo :C");
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
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (monto > saldo) 
        {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro");
        }
        saldo -= monto;
    }

    public static void main(String[] args) 
    {
        try 
        {
            CuentaBancaria cuenta1 = new CuentaBancaria("12345", "Juan Pérez", 1000.0);
            System.out.println("Cuenta 1 creada con saldo: " + cuenta1.getSaldo());

            cuenta1.depositar(500.0);
            System.out.println("Saldo después del depósito: " + cuenta1.getSaldo());

            cuenta1.retirar(300.0);
            System.out.println("Saldo después del retiro: " + cuenta1.getSaldo());


            try 
            {
                cuenta1.retirar(1500.0);
            } 
            catch (SaldoInsuficienteException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

            try
            {
                cuenta1.depositar(-100.0);
            } catch (IllegalArgumentException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

            try 
            {
                CuentaBancaria cuenta2 = new CuentaBancaria("67890", "Ana Garcia", -200.0);
            } catch (IllegalArgumentException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (Exception e) 
        {
            System.out.println("Se produjo un error inesperado: " + e.getMessage());
        }
    }
}

public class SaldoInsuficienteException extends Exception 
{
    public SaldoInsuficienteException(String mensaje) 
    {
        super(mensaje);
    }
}



