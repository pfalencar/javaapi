package javascript;

public class Javascript {

	public static void main(String[] args) {
		System.out.println(Javascript.number_cardinality(12));
	}
	
	public static String number_cardinality ( int my_number ) {
		if (my_number % 10 == 0) {
			return "zero";
		} else if ( my_number % 5 == 0 ){
			return "cinco";
		} else if (my_number % 2 == 0 && my_number != 0) {
			return "even";
		} else if (my_number % 2 != 0 && my_number % 5 != 0) {
			return "odd";
		}
		return null;
	}

}
