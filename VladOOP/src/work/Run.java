package work;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import frame.*;

/**
 * Главный запускающийся класс
 * О программе
 *
 * @version 3
 * Калькуляторы прогрессии:
 * Значение n-того члена арифметической прогрессии
 * @author Можейко Владислав Григорьевич
 */
public class Run {

	
	/**
	 * Стартовое окно
	 */
	public static StartPage SP;
	/**
	 * Главное окно
	 */
	public static MainFrame MF;
	/**
	 * Программное окно (о программе)
	 */
	public static About Ab;
	/**
	 * Авторское окно
	 */
	public static Avtor Av;
	
	
	/**
	 * Главный метод, создает стартовое окно
	 * @param args строковый массив
	 */
	public static void main(String[] args) {
		 
		SP = new StartPage();
		SP.setVisible(true);
		
	}
	
	
	public static void Arbeit( JTextField a1_, JTextField d_, JTextField n_, JTextField nAns_) {
				
		if(isDigit(a1_.getText()) && isDigit(d_.getText()) && isDigit(n_.getText())) {
		
		double a1,d,n,nAns;
		a1 = Double.parseDouble(a1_.getText());
		d = Double.parseDouble(d_.getText());
		n = Double.parseDouble(n_.getText());
		nAns = a1 + (n-1)*d;
	
		nAns_.setText(nAns +"");		
		
		} else {
			JOptionPane.showMessageDialog(null, "Ожидается ввод положительного целого числа. \n"+ "Проверьте, является ли введанная вами информация числом");
		}
    }
	
	/**
	 * Метод проверки строки на число
	 * @param s исходная строка в виде числа
	 * @return булевое значение, является ли строка числом
	 */
	public static boolean isDigit(String s)  {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	
}
