package test.java;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import test.java.benchmarks.MethodeBenchmark;
import java.io.IOException;
public class MainBenchmark {

	//Start benchmark
	public static void main(String[] args) throws IOException, RunnerException {
		Options options = new OptionsBuilder().include(MethodeBenchmark.class.getSimpleName()).threads(1).forks(1)
				.shouldFailOnError(true).shouldDoGC(true).jvmArgs("-server").build();
		new Runner(options).run();

	}

}
