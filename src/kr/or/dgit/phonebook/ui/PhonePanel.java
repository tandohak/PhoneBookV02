package kr.or.dgit.phonebook.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.phonebook.DTO.Phone;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;



public class PhonePanel extends JPanel {
	private JTextField tfName;
	private JTextField tfAddr;
	private JTextField tfTel;
	private JButton btnAdd;
	/**
	 * Create the panel.
	 */
	public PhonePanel() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);  
		add(lblName);
		
		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.LEFT);
		add(tfName);
		tfName.setColumns(5);
		
		JLabel lblAddr = new JLabel("주소");
		lblAddr.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblAddr);
		
		tfAddr = new JTextField();
		tfAddr.setHorizontalAlignment(SwingConstants.LEFT);
		tfAddr.setColumns(5);
		add(tfAddr);
		
		JLabel lblTel = new JLabel("연락처");
		lblTel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setHorizontalAlignment(SwingConstants.LEFT);
		tfTel.setColumns(5);
		add(tfTel);
		
		btnAdd = new JButton("추가");
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		add(btnAdd);
		
	}
	
	public JButton getBtn(){
		return btnAdd;
	}
	public void setPhone(Phone phone){
		tfName.setText(phone.getName());
	}
	public Phone getPhnoe(){
		String name = tfName.getText();
		String addr = tfAddr.getText();
		String tel = tfTel.getText();
		return new Phone(name,addr,tel);
	}

	public void clearTf(){
		tfName.setText("");
		tfAddr.setText("");
		tfTel.setText("");
	}
}
