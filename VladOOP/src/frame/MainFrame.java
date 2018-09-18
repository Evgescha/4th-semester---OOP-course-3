package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import work.Run;


/**
 * ����� ��������� ���� ������������
 * � ���������
 *
 * @version 3
 * ������������ ����������:
 * �������� n-���� ����� �������������� ����������
 * @author ������� ��������� �����������
 */
public class MainFrame extends JFrame {
	

    JTextField a1 = new JTextField();
    JTextField d = new JTextField();
    JTextField n = new JTextField();
    JTextField nAns = new JTextField();
    
 // ������� ������       
    JButton jbtCalc = new JButton("�����");
    JButton jbtClear = new JButton("��������");
    JButton jbtAbout = new JButton("� ���������");
    JButton jbtAuthor = new JButton("�� ������");
    JButton jbtExit = new JButton("�����");
    
    JLabel label1 = new JLabel("������� ������ ���� �������������� ����������");
    JLabel label2 = new JLabel("������� ���������� �������� ���������� (d)");
    JLabel label3 = new JLabel("N-��� ���� ���������� ������������� �� �������");
    JLabel label4 = new JLabel("an = a1 + (n-1)d");
    JLabel label5 = new JLabel("N-��� ���� �����:");
    JLabel label6 = new JLabel("������� ����� �� ����� ���� ���������� �����");
    
	/**
	 * ����� ��������� ������� ����� ���������.
	 */
	public MainFrame() {
		// ������������� ���������, ����� �� ��������, ������ � �������� �������������� 
        setTitle("�������� n-���� ����� �������������� ����������");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(480,250);
        
        // ������� ������ ������, ������ ����� �������� ����
        JPanel pBtn = new JPanel(new FlowLayout());

        // ��������� ������ �� ������ ������
        pBtn.add(jbtCalc);
        pBtn.add(jbtClear);
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        // ������� ����������� ����� ���� �����
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        center.add(label1);
        center.add(a1);
        center.add(label2);
        center.add(d);
        center.add(label6);
        center.add(n);
        center.add(label3);
        center.add(label4);
        center.add(label5);
        center.add(nAns);
        
        // ��������� ��� �� �����
        add(center,BorderLayout.CENTER);
        add(pBtn,BorderLayout.PAGE_END);
        
        // ������ � ���������
        jbtAbout.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Ab ==null) {
            		Run.Ab =  new About();            		
            	}
				setEnabled(false);
            	Run.Ab.setVisible(true);	
            	
			}
		});
        
        //������ �� ������
        jbtAuthor.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Av ==null) {
            		Run.Av =  new Avtor();            		
            	}
				setEnabled(false);
            	Run.Av.setVisible(true);
            	
								
			}
		});
        
        // ������ �����
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "��", "���!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "������� ����?",
	                                "�������������", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // ������ �����
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(a1, d, n, nAns);
			}
		});
        
        // ������ ��������
        jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a1.setText("");
				d.setText("");
				n.setText("");
				nAns.setText("");				
			}
		});
        
       
        
       
        // �������������� � ������
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"��, �����", "���, ��������"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "�� ������������� ������ �����?", "��������� �� ���� ��������",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
