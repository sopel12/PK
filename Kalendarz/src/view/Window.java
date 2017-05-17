package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JComboBox;

public class Window extends JFrame {

	private JPanel contentPane;
    private JButton[] dayButtons = new JButton[42];
    private JComboBox monthSelectComboBox;


	int d_year = Calendar.getInstance().get(Calendar.YEAR);


	int d_month = Calendar.getInstance().get(Calendar.MONTH);
	/**
	 * Create the frame.
	 */
	public Window() {
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

	}
	public void setYearComboBox(String years[]){
		JComboBox yearSelectComboBox = new JComboBox(years);
		yearSelectComboBox.setSelectedIndex(d_year - 1900);
		yearSelectComboBox.setBounds(10, 11, 147, 43);
		contentPane.add(yearSelectComboBox);
	}
	
	public void setMonthComboBox(String months[]){
//		JComboBox monthSelectComboBox = new JComboBox(months);

		monthSelectComboBox = new JComboBox(months);
		monthSelectComboBox.setSelectedIndex(d_month);
		monthSelectComboBox.setBounds(180, 11, 147, 43);
//		monthSelectComboBox.addActionListener(new );
		
		
		contentPane.add(monthSelectComboBox);
	}
	
	public void addMonthComboBoxController(ActionListener controller){
//		System.out.println("View      : adding controller");
		monthSelectComboBox.addActionListener(controller);	//need instance of controller before can add it as a listener 
	} //addController()
	
	public void setGrid(String[] dayNames) {
		JPanel panel = new JPanel();
		panel.setBounds(10, 65, 474, 245);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(7, 7, 0, 0));
		JLabel[] labels = new JLabel[7];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(dayNames[i]);
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(labels[i]);
		}
		for (int i = 0; i < dayButtons.length; i++) {
			dayButtons[i] = new JButton();
			// textFields[i].setEditable(false);
			dayButtons[i].setHorizontalAlignment(JTextField.CENTER);
			// textFields[i].setBorderPainted(false);
			dayButtons[i].setFocusPainted(false);
			dayButtons[i].setContentAreaFilled(false);
			panel.add(dayButtons[i]);
		}
	}
	
	public void updateDayButtons(int day, int monthDays) {
		for (int i = 0; i < dayButtons.length; i++) {
			dayButtons[i].setText("");
		}
		System.out.println(monthDays);
		for (int i = 1, j = day; i <= monthDays; i++, j++) {
			dayButtons[j].setText(String.valueOf(i));
			dayButtons[j].setFocusPainted(true);
		}
	}
	

	public int getD_year() {
		return d_year;
	}
	public int getD_month() {
		return d_month;
	}

	public JComboBox getMonthSelectComboBox() {
		return monthSelectComboBox;
	}
}
