package com.mike.parkin.calculators;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Button;
import javax.swing.JTextField;
import com.mike.parkin.calculators.Calculations;
import java.awt.Font;

public class Calc {

	private JFrame frame;
	private JTextField screen;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 265, 325);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		screen = new JTextField();
		screen.setText(" ");
		screen.setEditable(false);
		screen.setBounds(10, 11, 230, 20);
		frame.getContentPane().add(screen);
		screen.setColumns(10);
		
		JButton cancel = new JButton("C");
		cancel.setToolTipText("Clear");
		cancel.setMnemonic(KeyEvent.VK_DELETE);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(" ");
				result.setText(" ");
			}
		});
		cancel.setBounds(10, 82, 50, 30);
		frame.getContentPane().add(cancel);
		
		JButton bracket = new JButton("( )");
		bracket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int open = 0;
				int close = 0;
				
				for(int i=0; i < screen.getText().length(); i++) {
					if('(' == screen.getText().charAt(i)) {
						open++;
					}else if(')' == screen.getText().charAt(i)) {
						close++;
					}
				}
				
				if (open == close) {
					if(!Character.isDigit(screen.getText().charAt(screen.getText().length() - 1)) &&
										')' != screen.getText().charAt(screen.getText().length() -1)) {
						screen.setText(screen.getText() + " (");
					}
				}else {
					if(!Character.isDigit(screen.getText().charAt(screen.getText().length() - 1)) && 
										')' == screen.getText().charAt(screen.getText().length() -1)) {
						screen.setText(screen.getText() + ")");
					}else if('(' == screen.getText().charAt(screen.getText().length() -1)) {
						screen.setText(screen.getText() + "(");
					}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
						screen.setText(screen.getText() + " )");
					}
				}
			}
		});
		bracket.setBounds(70, 82, 50, 30);
		bracket.setMnemonic(KeyEvent.VK_OPEN_BRACKET);
		bracket.setMnemonic(KeyEvent.VK_CLOSE_BRACKET);
		frame.getContentPane().add(bracket);
		
		JButton divide = new JButton("/");
		divide.setToolTipText("Divide");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + " /");
				}else if(')' == screen.getText().charAt(screen.getText().length() - 1)) {
					screen.setText(screen.getText() + " /");
				}
			}
		});
		divide.setBounds(130, 82, 50, 30);
		divide.setMnemonic(KeyEvent.VK_DIVIDE);
		frame.getContentPane().add(divide);
		
		JButton times = new JButton("*");
		times.setToolTipText("Multiply");
		times.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + " *");
				}else if(')' == screen.getText().charAt(screen.getText().length() - 1)) {
					screen.setText(screen.getText() + " *");
				}
			}
		});
		times.setBounds(190, 82, 50, 30);
		times.setMnemonic(KeyEvent.VK_MULTIPLY);
		frame.getContentPane().add(times);
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "7");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "7");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "7");
				}else{
					screen.setText(screen.getText() + " 7");
				}
			}
		});
		seven.setBounds(10, 123, 50, 30);
		seven.setMnemonic(KeyEvent.VK_NUMPAD7);
		frame.getContentPane().add(seven);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "8");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "8");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "8");
				}else{
					screen.setText(screen.getText() + " 8");
				}
			}
		});
		eight.setBounds(70, 123, 50, 30);
		eight.setMnemonic(KeyEvent.VK_NUMPAD8);
		frame.getContentPane().add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "9");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "9");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "9");
				}else{
					screen.setText(screen.getText() + " 9");
				}
			}
		});
		nine.setBounds(130, 123, 50, 30);
		nine.setMnemonic(KeyEvent.VK_NUMPAD9);
		frame.getContentPane().add(nine);
		
		JButton minus = new JButton("-");
		minus.setToolTipText("Minus");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + " -");
				}else if(')' == screen.getText().charAt(screen.getText().length() - 1)) {
					screen.setText(screen.getText() + " -");
				}
			}
		});
		minus.setBounds(190, 123, 50, 30);
		minus.setMnemonic(KeyEvent.VK_SUBTRACT);
		frame.getContentPane().add(minus);
		
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "4");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "4");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "4");
				}else{
					screen.setText(screen.getText() + " 4");
				}
			}
		});
		four.setBounds(10, 164, 50, 30);
		four.setMnemonic(KeyEvent.VK_NUMPAD4);
		frame.getContentPane().add(four);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "5");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "5");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "5");
				}else{
					screen.setText(screen.getText() + " 5");
				}
			}
		});
		five.setBounds(70, 164, 50, 30);
		five.setMnemonic(KeyEvent.VK_NUMPAD5);
		frame.getContentPane().add(five);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "6");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "6");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "6");
				}else{
					screen.setText(screen.getText() + " 6");
				}
			}
		});
		six.setBounds(130, 164, 50, 30);
		six.setMnemonic(KeyEvent.VK_NUMPAD6);
		frame.getContentPane().add(six);
		
		JButton plus = new JButton("+");
		plus.setToolTipText("Plus");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + " +");
				}else if(')' == screen.getText().charAt(screen.getText().length() - 1)) {
					screen.setText(screen.getText() + " +");
				}
			}
		});
		plus.setBounds(190, 164, 50, 30);
		plus.setMnemonic(KeyEvent.VK_ADD);
		frame.getContentPane().add(plus);
		
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "1");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "1");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "1");
				}else{
					screen.setText(screen.getText() + " 1");
				}
			}
			
		});
		one.setBounds(10, 205, 50, 30);
		one.setMnemonic(KeyEvent.VK_NUMPAD1);
		frame.getContentPane().add(one);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "2");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "2");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "2");
				}else{
					screen.setText(screen.getText() + " 2");
				}
			}
		});
		two.setBounds(70, 205, 50, 30);
		two.setMnemonic(KeyEvent.VK_NUMPAD2);
		frame.getContentPane().add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "3");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "3");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "3");
				}else{
					screen.setText(screen.getText() + " 3");
				}
			}
		});
		three.setBounds(130, 205, 50, 30);
		three.setMnemonic(KeyEvent.VK_NUMPAD3);
		frame.getContentPane().add(three);
		
		JButton equals = new JButton("=");
		equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1)) || 
						')' == screen.getText().charAt(screen.getText().length() -1)) {
					System.out.println("Calculate: " + screen.getText());
					double sumResult = Calculations.getCalculation(screen.getText());
					result.setText(screen.getText() + " = " + String.valueOf(sumResult));
					screen.setText(" ");
				}
			}
		});
		equals.setBounds(190, 205, 50, 71);
		equals.setMnemonic(KeyEvent.VK_EQUALS);
		equals.setMnemonic(KeyEvent.VK_ENTER);
		frame.getContentPane().add(equals);
		
		JButton negate = new JButton("+ -");
		negate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				  double negateValue = -1 * Double.parseDouble(screen.getText());
				  screen.setText(String.valueOf(negateValue));
				}
				catch(NumberFormatException NotNumber)
				{
				  //not a number
				}
			}
		});
		negate.setBounds(10, 246, 50, 30);
		frame.getContentPane().add(negate);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(" " == screen.getText()) {
					screen.setText(screen.getText() + "0");
				}else if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + "0");
				}else if('.' == screen.getText().charAt(screen.getText().length() -1)) {
					screen.setText(screen.getText() + "0");
				}else{
					screen.setText(screen.getText() + " 0");
				}
			}
		});
		zero.setBounds(70, 246, 50, 30);
		zero.setMnemonic(KeyEvent.VK_NUMPAD0);
		frame.getContentPane().add(zero);
		
		JButton dot = new JButton(".");
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Character.isDigit(screen.getText().charAt(screen.getText().length() - 1))) {
					screen.setText(screen.getText() + ".");
				}
			}
		});
		dot.setBounds(130, 246, 50, 30);
		dot.setMnemonic(KeyEvent.VK_DECIMAL);
		frame.getContentPane().add(dot);
		
		result = new JTextField();
		result.setFont(new Font("Tahoma", Font.PLAIN, 14));
		result.setText(" ");
		result.setEditable(false);
		result.setColumns(10);
		result.setBounds(10, 35, 230, 35);
		frame.getContentPane().add(result);
	}
}
