package Mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Der Ratende muss in 8 Versuchen die Folge erraten haben

public class Ratende extends JFrame {
	private Color[] farbe;
	private Color[] rcolor;
	private int runde;

	public Color[] getRcolor() {
		return rcolor;
	}

	public void setRcolor(Color[] rcolor) {
		this.rcolor = rcolor;
	}

	private Panel southP;
	private Panel centerP;
	private Panel northP;
	private JButton[] buttonsammler;

	private JButton eins;
	private JButton zwei;
	private JButton drei;
	private JButton vier;
	private JButton f�nf;
	private JButton sechs;
	private JButton sieben;
	private JButton acht;
	private JButton neun;
	private JButton zehn;
	private JButton elf;
	private JButton zw�lf;
	private JButton dreizehn;
	private JButton vierzehn;
	private JButton f�nfzehn;
	private JButton sechzehn;
	private JButton best�tigen;

	private JSlider sliderFarbe;
	private JSlider sliderButton;

	private ChangeListener farbListener;
	private MouseListener best�tigenListener;

	//getter setter
	public JSlider getSliderFarbe() {
		return sliderFarbe;
	}

	public void setSliderFarbe(JSlider sliderFarbe) {
		this.sliderFarbe = sliderFarbe;
	}

	public JSlider getSliderButton() {
		return sliderButton;
	}

	public void setSliderButton(JSlider sliderButton) {
		this.sliderButton = sliderButton;
	}


	// Konstruktor f�r Codierer
	public Ratende() {
		super("Ratende Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(612, 512);
		this.initialisiereKomponenten();
		this.ordneKomponentenAn();
		this.registrierelistener();
		this.setVisible(true);
	}

	// Initialisiert die Komponenten von Codierer
	private void initialisiereKomponenten() {
		this.runde = 0;
		this.southP = new Panel();
		this.southP.setBackground(new Color(250, 240, 230));

		this.centerP = new Panel();
		this.centerP.setBackground(new Color(150, 0, 150));

		this.northP = new Panel();
		this.northP.setBackground(new Color(150, 0, 190));

		this.farbe = new Color[] { Color.BLACK, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE, Color.GREEN };
		this.rcolor = new Color[4];
		
		this.eins = new JButton("eins");
		this.zwei = new JButton("zwei");
		this.drei = new JButton("drei");
		this.vier = new JButton("vier");
		this.f�nf = new JButton("f�nf");
		this.sechs = new JButton("sechs");
		this.sieben = new JButton("sieben");
		this.acht = new JButton("acht");
		this.neun = new JButton("neun");
		this.zehn = new JButton("zehn");
		this.elf = new JButton("elf");
		this.zw�lf = new JButton("zw�lf");
		this.dreizehn = new JButton("dreizehn");
		this.vierzehn = new JButton("vierzehn");
		this.f�nfzehn = new JButton("f�nfzehn");
		this.sechzehn = new JButton("sechzehn");
		this.best�tigen = new JButton("Best�tigen");

		this.farbListener = new FarbListener();
		this.best�tigenListener = new Best�tigenListener();

		this.sliderFarbe = this.erstelleSchieberegler(1, 6);
		this.sliderButton = this.erstelleSchieberegler(1, 4);

		this.buttonsammler = new JButton[] { eins, zwei, drei, vier, f�nf, sechs, sieben, acht, neun, zehn, elf, zw�lf,
				dreizehn, vierzehn, f�nfzehn, sechzehn };
	}

	// Innere Klasse f�r die Slider Listener
	// Listener f�r den Best�tien Button
	private class Best�tigenListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			best�tigen();

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	// Methode zum Einlesen der Farben
	private void best�tigen() {
		for(int i = 0; i<4;i++){
		this.rcolor[i] = this.buttonsammler[i+(4*this.runde)].getBackground();
		}
		this.runde ++;
	}

	// Listener f[r die Slider
	private class FarbListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			farbe();
		}

	}

	// Methode f�r den Slider Listener (l�uft die Buttons durch und w�hlt eine
	// Farbe/ f�r den Anwender ist die Farbe zu der Zahl im Vorfeld nicht
	// bekannt)
	private void farbe() {
		int i = sliderFarbe.getValue() - 1;
		buttonsammler[sliderButton.getValue() - 1 +4*this.runde].setBackground(farbe[i]);
	}

	// �bergibt den Komponenten die Listener
	private void registrierelistener() {
		this.sliderFarbe.addChangeListener(this.farbListener);
		this.best�tigen.addMouseListener(this.best�tigenListener);
	}

	// Methode zum Erstellen der Slider
	private JSlider erstelleSchieberegler(int minimum, int maximum) {
		JSlider schieberegler = new JSlider(minimum, maximum);
		schieberegler.setPaintLabels(true);
		schieberegler.setPaintTicks(true);
		schieberegler.setMajorTickSpacing(1);
		return schieberegler;
	}

	// Organisationsmethode f�r die Komponenten (Darstellung)
	private void ordneKomponentenAn() {

		southP.add(sliderFarbe);
		southP.add(best�tigen);
		southP.add(sliderButton);

		add(southP, BorderLayout.SOUTH);
		add(northP, BorderLayout.NORTH);

		add(centerP, BorderLayout.CENTER);
		centerP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);

		for (int i = 0; i <= buttonsammler.length; i++) {
			if (i <= 3) {
				c.gridy = 4;
				centerP.add(buttonsammler[i], c);
			}
			if (i > 3 && i <= 7) {
				c.gridy = 3;
				centerP.add(buttonsammler[i], c);
			}
			if (i > 7 && i <= 11) {
				c.gridy = 2;
				centerP.add(buttonsammler[i], c);
			}
			if (i > 11 && i <= 15) {
				c.gridy = 1;
				centerP.add(buttonsammler[i], c);
			}

		}

	}

}
