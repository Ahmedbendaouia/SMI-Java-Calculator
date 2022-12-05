
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;

class PanneauAffichage extends JPanel  {
	private JTextField Nombre1, Nombre2, Resultat;
	PanneauAffichage(  ) {
		GridLayout disposition = new GridLayout( 4 , 2 );
		this.setLayout(disposition);
		JLabel L1 = new JLabel ("Nombre 1:  "); Nombre1 = new JTextField( 15);
		JLabel L2 = new JLabel ("Nombre 2:  "); Nombre2 = new JTextField( 15);
		JLabel R = new JLabel ("Résultat:  ");  Resultat = new JTextField( 15); 
		Resultat.setEditable(false);
		this.add(L1); this.add( Nombre1 );
		this.add(L2); this.add( Nombre2 );
		this.add(R); this.add( Resultat );
	}
	public double getNombre1(  ) {   return( Double.parseDouble( Nombre1.getText() ) ) ; }
	public double getNombre2(  ) {   return( Double.parseDouble( Nombre2.getText() ) ); }
	public void setResultat(  String str) {  Resultat.setText(str); }
}

class Ecouteur implements ActionListener {
	private CalculatriceMenusBis SourceEvent;
	Ecouteur( CalculatriceMenusBis sr ) {SourceEvent = sr ;}
	public  void actionPerformed(ActionEvent e) {
		double v1, v2; 
		JMenuItem ItemSource = (JMenuItem)(e.getSource());
		String str = ItemSource.getText();
		
		if (str.equals("Somme") ) {
			v1 =  SourceEvent.getPanneauAffichage( ).getNombre1(); 
			v2 =  SourceEvent.getPanneauAffichage( ).getNombre2();
			SourceEvent.getPanneauAffichage( ).setResultat( String.valueOf( v1 + v2) ); 
		    }
		if (str.equals("Quitter") ) { System.exit( 0 ); }
			
		}
}

public class CalculatriceMenusBis extends JFrame  {
	private PanneauAffichage SaisieAffichage; 
	private JMenuItem MSomme,  MProduit ,  MQuitter ;
	
	CalculatriceMenusBis ( ) {
		SaisieAffichage = new PanneauAffichage();
		this.getContentPane().add( SaisieAffichage);
		this.setTitle(" Ma première calculatrice en Java" );
		this.setSize(450,150);    		 	  
	    JMenuBar MenuBar = new JMenuBar(); 
	    this.setJMenuBar(MenuBar);
	    JMenu MCalculatrice = new JMenu("Calculatrice");
	    MenuBar.add( MCalculatrice);
	    MSomme = new JMenuItem("Somme"); 
	    MSomme.setMnemonic( 'o' ); MSomme.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK) );
	    MProduit = new JMenuItem("Produit");  MProduit.setMnemonic('P');
	    MQuitter = new JMenuItem("Quitter");  MQuitter.setMnemonic('Q');
	    MCalculatrice.add(MSomme); 
	    MCalculatrice.add(MProduit);
	    MCalculatrice.addSeparator();
	    MCalculatrice.add(MQuitter);
	    
	    MSomme.addActionListener(new Ecouteur( this ) );
	    MProduit.addActionListener( new Ecouteur( this ) );
	    MQuitter.addActionListener(new Ecouteur( this ) );
	    
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
    public PanneauAffichage getPanneauAffichage( ) { return( SaisieAffichage ) ;}
	public static void main(String[] args) { CalculatriceMenusBis CMBis  = new CalculatriceMenusBis (); }
}	