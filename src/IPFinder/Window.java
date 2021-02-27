package IPFinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.UnknownHostException;


public class Window extends Frame implements ActionListener {

	private static final long serialVersionUID = 8864834815386457456L;
	
	JLabel msgTextLabel;
	JTextField inputField;
	JButton button;
	JLabel ip;
	
	public Window() {
		msgTextLabel = new JLabel("Insert IP");
		msgTextLabel.setBounds(50, 50, 100, 30);
		add(msgTextLabel);
		
		inputField = new JTextField();
		inputField.setBounds(50, 80, 150, 20);
		add(inputField);
		
		ip = new JLabel();
		ip.setBounds(50, 100, 200, 20);
		add(ip);
		
		button = new JButton("Find this IP");
		button.setBounds(50, 135, 100, 30);
		button.addActionListener(this);
		add(button);

		setSize(300, 300);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		String hostName = inputField.getText();
		String ipString = "";
		try {
			ipString = java.net.InetAddress.getByName(hostName).getHostAddress();
			ip.setText("IP: " + ipString);
		} catch (UnknownHostException e) {
			ip.setText("Hostname not found.");
		}
		
	}
}