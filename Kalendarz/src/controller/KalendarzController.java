package controller;

import model.KalendarzModel;
import view.KalendarzView;

public class KalendarzController {
	private KalendarzView theKalendarzView = new KalendarzView();
	private KalendarzModel theKalendarzModel = new KalendarzModel();
	
	public KalendarzController(KalendarzView theKalendarzView, KalendarzModel theKalendarzModel){
		this.theKalendarzView = theKalendarzView;
		this.theKalendarzModel = theKalendarzModel;

		theKalendarzView.crateYearSelectComboBox(theKalendarzModel.getYears());
		theKalendarzView.crateMonthSelectComboBox(theKalendarzModel.getMonthsNames());
	}
}
