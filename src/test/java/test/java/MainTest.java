package test.java;

import Task.Main;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
public class MainTest {

	private ArrayList<String> strings = new ArrayList<>();
	private ArrayList<List<Integer>> expectedArrays = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		strings.add("34;45;52352;323;32");
		strings.add("1;2;3;4;5;6;7;8;9");
		strings.add("9;8;7;6;5;4;3;2;1");
		strings.add("");
		strings.add(null);

		List expected1 = Arrays.asList(32, 34, 52352);
		List expected2 = Arrays.asList(2, 4, 6, 8);
		List expected3 = Arrays.asList(2, 4, 6, 8);
		List expected4 = Arrays.asList();
		List expected5 = Arrays.asList();

		expectedArrays.add(expected1);
		expectedArrays.add(expected2);
		expectedArrays.add(expected3);
		expectedArrays.add(expected4);
		expectedArrays.add(expected5);

	}

	@Test
	public void toIntArray() throws Exception {
		for (int i = 0; i < strings.size(); i++) {
			int[] expected = expectedArrays.get(i).stream().mapToInt(x -> x).toArray();
			int[] result = Main.toIntArray(strings.get(i));
			assertArrayEquals("Wrong array", expected, result);
		}
	}

	@Test
	public void toIntArrayStream() throws Exception {
		for (int i = 0; i < strings.size(); i++) {

			int[] expected = expectedArrays.get(i).stream().mapToInt(x -> x).toArray();
			int[] result = Main.toIntArrayStream(strings.get(i));
			assertArrayEquals("Wrong array", expected, result);
		}
	}
}