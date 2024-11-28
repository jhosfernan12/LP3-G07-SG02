package s11;

class CalculadoraDePrecios 
{
    private Descuento estrategia;

    public void setEstrategia(Descuento estrategia)
    {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(Producto producto, int cantidad) 
    {
        return estrategia.aplicarDescuento(producto.getPrecio(), cantidad);
    }
}