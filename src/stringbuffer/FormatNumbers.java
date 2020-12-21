package stringbuffer;

import java.text.*;
import java.util.Locale;

public class FormatNumbers {

	public static void main(String[] args) {

		int count = 1;
		StringBuffer sb = new StringBuffer("\n");

		String s = NumberFormat.getInstance().format(1.234); // Depends on default Locale
		sb.append(count++).append(": ").append(s).append("\n");

		
		s = NumberFormat.getInstance(Locale.GERMANY).format(1.234); // 1,234
		sb.append(count++).append(": ").append(s).append("\n");

		s = new DecimalFormat("#.##").format(1.234); // Depends on default Locale, 2 decimal places
		sb.append(count++).append(": ").append(s).append("\n");


		
		s = String.format("My number is %.2f", 1.234); // Depends on default Locale
		sb.append(count++).append(": ").append(s).append("\n");

		s = "My number is " + 1.234; // 1.234 - always uses the dot
		sb.append(count++).append(": ").append(s).append("\n");
		
		System.out.println(sb.toString());

	}

}
