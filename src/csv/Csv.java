package csv;

public class Csv {

	public static void main(String[] args) {
		String[] items = { "Pants - $20 - 10%", "Shorts - $15 - 10%" };
		System.out.println(calculation(items));
		
	}

	// str.substring(0, str.length() - chars);

	public static String calculation(String[] items) {
		double totalPrice = 0.0;
		double salePrice = 0.0;
		double amountSaved = 0.0;
		StringBuffer sb = new StringBuffer();
		for (String item : items) {
			try {

				java.util.Optional<String> priceStr = findPrice(item);
				if (priceStr.isEmpty()) {
					continue;
				} else {
					String priceString = priceStr.get();
					totalPrice = Integer.parseInt(priceString.substring(1));
				}

				java.util.Optional<String> percentOffStr = findPercentOff(item);
				if (percentOffStr.isEmpty()) {
					continue;
				} else {
					String percent = percentOffStr.get();
					String percentWithoutCharacter = percent.substring(0, percent.length() - 1);
					salePrice = Integer.parseInt(percentWithoutCharacter);
				}

				salePrice = totalPrice - (totalPrice * salePrice / 100.0);
				amountSaved = totalPrice - salePrice;
				

				sb.append("Total Original Price:$").append(totalPrice).append(";Total sale price: $").append(salePrice)
						.append(";Amount saved:$").append(amountSaved).append(";");				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				System.out.println("Errooooooo");
			}
			
			//sb.
		}
		return sb.toString();
	}


	// Total Original Price:$<total original price>;Total sale price: $<total sale
	// price>;Amount saved:$<amount saved>;

	
	private static java.util.Optional<String> findPrice(String line) {
		// String regex = "\\d*\\$";
		// String regex = "[0-9]+";
		String regex = "[$][0-9]+";
		java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
		if (m.find()) {
			try {
				String priceStr = m.group();
				return java.util.Optional.of(priceStr);
			} catch (java.time.format.DateTimeParseException ex) {
				ex.printStackTrace();
				return java.util.Optional.empty();
			}
		}
		return java.util.Optional.empty();
	}

	
	private static java.util.Optional<String> findPercentOff(String line) {
		// String regex = "\\d*%";
		String regex = "[0-9]+[%]";
		java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
		if (m.find()) {
			try {
				String percentOffStr = m.group();
				return java.util.Optional.of(percentOffStr);
			} catch (java.time.format.DateTimeParseException ex) {
				ex.printStackTrace();
				return java.util.Optional.empty();
			}
		}
		return java.util.Optional.empty();
	}

}
