package edu.ucsb.cs56.projects.utilities.calculator;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keypad extends JComponent implements KeyListener{

	private Calculator calculator;
	

	public Keypad(Calculator calc){
		super();

		calculator = calc;
		setFocusable(true);
		addKeyListener(this);
		this.setLayout(new GridLayout(0,4));

		makeButton("Clear");
		makeButton("");
		makeButton("");
		makeButton("Delete");
		makeButton("7");
		makeButton("8");
		makeButton("9");
		makeButton("/");
		makeButton("4");
		makeButton("5");
		makeButton("6");
		makeButton("*");
		makeButton("1");
		makeButton("2");
		makeButton("3");
		makeButton("-");
		makeButton("0");
		makeButton(".");
		makeButton("Enter");
		makeButton("+");


	}

	private void makeButton(String s){
		JButton jb = new JButton(s);
		jb.addActionListener(new ButtonListener(s));
		this.add(jb);
	}
	private void resetFocus(){
		setFocusable(true);
		requestFocusInWindow();
	}
   class ButtonListener implements ActionListener{
	private String num;

	public ButtonListener(String s) {
	    super();  // is this line necessary? what does it do?
	    this.num = s;

	}

	public void actionPerformed (ActionEvent event) {
		calculator.append(num);
		resetFocus();
		
	}


    }

    @Override
    public void keyReleased(KeyEvent ke){}
    @Override
    public void keyTyped(KeyEvent ke){}
    @Override
    public void keyPressed(KeyEvent ke){
	String key = java.awt.event.KeyEvent.getKeyText(ke.getKeyCode());
	char k = ke.getKeyChar();
	if((k >= '0' && k <= '9') || k == '+' || k == '-' || k == '*' || k == '/' || k == '.')
		calculator.append("" + k);
	else if(k == 'c' || k == 'C')
		calculator.append("Clear");
	else if(key.equals("Enter") || key.equals("Equals"))
		calculator.append("Enter");
	else if(key.equals("NumPad +"))
		calculator.append("+");
	else if(key.equals("NumPad -"))
		calculator.append("-");
	else if(key.equals("NumPad *"))
		calculator.append("*");
	else if(key.equals("NumPad /"))
		calculator.append("/");
	else if(key.equals("Backspace"))
		calculator.append("Delete");
    }
    

}
