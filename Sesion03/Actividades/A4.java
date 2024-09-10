interface ServicioLimpieza 
{
    void solicitarLimpieza();
}

interface ServicioComida 
{
    void solicitarComida(String comida);
}

interface ServicioLavanderia 
{
    void solicitarLavanderia(String prenda);
}

class Habitacion 
{
}

class HabitacionSimple extends Habitacion 
{
}

class HabitacionDoble extends Habitacion 
{
}

class HabitacionSuite extends Habitacion implements ServicioLimpieza, ServicioComida, ServicioLavanderia {
    @Override
    public void solicitarLimpieza() 
    {
        System.out.println("Limpieza solicitada para habitación suite.");
    }

    @Override
    public void solicitarComida(String comida) 
    {
        System.out.println("Comida solicitada en habitación suite: " + comida);
    }

    @Override
    public void solicitarLavanderia(String prenda) 
    {
        System.out.println("Lavandería solicitada para habitación suite: " + prenda);
    }
}

class Controlador {
    public void solicitarServicios(Habitacion habitacion) 
    {
        if (habitacion instanceof ServicioLimpieza) 
        {
            ((ServicioLimpieza) habitacion).solicitarLimpieza();
        }
        if (habitacion instanceof ServicioComida) 
        {
            ((ServicioComida) habitacion).solicitarComida("Pizza");
        }
        if (habitacion instanceof ServicioLavanderia) 
        {
            ((ServicioLavanderia) habitacion).solicitarLavanderia("Camisa");
        }
    }
}

public class Main
{
    public static void main(String[] args) 
    {
        HabitacionSuite habitacionSuite = new HabitacionSuite();
        Controlador controlador = new Controlador();
        controlador.solicitarServicios(habitacionSuite);
    }
}
