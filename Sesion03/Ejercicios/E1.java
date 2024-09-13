package s3;

public class empleado 
{
	 private String nombre;
	    private double salario;
	    private String departamento;

	    public empleado(String nombre, double salario, String departamento) 
            {
	        this.nombre = nombre;
	        this.salario = salario;
	        this.departamento = departamento;
	    }

	    public String getNombre() 
            {
	        return nombre;
	    }

	    public void setNombre(String nombre) 
            {
	        this.nombre = nombre;
	    }

	    public double getSalario() 
            {
	        return salario;
	    }

	    public void setSalario(double salario) 
            {
	        this.salario = salario;
	    }

	    public String getDepartamento() 
            {
	        return departamento;
	    }

	    public void setDepartamento(String departamento) 
            {
	        this.departamento = departamento;
	    }
}


public class calcularPago 
{
   public double calcularPagoMensual(empleado empleado) 
   {
       return empleado.getSalario() / 12;
   }
}

public class Main 
{
	public static void main(String[] args) 
    {
       empleado empleado = new empleado("Juan Pérez", 60000, "Desarrollo");
       calcularPago calcularPago = new calcularPago();
       double pagoMensual = calcularPago.calcularPagoMensual(empleado);
       System.out.println("El pago mensual de " + empleado.getNombre() + " es: $" + pagoMensual);
   }
}
