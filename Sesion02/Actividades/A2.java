public class Contador
{
  static int acumulador = 0;
  final static int VALOR_INICIAL = 10;
  private int valor;

  public static int acumulador()
  {
    return acumulador;
  }

  public contador(int valor)
  {
    this.valor = valor;
    acumulator += valor;
  }

  public Contador()
  {
    this(Contador.VALOR_INICIAL);
  }

  public void int()
  {
    valor++;
    acumulador++;
    Contador.VALOR_INICIAL += valor;
  }

  public int getValor()
  {
    return this.valor;
  }

}
