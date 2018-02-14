package test.java.benchmarks;

import Task.Main;
import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.AverageTime)
public class MethodeBenchmark {

	@Param({"5"})
	public int iterations;

	@Setup(Level.Trial)
	public void setUp() {

	}

	@Benchmark
	public void toIntArray() {
		String string =
				"34;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32";
		for (int i = 0; i < 1000; i++) {
			int[] array = Main.toIntArray(string);
			System.out.println(array);
		}
	}

	@Benchmark
	public void toIntArrayStream() {
		String string =
				"34;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32;45;52352;323;32";
		for (int i = 0; i < 1000; i++) {
			int[] array = Main.toIntArrayStream(string);
			System.out.println(array);
		}
	}

}
