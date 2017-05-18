package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.KalendarzModel;
import view.KalendarzView;

public class MonthComboBoxListener implements ActionListener{
	private KalendarzView theKalendarzView = new KalendarzView();
	private KalendarzModel theKalendarzModel = new KalendarzModel();
	
	MonthComboBoxListener(KalendarzView theKalendarzView, KalendarzModel theKalendarzModel){
		this.theKalendarzView = theKalendarzView;
		this.theKalendarzModel = theKalendarzModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		int year = Integer.parseInt(theKalendarzView.getYearSelectComboBox().getSelectedItem().toString());
		int month = theKalendarzView.getMonthSelectComboBox().getSelectedIndex();
		theKalendarzView.updateButtonFielsGrid(theKalendarzModel.updateCalendar(year, month));
	}
}
