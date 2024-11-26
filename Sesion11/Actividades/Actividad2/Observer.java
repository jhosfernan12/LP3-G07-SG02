package s11;


interface Observer 
{
	void update(String estado);
}

interface Observable 
{
	 void agregarObservador(Observer o);
	 void notificarObservadores();
}
