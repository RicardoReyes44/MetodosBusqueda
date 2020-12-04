import java.util.Arrays;
import java.util.Scanner;

class MetodosBusqueda{
	
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


public class PruebaMetodosBusqueda {

	public static void main(String[] args) {
		
		MetodosBusqueda mb = new MetodosBusqueda();
		Scanner entrada = new Scanner(System.in);
		
		long array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		do {
			
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
				System.out.println("\n>>> " + mb.binarySearch(array, numero, 0, array.length-1));
				
			}else if(opcion==2) {
				
				System.out.println("Proximamente");
				
			}else if(opcion==3) {
				
				break;
				
			}else {
				System.out.println("No existe esa opcion, prueba de nuevo");
			}
			System.out.println();
		}while(true);
		
		System.out.println("\n\nPrograma terminado");
		
	}

}
