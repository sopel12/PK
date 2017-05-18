package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.KalendarzView;

public class MonthComboBoxListener implements ActionListener{
	KalendarzView theKalendarzView = new KalendarzView();
	MonthComboBoxListener(KalendarzView theKalendarzView){
		this.theKalendarzView = theKalendarzView;
	}
	public void actionPerformed(ActionEvent e) {
		int year = Integer.parseInt(theKalendarzView.getYearSelectComboBox().getSelectedItem().toString());
		int month = theKalendarzView.getMonthSelectComboBox().getSelectedIndex();
		theKalendarzView.updateCalendar(year, month);
	}
}
