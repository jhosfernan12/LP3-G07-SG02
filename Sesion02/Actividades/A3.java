public class Automovil {
    private String placa;
    private int numPuertas;
    private String marca;
    private String modelo;
    private Motor Motor;


    public Automovil (String placa; int nPuertas, String marca, String modelo){
    this.placa = placa;
    this.numPuertas = nPuertas;
    this.marca = marca;
    this.modelo = modelo;
    }

    //setter y getter
    public String toString(){
        //complete con la informacion requerida
        return "";
    }
}


public class Motor{
    private int numMotor;
    private int revPorMin;

    public Motor (int numMotor, int revPorMin){
        this.numMotor = numMotor;
        this.revPorMin = revPorMin;
    }

    //setter y getter

    public String toString(){
        //complete con la informacion requerida
        return""
    }
}
