import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String logFile = "C:/Users/Harpreet/Desktop/sample_words.txt";
		SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[2]");
		
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<String> inputRDD = sc.textFile(logFile);
		
		inputRDD.saveAsTextFile("C:/Users/Harpreet/Desktop/out");
		
		
		
		}
}
