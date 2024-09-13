package s4;

public class LimiteCreditoExcedidoException extends Exception 
{
    public LimiteCreditoExcedidoException(String mensaje) 
    {
        super(mensaje);
    }
}

public class CuentaCredito extends CuentaBancaria 
{
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldo, double limiteCredito) {
        super(numeroCuenta, titular, saldo);
        if (limiteCredito < 0) 
        {
            throw new IllegalArgumentException("El límite de crédito no puede ser negativo.");
        }
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() 
    {
        return limiteCredito;
    }

 
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException 
    {
        double saldoDisponible = getSaldo() + limiteCredito;
        if (monto <= 0) 
        {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (monto > saldoDisponible) 
        {
            throw new LimiteCreditoExcedidoException("El monto a retirar excede el limite de crédito disponible");
        }
        super.retirar(monto);
    }

    
    @Override
    public void transferir(CuentaBancaria cuentaDestino, double monto) 
            throws SaldoInsuficienteException, CuentaNoEncontradaException, LimiteCreditoExcedidoException {
        if (cuentaDestino == null) 
        {
            throw new CuentaNoEncontradaException("La cuenta destino no existe.");
        }

        double saldoDisponible = getSaldo() + limiteCredito;
        if (monto <= 0) 
        {
            throw new IllegalArgumentException("El monto a transferir debe ser positivo.");
        }
        if (monto > saldoDisponible) 
        {
            throw new LimiteCreditoExcedidoException("El monto a transferir excede el límite de crédito disponible.");
        }

        retirar(monto);
        cuentaDestino.depositar(monto);
    }
}

public class PruebasCuentaCredito 
{
    public static void main(String[] args) 
    {
        try {

            CuentaCredito cuenta1 = new CuentaCredito("12345", "Fernando Pacheco", 1000.0, 500.0);
            CuentaCredito cuenta2 = new CuentaCredito("67890", "Leonardo Diaz", 500.0, 200.0);

            System.out.println("Cuenta 1 creada con saldo: " + cuenta1.getSaldo() + " y límite de crédito: " + cuenta1.getLimiteCredito());
            System.out.println("Cuenta 2 creada con saldo: " + cuenta2.getSaldo() + " y límite de crédito: " + cuenta2.getLimiteCredito());


            cuenta1.retirar(1200.0); 
            System.out.println("Saldo después del retiro en cuenta 1: " + cuenta1.getSaldo());

           
            cuenta1.transferir(cuenta2, 600.0);
            System.out.println("Saldo después de la transferencia en cuenta 1: " + cuenta1.getSaldo());
            System.out.println("Saldo después de la transferencia en cuenta 2: " + cuenta2.getSaldo());


            try {
                cuenta1.retirar(500.0); 
                cuenta1.retirar(1301.0); 
            } catch (LimiteCreditoExcedidoException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

           
            try 
            {
                cuenta1.transferir(cuenta2, 1500.0); 
            } catch (LimiteCreditoExcedidoException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (Exception e) 
        {
            System.out.println("Se produjo un error inesperado: " + e.getMessage());
        }
    }
}

public class CuentaCredito extends CuentaBancaria 
{
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldo, double limiteCredito) {
        super(numeroCuenta, titular, saldo);
        if (limiteCredito < 0) 
        {
            throw new IllegalArgumentException("El límite de crédito no puede ser negativo");
        }
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteCredito() 
    {
        return limiteCredito;
    }

    
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException 
    {
        double saldoDisponible = getSaldo() + limiteCredito;
        if (monto <= 0) 
        {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (monto > saldoDisponible) 
        {
            throw new LimiteCreditoExcedidoException("El monto a retirar excede el limite de credito disponible");
        }
        super.retirar(monto);
    }

   
    @Override
    public void transferir(CuentaBancaria cuentaDestino, double monto) 
            throws SaldoInsuficienteException, CuentaNoEncontradaException, LimiteCreditoExcedidoException {
        if (cuentaDestino == null) 
        {
            throw new CuentaNoEncontradaException("La cuenta destino no existe");
        }

        double saldoDisponible = getSaldo() + limiteCredito;
        if (monto <= 0) 
        {
            throw new IllegalArgumentException("El monto a transferir debe ser positivo");
        }
        if (monto > saldoDisponible) 
        {
            throw new LimiteCreditoExcedidoException("El monto a transferir excede el limite de crédito disponible");
        }

        retirar(monto);
        cuentaDestino.depositar(monto);
    }

    public static void main(String[] args) 
    {
        try 
        {

            CuentaCredito cuenta1 = new CuentaCredito("12345", "Fernando Pacheco", 1000.0, 500.0);
            CuentaCredito cuenta2 = new CuentaCredito("67890", "Leonardo Diaz", 500.0, 200.0);

            System.out.println("Cuenta 1 creada con saldo: " + cuenta1.getSaldo() + " y límite de crédito: " + cuenta1.getLimiteCredito());
            System.out.println("Cuenta 2 creada con saldo: " + cuenta2.getSaldo() + " y límite de crédito: " + cuenta2.getLimiteCredito());


            cuenta1.retirar(1200.0); 
            System.out.println("Saldo después del retiro en cuenta 1: " + cuenta1.getSaldo());
            cuenta1.transferir(cuenta2, 600.0); 
            System.out.println("Saldo después de la transferencia en cuenta 1: " + cuenta1.getSaldo());
            System.out.println("Saldo después de la transferencia en cuenta 2: " + cuenta2.getSaldo());


            try 
            {
                cuenta1.retirar(500.0); 
                cuenta1.retirar(1301.0); 
            } catch (LimiteCreditoExcedidoException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

       
            try 
            {
                cuenta1.transferir(cuenta2, 1500.0); 
            } catch (LimiteCreditoExcedidoException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (Exception e) 
        {
            System.out.println("Se produjo un error inesperado " + e.getMessage());
        }
    }
}
