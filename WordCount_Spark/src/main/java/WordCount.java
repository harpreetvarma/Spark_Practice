import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SparkConf conf = new SparkConf();

		JavaSparkContext ctx = new JavaSparkContext("local[2]",
				"Word Count App", conf);

		JavaRDD<String> stringRDD = ctx.parallelize(Arrays.asList(
				"Hello World", "Hi", "Hi Harpreet", "Hello Harpreet Varma"));

		JavaRDD<String> flatRDD = stringRDD.flatMap(x -> Arrays.asList(x
				.split(" ")));

		JavaPairRDD<String, Integer> pairs = flatRDD.mapToPair(
				x -> new Tuple2<String, Integer>(x, 1)).reduceByKey(
				(x, y) -> x + y);

		pairs.coalesce(1).saveAsTextFile("out");

	}

}
