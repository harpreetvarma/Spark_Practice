import java.io.Serializable;
import java.util.ArrayList;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.DoubleFunction;

import com.datastax.spark.connector.japi.CassandraRow;

import static com.datastax.spark.connector.japi.CassandraJavaUtil.*;

public class Cassandra_Test {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf(true).set(
				"spark.cassandra.connection.host", "localhost");

		JavaSparkContext ctx = new JavaSparkContext(conf);

		JavaRDD<CassandraRow> data = javaFunctions(ctx).cassandraTable("test",
				"keyvalue");

		// print some basic stats
		System.out.println(data.mapToDouble(new DoubleFunction<CassandraRow>() {
			public double call(CassandraRow row) {
				return row.getInt("value");
			}
		}).stats());

		ArrayList<KeyValue> input = new ArrayList<KeyValue>();
		input.add(KeyValue.newInstance("mostmagic", 3));
		JavaRDD<KeyValue> kvRDD = ctx.parallelize(input);
		javaFunctions(kvRDD).writerBuilder("test", "kv",
				mapToRow(KeyValue.class)).saveToCassandra();
	}

	public static class KeyValue implements Serializable {
		private String key;
		private Integer value;

		public KeyValue() {
		}

		public static KeyValue newInstance(String k, Integer v) {
			KeyValue kv = new KeyValue();
			kv.setKey(k);
			kv.setValue(v);
			return kv;
		}

		public String getKey() {
			return key;
		}

		public Integer getValue() {
			return value;
		}

		void setKey(String k) {
			this.key = k;
		}

		void setValue(Integer v) {
			this.value = v;
		}
	}
}
