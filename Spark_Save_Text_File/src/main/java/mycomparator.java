import java.io.Serializable;
import java.util.Comparator;

public class mycomparator implements Comparator<Integer>, Serializable {

	public static final Comparator<Integer> INSTANCE = new mycomparator();

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return -1 * o1.compareTo(o2);
	}

}
