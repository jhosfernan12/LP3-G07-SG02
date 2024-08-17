#include <iostream>
using namespace std;


int sumarElementos(int arreglo[], int tamano) {
    int suma = 0;
    for (int i = 0; i < tamano; ++i) {
        suma += arreglo[i];
    }
    return suma;
}


int main() {
    int arreglo[] = {1, 2, 3, 4, 5};
    int tamano = sizeof(arreglo) / sizeof(arreglo[0]);
    int resultado = sumarElementos(arreglo, tamano);
    cout << "La suma de los elementos es: " << resultado << endl;
    return 0;
}
