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
 * ������� ������������� �����
 * � ���������
 *
 * @version 3
 * ������������ ����������:
 * �������� n-���� ����� �������������� ����������
 * @author ������� ��������� �����������
 */
public class Run {

	
	/**
	 * ��������� ����
	 */
	public static StartPage SP;
	/**
	 * ������� ����
	 */
	public static MainFrame MF;
	/**
	 * ����������� ���� (� ���������)
	 */
	public static About Ab;
	/**
	 * ��������� ����
	 */
	public static Avtor Av;
	
	
	/**
	 * ������� �����, ������� ��������� ����
	 * @param args ��������� ������
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
			JOptionPane.showMessageDialog(null, "��������� ���� �������������� ������ �����. \n"+ "���������, �������� �� ��������� ���� ���������� ������");
		}
    }
	
	/**
	 * ����� �������� ������ �� �����
	 * @param s �������� ������ � ���� �����
	 * @return ������� ��������, �������� �� ������ ������
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
