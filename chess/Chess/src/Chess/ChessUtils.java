package Chess;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ChessUtils {
	private static final Random random = new Random();

	static public <T> void randomizeArray(T[] array) {
		int count = array.length * array.length;
		
		for (int i = 0; i < count; i++) {
			int index0 = random.nextInt(array.length);
			int index1 = random.nextInt(array.length);
			T piece = array[index0];
			array[index0] = array[index1];
			array[index1] = piece;
		}
	}
	
	static public <T> T[] cat(T[] array1, T[] array2) {
		if (array1 == null || array1.length == 0)
			return (T[])Arrays.copyOf(array2, array2 == null ? 0 : array2.length);
		if (array2 == null || array2.length == 0)
			return (T[])Arrays.copyOf(array1, array1.length);
		
		T[] array;
		array = (T[])Array.newInstance(array1[0].getClass(), array1.length + array2.length);
		int index = 0;
		
		for (T element : array1)
			array[index++] = element;

		for (T element : array2)
			array[index++] = element;
		
		return array;
	}
}
