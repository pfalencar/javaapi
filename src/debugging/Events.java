package debugging;

public class Events {

	public static void main(String[] args) {
		String a[] = { "The first human in space 12-03-1961" };
		String[] arraySorted = Events.sorted(a);
		for (int i = 0; i < arraySorted.length; i++) {
			System.out.println(arraySorted[i]);
			System.out.println(" ");
		}

	}

	public static String[] sorted(String[] events) {
		final java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
		final java.time.LocalDate now = java.time.LocalDate.of(1900, 1, 1);

		java.util.List<String> listOfEvents = new java.util.ArrayList<String>();

		StringBuilder sb = new StringBuilder();

		for (String event : events) {
			java.util.Optional<java.time.LocalDate> date = findDateInLine(event, formatter);
			if (date.isEmpty())
				continue;
			java.time.Period timeLeft = java.time.Period.between(date.get(), now);

			int dateIndex = event.indexOf(date.get().format(formatter));
			String title = event.substring(0, dateIndex - 1);

			sb.append((-1) * timeLeft.getYears()).append("years;").append((-1) * timeLeft.getMonths()).append("months;")
					.append((-1) * timeLeft.getDays()).append("days").append("-").append(title);
			listOfEvents.add(sb.toString());
		}
		listOfEvents.sort((String e1, String e2) -> e1.compareTo(e2));

		return listOfEvents.toArray(new String[listOfEvents.size()]);

	}

	private static java.util.Optional<java.time.LocalDate> findDateInLine(String line,
			java.time.format.DateTimeFormatter formatter) {
		String regex = "[0-9][0-9][-][0-9][0-9][-][0-9][0-9][0-9][0-9]";
		java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
		if (m.find()) {
			try {

				java.time.LocalDate date = java.time.LocalDate.parse(m.group(), formatter);
				return java.util.Optional.of(date);

			} catch (Exception e) {
				e.printStackTrace();
				return java.util.Optional.empty();
			}
		}
		return java.util.Optional.empty();
	}

}
