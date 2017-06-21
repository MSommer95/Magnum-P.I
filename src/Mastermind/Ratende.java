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

	private Panel southP;
	private Panel centerP;
	private Panel northP;
	private Panel westP;
	
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

		this.eins = new JButton("1");
		this.zwei = new JButton("2");
		this.drei = new JButton("3");
		this.vier = new JButton("4");
		this.fünf = new JButton("5");
		this.sechs = new JButton("6");
		this.sieben = new JButton("7");
		this.acht = new JButton("8");
		this.neun = new JButton("9");
		this.zehn = new JButton("10");
		this.elf = new JButton("11");
		this.zwölf = new JButton("12");
		this.dreizehn = new JButton("13");
		this.vierzehn = new JButton("14");
		this.fünfzehn = new JButton("15");
		this.sechzehn = new JButton("16");
		this.siebzehn = new JButton("17");
		this.achtzehn = new JButton("18");
		this.neunzehn = new JButton("19");
		this.zwanzig = new JButton("20");
		this.einundzwanzig = new JButton("21");
		this.zweiundzwanzig = new JButton("22");
		this.dreiundzwanzig = new JButton("23");
		this.vierundzwanzig = new JButton("24");
		this.fünfundzwanzig = new JButton("25");
		this.sechsundzwanzig = new JButton("26");
		this.siebenundzwanzig = new JButton("27");
		this.achtundzwanzig = new JButton("28");
		this.neunundzwanzig = new JButton("29");
		this.dreißig = new JButton("30");
		this.einunddreißig = new JButton("31");
		this.zweiunddreißig = new JButton("32");
		this.kontrollButton1 = new JButton("");
		this.kontrollButton2 = new JButton("");
		this.kontrollButton3 = new JButton("");
		this.kontrollButton4 = new JButton("");
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
		this.tips1 = new JLabel("Richtige Farbe");
		this.tips2 = new JLabel("Richtige Position & Farbe");
		
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
			f.insets = new Insets(4, 4, 4, 4);
			
			westP.add(tips1,f);
			f.gridy = 1;
			westP.add(tips2,f);
		}
	}

}
