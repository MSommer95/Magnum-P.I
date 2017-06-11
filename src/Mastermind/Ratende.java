package Mastermind;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

//Der Ratende muss in 8 Versuchen die Folge erraten haben

public class Ratende extends JFrame {
	
	private JButton filler;
	public Ratende(){
		super("Rantede Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(512,512);
		this.initialisiereKomponenten();
		this.ordneKomponentenAn();
	}
	
	
	private void initialisiereKomponenten(){
		this.filler = new JButton("filler");
		this.setVisible(true);
	}
	private void ordneKomponentenAn(){
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5,5,5,5);
		
		c.ipady = 40;
		c.ipadx = 40;
		this.getContentPane().add(filler, c);
		
	}
}
