public class IgualGenerico 
{
    public static <T> boolean esIgualA(T obj1, T obj2) 
    {
        return obj1 != null && obj1.equals(obj2);
    }

    public static void main(String[] args) 
     {

        Integer int1 = 5;
        Integer int2 = 5;
        String str1 = "Hola";
        String str2 = "Hola";
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object nullObj = null;

        // Comparaciones
        System.out.println("Comparando Integers: " + esIgualA(int1, int2)); // true
        System.out.println("Comparando Strings: " + esIgualA(str1, str2)); // true
        System.out.println("Comparando Objects: " + esIgualA(obj1, obj2)); // false
        System.out.println("Comparando Integer y null: " + esIgualA(int1, nullObj)); // false
        System.out.println("Comparando null y null: " + esIgualA(nullObj, nullObj)); // false
    }
}
