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
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Der Ratende muss in 8 Versuchen die Folge erraten haben

public class Ratende extends JFrame {
	private Color[] farbe;
	private Color[] rcolor;

	private int runde;
	private int bestätigt;

	private String[] rundeAnzeigeText;
	private JLabel rundeAnzeige;
	private JLabel labelSliderButton;
	private JLabel labelSliderFarbe;
	private JLabel tips1;
	private JLabel tips2;
	private JLabel hilfe1;
	private JLabel hilfe2;
	private JLabel hilfe3;
	private JLabel hilfe4;
	private JLabel hilfe5;
	private JLabel hilfe6;
	private JLabel hilfe7;
	private JLabel hilfe8;
	private JLabel leerraum;

	private JLabel legende;

	private Panel southP;
	private Panel centerP;
	private Panel northP;
	private Panel westP;
	
	private JLabel[] jlabelArray;
	private JButton[] buttonsammler;

	private JButton eins;
	private JButton zwei;
	private JButton drei;
	private JButton vier;
	private JButton fünf;
	private JButton sechs;
	private JButton sieben;
	private JButton acht;
	private JButton neun;
	private JButton zehn;
	private JButton elf;
	private JButton zwölf;
	private JButton dreizehn;
	private JButton vierzehn;
	private JButton fünfzehn;
	private JButton sechzehn;
	private JButton siebzehn;
	private JButton achtzehn;
	private JButton neunzehn;
	private JButton zwanzig;
	private JButton einundzwanzig;
	private JButton zweiundzwanzig;
	private JButton dreiundzwanzig;
	private JButton vierundzwanzig;
	private JButton fünfundzwanzig;
	private JButton sechsundzwanzig;
	private JButton siebenundzwanzig;
	private JButton achtundzwanzig;
	private JButton neunundzwanzig;
	private JButton dreißig;
	private JButton einunddreißig;
	private JButton zweiunddreißig;
	private JButton kontrollButton1;
	private JButton kontrollButton2;
	private JButton kontrollButton3;
	private JButton kontrollButton4;

	private JButton bestätigen;

	private JSlider sliderFarbe;
	private JSlider sliderButton;

	private ChangeListener farbListener;
	private MouseListener bestätigenListener;

	public JButton[] getButtonsammler() {
		return buttonsammler;
	}

	public void setButtonsammler(JButton[] buttonsammler) {
		this.buttonsammler = buttonsammler;
	}
	
	// getter setter
	public JLabel getTips1() {
		return tips1;
	}

	public void setTips1(JLabel tips) {
		this.tips1 = tips;
	}
	public JLabel getTips2() {
		return tips2;
	}

	public void setTips2(JLabel tips) {
		this.tips2 = tips;
	}
	public String[] getRundeAnzeigeText() {
		return rundeAnzeigeText;
	}

	public int getBestätigt() {
		return bestätigt;
	}

	public void setBestätigt(int bestätigt) {
		this.bestätigt = bestätigt;
	}

	public void setRundeAnzeigeText(String[] rundeAnzeigeText) {
		this.rundeAnzeigeText = rundeAnzeigeText;
	}

	public JLabel getRundeAnzeige() {
		return rundeAnzeige;
	}

	public void setRundeAnzeige(JLabel rundeAnzeige) {
		this.rundeAnzeige = rundeAnzeige;
	}

	public Color[] getRcolor() {
		return rcolor;
	}

	public void setRcolor(Color[] rcolor) {
		this.rcolor = rcolor;
	}

	public JLabel[] getJlabelArray() {
		return jlabelArray;
	}

	public void setJlabelArray(JLabel[] jlabelArray) {
		this.jlabelArray = jlabelArray;
	}

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

