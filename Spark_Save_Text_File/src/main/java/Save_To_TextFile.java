import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.rdd.RDD;

import akka.dispatch.Foreach;

public class Save_To_TextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String logFile = "C:/Users/Harpreet/Desktop/sample_words.txt";
		SparkConf conf = new SparkConf().setAppName("Test").setMaster(
				"local[2]");

		JavaSparkContext sc = new JavaSparkContext(conf);
		//
		// JavaRDD<String> inputRDD = sc.textFile(logFile);
		//
		// System.out.print("\n......................\n");
		//
		// JavaRDD<String> errors = inputRDD.filter(s -> s.contains("error"));
		//
		// for(String k:inputRDD.take(10))
		// {
		// System.out.println(k);
		// }
		//
		// System.out.print("\n......................\n");

		JavaRDD<Integer> numbersRDD = sc.parallelize(Arrays.asList(1, 2, 3, 4,
				1, 5, 2, 4, 1));

		JavaRDD<Integer> resultRDD = numbersRDD.map(x -> x * x);

		// resultRDD.collect()

		for (Integer i : resultRDD.distinct().takeOrdered(3,
				mycomparator.INSTANCE)) {
			System.out.println(i);
		}

		// JavaRDD<String> stringRDD =
		// sc.parallelize(Arrays.asList("Hello world","Harpreet Varma",
		// "Download", "Smart Insert"));
		//
		// JavaRDD<String> flatMapRDD = stringRDD.flatMap(x ->
		// Arrays.asList(x.split(" ")));
		//
		// for (String i : flatMapRDD.collect()) {
		// System.out.println(i);
		// }

		// Map<Integer, Long> countByVal = numbersRDD.countByValue();
		//
		//
		//
		// for (int i : countByVal.keySet()) {
		// System.out.println(i + "......" + countByVal.get(i));
		// }

	}

}
