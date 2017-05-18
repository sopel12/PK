package model;

public class KalendarzModel {
	private String[] years;
	private String[] months;
	private String monthsNames[] = { "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpien",
			"Wrzesien", "Pażdziernik", "Listopad", "Grudzień" };
	private int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String[] dayNames = { "PN", "WT", "ŚR", "CZW", "PT", "SOB", "ND" };
	
	public KalendarzModel() {
		// TODO Auto-generated constructor stub
	}
	
	public String[] getMonthsNames() {
		return monthsNames;
	}

	public void setMonthsNames(String[] monthsNames) {
		this.monthsNames = monthsNames;
	}

	public int[] getMonthDays() {
		return monthDays;
	}

	public void setMonthDays(int[] monthDays) {
		this.monthDays = monthDays;
	}

	public String[] getDayNames() {
		return dayNames;
	}

	public void setDayNames(String[] dayNames) {
		this.dayNames = dayNames;
	}

	public String[] getYears() {
		String[] years = new String[201];
		for (int i = 1900, j = 0; i < 2100; i++, j++) {
			years[j] = String.valueOf(i);
		}
		return years;
	}

//	public void setYears(String[] years) {
//		this.years = years;
//	}

	public String[] getMonths() {
		return months;
	}

//	public void setMonths(String[] months) {
//		this.months = months;
//	}
}