	// Konstruktor für Codierer
	public Ratende() {
		super("Ratende Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(612, 612);
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
		this.centerP.setBackground(new Color(250, 240, 230));

		this.northP = new Panel();
		this.northP.setBackground(new Color(250, 240, 230));
		
		this.westP = new Panel();
		this.westP.setBackground(new Color(250, 240, 230));
		
		this.farbe = new Color[] { Color.BLACK, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE, Color.GREEN };
		this.rcolor = new Color[4];

		this.eins = new JButton(" ");
		this.zwei = new JButton(" ");
		this.drei = new JButton(" ");
		this.vier = new JButton(" ");
		this.fünf = new JButton(" ");
		this.sechs = new JButton(" ");
		this.sieben = new JButton(" ");
		this.acht = new JButton(" ");
		this.neun = new JButton(" ");
		this.zehn = new JButton(" ");
		this.elf = new JButton(" ");
		this.zwölf = new JButton(" ");
		this.dreizehn = new JButton(" ");
		this.vierzehn = new JButton(" ");
		this.fünfzehn = new JButton(" ");
		this.sechzehn = new JButton(" ");
		this.siebzehn = new JButton(" ");
		this.achtzehn = new JButton(" ");
		this.neunzehn = new JButton(" ");
		this.zwanzig = new JButton(" ");
		this.einundzwanzig = new JButton(" ");
		this.zweiundzwanzig = new JButton(" ");
		this.dreiundzwanzig = new JButton(" ");
		this.vierundzwanzig = new JButton(" ");
		this.fünfundzwanzig = new JButton(" ");
		this.sechsundzwanzig = new JButton(" ");
		this.siebenundzwanzig = new JButton(" ");
		this.achtundzwanzig = new JButton(" ");
		this.neunundzwanzig = new JButton(" ");
		this.dreißig = new JButton(" ");
		this.einunddreißig = new JButton(" ");
		this.zweiunddreißig = new JButton(" ");
		this.kontrollButton1 = new JButton(" ");
		this.kontrollButton2 = new JButton(" ");
		this.kontrollButton3 = new JButton(" ");
		this.kontrollButton4 = new JButton(" ");
		this.bestätigen = new JButton("Bestätigen");

		this.rundeAnzeigeText = new String[] { "Runde 1", "Runde 2", "Runde 3", "Runde 4", "Runde 5", "Runde 6",
				"Runde 7", "Runde 8" };
		this.buttonsammler = new JButton[] { eins, zwei, drei, vier, fünf, sechs, sieben, acht, neun, zehn, elf, zwölf,
				dreizehn, vierzehn, fünfzehn, sechzehn, siebzehn, achtzehn, neunzehn, zwanzig, einundzwanzig,
				zweiundzwanzig, dreiundzwanzig, vierundzwanzig, fünfundzwanzig, sechsundzwanzig, siebenundzwanzig,
				achtundzwanzig, neunundzwanzig, dreißig, einunddreißig, zweiunddreißig, kontrollButton1, kontrollButton2, 
				kontrollButton3, kontrollButton4 };

		this.rundeAnzeige = new JLabel(this.rundeAnzeigeText[0]);
		this.labelSliderButton = new JLabel("Button-Slider");
		this.labelSliderFarbe = new JLabel("Farbe-Slider");
		this.hilfe1 = new JLabel("Runde 1: ");
		this.hilfe2 = new JLabel("Runde 2: ");
		this.hilfe3 = new JLabel("Runde 3: ");
		this.hilfe4 = new JLabel("Runde 4: ");
		this.hilfe5 = new JLabel("Runde 5: ");
		this.hilfe6 = new JLabel("Runde 6: ");
		this.hilfe7 = new JLabel("Runde 7: ");
		this.hilfe8 = new JLabel("Runde 8: ");
		this.leerraum = new JLabel(" ");
		
		this.jlabelArray = new JLabel[] {hilfe1,hilfe2,hilfe3,hilfe4,hilfe5,hilfe6,hilfe7,hilfe8};

		this.legende = new JLabel("Richtige Farbe:  |     Richtige Poition & Farbe:  X");
		
		this.farbListener = new FarbListener();
		this.bestätigenListener = new BestätigenListener();

		this.sliderFarbe = this.erstelleSchieberegler(1, 6);
		this.sliderButton = this.erstelleSchieberegler(1, 4);

	}

	// Innere Klasse für die Slider Listener
	// Listener für den Bestätien Button
	private class BestätigenListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			bestätigen();

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
	private void bestätigen() {

		for (int i = 0; i < 4; i++) {

			this.rcolor[i] = this.buttonsammler[i + (4 * this.runde)].getBackground();
		}

		this.runde++;
		this.bestätigt++;

		System.out.println("Der Ratende hat seine Farbfolge bestätigt!");
	}

	// Listener f[r die Slider
	private class FarbListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			farbe();
		}

	}

	// Methode für den Slider Listener (läuft die Buttons durch und wählt eine
	// Farbe/ für den Anwender ist die Farbe zu der Zahl im Vorfeld nicht
	// bekannt)
	private void farbe() {

		int i = sliderFarbe.getValue() - 1;
		buttonsammler[sliderButton.getValue() - 1 + 4 * this.runde].setBackground(farbe[i]);
	}

	// Übergibt den Komponenten die Listener
	private void registrierelistener() {

		this.sliderFarbe.addChangeListener(this.farbListener);
		this.bestätigen.addMouseListener(this.bestätigenListener);
	}

	// Methode zum Erstellen der Slider
	private JSlider erstelleSchieberegler(int minimum, int maximum) {
		JSlider schieberegler = new JSlider(minimum, maximum);
		schieberegler.setPaintLabels(true);
		schieberegler.setPaintTicks(true);
		schieberegler.setMajorTickSpacing(1);
		return schieberegler;
	}

	// Organisationsmethode für die Komponenten (Darstellung)
	private void ordneKomponentenAn() {
		
		
		
		add(northP, BorderLayout.NORTH);
		northP.add(rundeAnzeige);

		add(southP, BorderLayout.SOUTH);

		southP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);

		southP.add(labelSliderFarbe, c);

		c.gridy = 1;
		southP.add(sliderFarbe, c);

		c.gridy = 0;
		c.gridx = 2;
		southP.add(bestätigen, c);

		c.gridx = 3;
		southP.add(labelSliderButton, c);
		c.gridy = 1;
		southP.add(sliderButton, c);

		c.gridx = 1;
		c.gridy = 0;
		add(centerP, BorderLayout.CENTER);
		
		centerP.setLayout(new GridBagLayout());

		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.HORIZONTAL;
		d.insets = new Insets(4, 4, 4, 4);

		for (int i = 0; i <= buttonsammler.length; i++) {
			
			if (i <= 3) {
				d.gridy = 9;
				
				centerP.add(buttonsammler[i], d);
			}
			

			if (i > 3 && i <= 7) {
				d.gridy = 8;
				centerP.add(buttonsammler[i], d);
			}

			if (i > 7 && i <= 11) {
				d.gridy = 7;
				centerP.add(buttonsammler[i], d);
			}

			if (i > 11 && i <= 15) {
				d.gridy = 6;
				centerP.add(buttonsammler[i], d);
			}

			if (i > 15 && i <= 19) {
				d.gridy = 5;
				centerP.add(buttonsammler[i], d);
			}

			if (i > 19 && i <= 23) {
				d.gridy = 4;
				centerP.add(buttonsammler[i], d);
			}

			if (i > 23 && i <= 27) {
				d.gridy = 3;
				centerP.add(buttonsammler[i], d);
			}

			if (i > 27 && i <= 31) {
				d.gridy = 2;
				centerP.add(buttonsammler[i], d);
			}
			if (i > 31 && i <= 35) {
				d.gridy = 1;
				centerP.add(buttonsammler[i], d);
				buttonsammler[i].setVisible(false);
			}
			
			
			add(westP, BorderLayout.WEST);
			westP.setLayout(new GridBagLayout());
			
		
			
			
			GridBagConstraints f = new GridBagConstraints();
			f.fill = GridBagConstraints.HORIZONTAL;
			f.insets = new Insets(1, 1, 1, 1);
			
			f.gridy = 1;
			f.gridx = 2;
			f.ipady = 17;
			westP.add(legende,f);
			
			f.gridy = 2;
			f.gridx = 0;
			westP.add(hilfe8,f);
			
			f.gridy = 3;
			f.gridx = 0;
			westP.add(hilfe7,f);
			
			f.gridy = 4;
			f.gridx = 0;
			westP.add(hilfe6,f);
			
			f.gridy = 5;
			f.gridx = 0;
			westP.add(hilfe5,f);
			
			f.gridy = 6;
			f.gridx = 0;
			westP.add(hilfe4,f);
			
			f.gridy = 7;
			f.gridx = 0;
			westP.add(hilfe3,f);
			
			f.gridy = 8;
			f.gridx = 0;
			westP.add(hilfe2,f);
			
			f.gridy = 9;
			f.gridx = 0;
			westP.add(hilfe1,f);	
			
			f.gridy = 10;
			f.gridx = 9;
			f.ipady = 20;
			westP.add(leerraum, f);
		}
	}
}