import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	System.setProperty("hadoop.home.dir", "D:/hadoop-common-2.2.0-bin-master/hadoop-common-2.2.0-bin-master/bin/winutils.exe");
		
		SparkConf conf = new SparkConf().setAppName("Line_Count");
		
		JavaSparkContext ctx = new JavaSparkContext(conf);
		
		JavaRDD<String> textLoadRDD = ctx.textFile("G:/spark-1.6.1-bin-hadoop2.6/README.md");
		
		System.out.println(textLoadRDD.count());
		
		textLoadRDD.coalesce(1).saveAsTextFile("C:/Users/Harpreet/Desktop/count");
		
	}

}
