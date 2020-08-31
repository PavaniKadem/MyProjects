package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtDisplay;
	
	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(50, 205, 50));
		frame.setBounds(100, 100, 369, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtDisplay.setBounds(10,11,333,58);
		frame.getContentPane().add(txtDisplay);
		txtDisplay.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 333, 58);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//------------------------------------row1------------------
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Enternumber = txtDisplay.getText() + btn7.getText();
				txtDisplay.setText(Enternumber);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btn7.setBackground(new Color(255, 20, 147));
		btn7.setForeground(Color.WHITE);
		btn7.setBounds(10, 80, 75, 75);
		frame.getContentPane().add(btn7);
		
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Enternumber = txtDisplay.getText() + btn8.getText();
				txtDisplay.setText(Enternumber);
			}
		});
		btn8.setBackground(new Color(184, 134, 11));
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btn8.setForeground(Color.WHITE);
		btn8.setBounds(96, 80, 75, 75);
		frame.getContentPane().add(btn8);
		
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Enternumber = txtDisplay.getText() + btn9.getText();
				txtDisplay.setText(Enternumber);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btn9.setBackground(new Color(50, 205, 50));
		btn9.setForeground(Color.WHITE);
		btn9.setBounds(182, 80, 75, 75);
		frame.getContentPane().add(btn9);
		
		
		JButton btnplus = new JButton("+");
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations="+";
				
			}
		});
		btnplus.setBackground(new Color(255, 0, 0));
		btnplus.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnplus.setForeground(Color.WHITE);
		btnplus.setBounds(268, 80, 75, 75);
		frame.getContentPane().add(btnplus);
		
		
		//------------------------------------row2------------------
				JButton btn4 = new JButton("4");
				btn4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Enternumber = txtDisplay.getText() + btn4.getText();
						txtDisplay.setText(Enternumber);
					}
				});
				btn4.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btn4.setBackground(new Color(0, 0, 255));
				btn4.setForeground(Color.WHITE);
				btn4.setBounds(10, 166, 75, 75);
				frame.getContentPane().add(btn4);
				
				
				JButton btn5 = new JButton("5");
				btn5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Enternumber = txtDisplay.getText() + btn5.getText();
						txtDisplay.setText(Enternumber);
					}
				});
				btn5.setBackground(new Color(250, 128, 114));
				btn5.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btn5.setForeground(Color.WHITE);
				btn5.setBounds(96, 166, 75, 75);
				frame.getContentPane().add(btn5);
				
				
				JButton btn6 = new JButton("6");
				btn6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Enternumber = txtDisplay.getText() + btn6.getText();
						txtDisplay.setText(Enternumber);
					}
				});
				btn6.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btn6.setBackground(new Color(255, 255, 0));
				btn6.setForeground(Color.WHITE);
				btn6.setBounds(182, 166, 75, 75);
				frame.getContentPane().add(btn6);
				
				
				JButton btnsub = new JButton("-");
				btnsub.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						firstnum=Double.parseDouble(txtDisplay.getText());
						txtDisplay.setText("");
						operations="-";
					}
				});
				btnsub.setBackground(new Color(165, 42, 42));
				btnsub.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnsub.setForeground(Color.WHITE);
				btnsub.setBounds(268, 166, 75, 75);
				frame.getContentPane().add(btnsub);
				
				//------------------------------------row3------------------
				JButton btn1 = new JButton("1");
				btn1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Enternumber = txtDisplay.getText() + btn1.getText();
						txtDisplay.setText(Enternumber);
					}
				});
				btn1.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btn1.setBackground(new Color(128, 128, 128));
				btn1.setForeground(Color.WHITE);
				btn1.setBounds(10, 252, 75, 75);
				frame.getContentPane().add(btn1);
				
				
				JButton btn2 = new JButton("2");
				btn2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Enternumber = txtDisplay.getText() + btn2.getText();
						txtDisplay.setText(Enternumber);
					}
				});
				btn2.setBackground(new Color(25, 25, 112));
				btn2.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btn2.setForeground(Color.WHITE);
				btn2.setBounds(96, 252, 75, 75);
				frame.getContentPane().add(btn2);
				
				
				JButton btn3 = new JButton("3");
				btn3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Enternumber = txtDisplay.getText() + btn3.getText();
						txtDisplay.setText(Enternumber);
					}
				});
				btn3.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btn3.setBackground(new Color(255, 140, 0));
				btn3.setForeground(Color.WHITE);
				btn3.setBounds(182, 252, 75, 75);
				frame.getContentPane().add(btn3);
				
				
				JButton btnmul = new JButton("*");
				btnmul.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						firstnum=Double.parseDouble(txtDisplay.getText());
						txtDisplay.setText("");
						operations="*";
					}
				});
				btnmul.setBackground(new Color(139, 0, 139));
				btnmul.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnmul.setForeground(Color.WHITE);
				btnmul.setBounds(268, 252, 75, 75);
				frame.getContentPane().add(btnmul);
				
				
				//------------------------------------row4------------------
				JButton btn0 = new JButton("0");
				btn0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Enternumber = txtDisplay.getText() + btn0.getText();
						txtDisplay.setText(Enternumber);
					}
				});
				btn0.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btn0.setBackground(new Color(199, 21, 133));
				btn0.setForeground(Color.WHITE);
				btn0.setBounds(10, 338, 75, 75);
				frame.getContentPane().add(btn0);
				
				
				JButton btnclr = new JButton("c");
				btn0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						txtDisplay.setText(null);
						
					}
				});
				btnclr.setBackground(new Color(0, 0, 0));
				btnclr.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnclr.setForeground(Color.WHITE);
				btnclr.setBounds(96, 338, 75, 75);
				frame.getContentPane().add(btnclr);
				
				
				JButton btndiv = new JButton("/");
				btndiv.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						firstnum=Double.parseDouble(txtDisplay.getText());
						txtDisplay.setText("");
						operations="/";
					}
				});
				btndiv.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btndiv.setBackground(new Color(173, 255, 47));
				btndiv.setForeground(Color.WHITE);
				btndiv.setBounds(182, 338, 75, 75);
				frame.getContentPane().add(btndiv);
				
				
				JButton btneq = new JButton("=");
				btneq.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    String answer;
					    secondnum=Double.parseDouble(txtDisplay.getText());
					    if(operations=="+")
					    {
					    	result =firstnum+secondnum;
					    	answer =String.format("%.2f",result);
					    	txtDisplay.setText(answer);
					    }
					    else if(operations=="-")
					    {
					    	result =firstnum-secondnum;
					    	answer =String.format("%.2f",result);
					    	txtDisplay.setText(answer);
					    }
					    else if(operations=="*")
					    {
					    	result =firstnum*secondnum;
					    	answer =String.format("%.2f",result);
					    	txtDisplay.setText(answer);
					    }
					    else if(operations=="/")
					    {
					    	result =firstnum/secondnum;
					    	answer =String.format("%.2f",result);
					    	txtDisplay.setText(answer);
					    }
					}
					
				});
				btneq.setBackground(new Color(0, 255, 255));
				btneq.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btneq.setForeground(Color.WHITE);
				btneq.setBounds(268, 338, 75, 75);
				frame.getContentPane().add(btneq);
				
				
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
