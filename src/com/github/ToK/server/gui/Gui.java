package com.github.ToK.server.gui;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.github.ToK.server.main.Main;

public class Gui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<String> message = new ArrayList<String>();
	public Gui() {
		setTitle("ToK - Server");
		setSize(500, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridBagLayout());
		JTextArea Console = new JTextArea();
		Console.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		Console.setEditable(false);
		message.add("Dies ist die erste version mit gui");
		Console.setText(message.toString());
		Console.setSize(500, 500);
		JButton stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.server.interrupt();
				
			}
		});
		panel.add(stop);
		panel.add(Console);
		add(panel);
		if(isVisible() == false) {
			setVisible(true);
		}
	}

}
