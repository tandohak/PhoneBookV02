package kr.or.dgit.phonebook.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.phonebook.ctrl.PhoneControl;

public class PhoneBookMainUI extends JFrame {
	public static final String[] COL_NAMES = {"번호","이름","주소","전화번호"};
	private JPanel contentPane;
	private JTable table;
	PhoneControl phoneControl;
	public PhoneBookMainUI() {
		phoneControl =new PhoneControl();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		PhonePanel panel = new PhonePanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		DefaultTableModel model = new DefaultTableModel(getDatas(), PhoneBookMainUI.COL_NAMES);
		table = new JTable(model);		
		
		scrollPane.setViewportView(table);
	}

	private Object[][] getDatas() {
		return phoneControl.showPhone();
	}

}
