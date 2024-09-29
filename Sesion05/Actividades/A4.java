
public boolean esIgual(Pila<E> otraPila) 
{
    if (this.superior != otraPila.superior) 
    { 
      
        return false;
    }


    for (int i = 0; i <= superior; i++) 
    {
        if (!elementos[i].equals(otraPila.elementos[i])) 
        {
            return false;
        }
    }
    
    return true;
}
