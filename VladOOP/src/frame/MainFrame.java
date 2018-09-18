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
 * Класс основного окнп пользователя
 * О программе
 *
 * @version 3
 * Калькуляторы прогрессии:
 * Значение n-того члена арифметической прогрессии
 * @author Можейко Владислав Григорьевич
 */
public class MainFrame extends JFrame {
	

    JTextField a1 = new JTextField();
    JTextField d = new JTextField();
    JTextField n = new JTextField();
    JTextField nAns = new JTextField();
    
 // Создаем кнопки       
    JButton jbtCalc = new JButton("Найти");
    JButton jbtClear = new JButton("Очистить");
    JButton jbtAbout = new JButton("О программе");
    JButton jbtAuthor = new JButton("Об авторе");
    JButton jbtExit = new JButton("Выход");
    
    JLabel label1 = new JLabel("Введите первый член арифметической прогрессии");
    JLabel label2 = new JLabel("Введите коэфициент разности прогрессии (d)");
    JLabel label3 = new JLabel("N-ный член прогрессии расчитывается по формуле");
    JLabel label4 = new JLabel("an = a1 + (n-1)d");
    JLabel label5 = new JLabel("N-ный член равен:");
    JLabel label6 = new JLabel("Введите какой по счету член прогрессии найти");
    
	/**
	 * Метод отрисовки главной формы программы.
	 */
	public MainFrame() {
		// устанавливаем заголовок, выход по крестику, размер и запрещем масщтабировать 
        setTitle("Значение n-того члена арифметической прогрессии");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(480,250);
        
        // Создаем панель кнопок, нижняя часть главного окна
        JPanel pBtn = new JPanel(new FlowLayout());

        // Добавляем кнопки на панель кнопок
        pBtn.add(jbtCalc);
        pBtn.add(jbtClear);
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        // создаем центральную часть окна верха
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
        
        // Добавляем все на фрейм
        add(center,BorderLayout.CENTER);
        add(pBtn,BorderLayout.PAGE_END);
        
        // кнопка о программе
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
        
        //кнопка об автаре
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
        
        // кнопка выйти
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "Да", "Нет!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "Закрыть окно?",
	                                "Подтверждение", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // кнопка найти
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(a1, d, n, nAns);
			}
		});
        
        // кнопка очистить
        jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				a1.setText("");
				d.setText("");
				n.setText("");
				nAns.setText("");				
			}
		});
        
       
        
       
        // предупреждение о выходе
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Да, выйти", "Нет, остаться"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Вы действительно хотите выйти?", "Отвечайте за свои поступки",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
