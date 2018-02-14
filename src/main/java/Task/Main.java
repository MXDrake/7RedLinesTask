package Task;

import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		String string = "34;45;52352;323;32";
		int[] array = toIntArray(string);
		System.out.println(Arrays.toString(array));
		array = toIntArrayStream(string);
		System.out.println(Arrays.toString(array));
	}

	public static int[] toIntArray(String string) {
		String[] strings = string.split(";");
		int initialSize = strings.length;
		int[] initialArray = new int[initialSize];
		int resultSize = 0;

		for (int i = 0; i < initialSize; i++) {
			int number = Integer.parseInt(strings[i]);
			if (number % 2 == 0) {
				resultSize++;
				initialArray[i] = number;
			}
		}
		Arrays.sort(initialArray);
		return Arrays.copyOfRange(initialArray, initialSize - resultSize, initialSize);
	}

	public static int[] toIntArrayStream(String string) {
		return Arrays.stream(Arrays.stream(string.trim().split(";")).parallel().mapToInt(Integer::parseInt).toArray())
				.filter(x -> x % 2 == 0).sorted().toArray();
	}
}
