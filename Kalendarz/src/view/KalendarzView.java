package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class KalendarzView extends JFrame {

	

	private JPanel contentPane = new JPanel();
	private JPanel monthGridPanel = new JPanel();;
	private JButton[] buttonFields = new JButton[42];
	private JLabel[] labels = new JLabel[7];
	private JComboBox yearSelectComboBox;
	private JComboBox monthSelectComboBox;

	int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private int d_year = Calendar.getInstance().get(Calendar.YEAR);
	private int d_month = Calendar.getInstance().get(Calendar.MONTH);

	public KalendarzView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		monthGridPanel.setBounds(10, 65, 474, 245);
		contentPane.add(monthGridPanel);
		monthGridPanel.setLayout(new GridLayout(7, 7, 0, 0));
		
		
		int d_year = Calendar.getInstance().get(Calendar.YEAR);
		int d_month = Calendar.getInstance().get(Calendar.MONTH);


		String[] dayNames = { "PN", "WT", "ŚR", "CZW", "PT", "SOB", "ND" };
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(dayNames[i]);
			labels[i].setHorizontalAlignment(JLabel.CENTER);
			monthGridPanel.add(labels[i]);
		}

		for (int i = 0; i < buttonFields.length; i++) {
			buttonFields[i] = new JButton();
			// buttonFields[i].setEditable(false);
			buttonFields[i].setHorizontalAlignment(JTextField.CENTER);
			// buttonFields[i].setBorderPainted(false);
			buttonFields[i].setFocusPainted(false);
			buttonFields[i].setContentAreaFilled(false);
			buttonFields[i].addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {
					System.out.println("test");
				}

				public void mousePressed(MouseEvent e) {
				}

				public void mouseReleased(MouseEvent e) {
				}

				public void mouseEntered(MouseEvent e) {
				}

				public void mouseExited(MouseEvent e) {
				}

			});
			monthGridPanel.add(buttonFields[i]);
		}

		updateCalendar(d_year, d_month);
	}

	public void updateCalendar(int year, int month) {
		// int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// int y = 1900;
		// int m = 0;
		int day = 0;
		// System.out.println(year + " " + month + " " + leapYear(year));
		if (month == 1 && leapYear(year)) {
			monthDays[month] = 29;
		} else {
			monthDays[month] = 28;
		}
		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);

		int day_of_week = c.get(Calendar.DAY_OF_WEEK);
		day = Math.floorMod(day_of_week - 2, 7);

		for (int i = 0; i < buttonFields.length; i++) {
			buttonFields[i].setText("");
		}
		for (int i = 1, j = day; i <= monthDays[month]; i++, j++) {
			buttonFields[j].setText(String.valueOf(i));
			buttonFields[j].setFocusPainted(true);
		}
	}

	public void crateYearSelectComboBox(String[] getYears) {
		yearSelectComboBox = new JComboBox(getYears);
		yearSelectComboBox.setBounds(10, 11, 147, 43);
		yearSelectComboBox.setSelectedIndex(d_year - 1900);
		contentPane.add(yearSelectComboBox);
	}
	
	public void addYearSelectComboBoxListener(ActionListener listenForSelectYear){
		yearSelectComboBox.addActionListener(listenForSelectYear);
	}

	public void crateMonthSelectComboBox(String[] getMonths) {
		monthSelectComboBox = new JComboBox(getMonths);
		monthSelectComboBox.setBounds(180, 11, 147, 43);
		monthSelectComboBox.setSelectedIndex(d_month);
		contentPane.add(monthSelectComboBox);
	}
	
	public void addMonthSelectComboBoxListener(ActionListener listenForSelectMonth){
		monthSelectComboBox.addActionListener(listenForSelectMonth);
	}
	
	private boolean leapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}
	
	public JComboBox getYearSelectComboBox() {
		return yearSelectComboBox;
	}

	public void setYearSelectComboBox(JComboBox yearSelectComboBox) {
		this.yearSelectComboBox = yearSelectComboBox;
	}

	public JComboBox getMonthSelectComboBox() {
		return monthSelectComboBox;
	}

	public void setMonthSelectComboBox(JComboBox monthSelectComboBox) {
		this.monthSelectComboBox = monthSelectComboBox;
	}
}
