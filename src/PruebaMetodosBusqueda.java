import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class BinarySearch{
	
	private String[] arreglo;
	private int tamaño;
	private int contador;
	
	public boolean binarySearch(long[] data, long target, int low, int high) {
		if (low > high)
			return false;
		else {
			int mid = (low + high) / 2;
			if (target == data[mid])
				return true;
			else if (target < data[mid])
				return binarySearch(data, target, low, mid - 1);
			else
				return binarySearch(data, target, mid + 1, high);
		}
	}
	
}

class Hash{
	String[] arreglo;
	int tamaño;
	int contador;

	// Constructor
	public Hash(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}

	// Funcion HASH
	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 20;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			while (arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				// Cambiar al indice siguiente y asi evitar la colision
				indiceArreglo %= tamaño; // Para volver a sacar el valor
			}
			arreglo[indiceArreglo] = elemento;
		}
	}

	// Metodo para mostrar la funcion hash
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 20;
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 20; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			System.out.println();
			for (j = incremento - 20; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			System.out.println("");
		}
	}

	// Metodo para buscar una clave de los elementos
	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 7;
		int contador = 0;
		
		while (arreglo[indiceArrglo] != "-1") {
			if (arreglo[indiceArrglo].equals(elemento)) {
				System.out.println("Elemento " + elemento + " se encontro en el indice" + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			if (contador > 20) {
				System.out.print("Error");
				break;
			}
		}
		return null;
	}
}


public class PruebaMetodosBusqueda {

	public static void main(String[] args) {
		
		BinarySearch bs = new BinarySearch();
		Hash funcion = new Hash(20);
		Scanner entrada = new Scanner(System.in);
		
		long array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		String arrayCadena[] = new String[array.length];
		
		for(int i=0; i<array.length; i++) {
			arrayCadena[i] = String.valueOf(array[i]);
		}

		funcion.funcionHash(arrayCadena, funcion.arreglo);
		
		do {
		try {
			System.out.println("--------------MENU--------------");
			System.out.println("1.- Busqueda Binaria");
			System.out.println("2.- Busqueda Hash");
			System.out.println("3.- Salir");
			System.out.print("Introduce opcion: ");
			byte opcion = entrada.nextByte();
			
			System.out.println("Array: " + Arrays.toString(array));
			
			if(opcion==1) {
				
				System.out.print("\nIntroduce numero a buscar: ");
				long numero = entrada.nextLong();
				System.out.println("\n>>> " + bs.binarySearch(array, numero, 0, array.length-1));
				
			}else if(opcion==2) {
				
				System.out.print("\nIntroduce numero a buscar: ");
				String elemento = entrada.next();
				String buscarElemento = funcion.buscarClave(elemento);
				System.out.println("\n>>> " + buscarElemento);
				
			}else if(opcion==3) {
				
				break;
				
			}else {
				System.out.println("No existe esa opcion, prueba de nuevo");
			}
		}catch(InputMismatchException e) {
			System.out.println("Error en la entrada de datos <" + e + ">, vuevle a intentarlo");
		    entrada.nextLine();
		}System.out.println();
		}while(true);
		
		System.out.println("\n\nPrograma terminado");
		
	}

}
