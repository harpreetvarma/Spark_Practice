import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.rdd.RDD;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String logFile = "C:/Users/Harpreet/Desktop/sample_words.txt";
		SparkConf conf = new SparkConf().setAppName("Test");

		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> input = sc.textFile(logFile);

		JavaRDD<String> AliceRDD = input
				.filter(new Function<String, Boolean>() {
					public Boolean call(String x) {
						return x.contains("Alice");
					}
				});

		AliceRDD.foreach(new VoidFunction<String>() {

			public void call(String arg0) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(arg0);
			}
		});
		

	}

}
