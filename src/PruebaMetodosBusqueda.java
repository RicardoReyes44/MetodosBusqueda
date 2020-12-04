
class MetodosBusqueda{
	
	public boolean binarySearch(int[] data, int target, int low, int high) {
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
		
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(mb.binarySearch(array, 12, 0, array.length-1));

	}

}
