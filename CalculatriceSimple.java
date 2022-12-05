
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;

class Calculatrice extends JPanel implements ActionListener {
	private JTextField Nombre1, Nombre2, Resultat;
	JButton Somme, Produit; 
	Calculatrice(  ) {
		GridLayout disposition = new GridLayout( 4 , 2 );
		this.setLayout(disposition);
		JLabel L1 = new JLabel ("Nombre 1:  "); Nombre1 = new JTextField( 15);
		JLabel L2 = new JLabel ("Nombre 2:  "); Nombre2 = new JTextField( 15);
		JLabel R = new JLabel ("Résultat:  ");  Resultat = new JTextField( 15); Resultat.setEditable(false);
		Somme = new JButton( "Somme"); Produit = new JButton( "Produit"); 
		this.add(L1); this.add( Nombre1 );
		this.add(L2); this.add( Nombre2 );
		this.add(R); this.add( Resultat );
		this.add(Somme); this.add(Produit);	
		Somme.addActionListener(this);  Produit.addActionListener(this);
	}
	
	public double getNombre1(  ) {   return( Double.parseDouble( Nombre1.getText() ) ) ; }
	public double getNombre2(  ) {   return( Double.parseDouble( Nombre2.getText() ) ); }
	public void setResultat(  String str) {  Resultat.setText(str); }
	
	public void actionPerformed( ActionEvent e ) {
		double n1, n2;
		Double D1;
		String str;
		Object Source = e.getSource(); // Le bouton qui a généré l'évement
		D1 = Double.valueOf( Nombre1.getText() );
		n1 = D1.doubleValue();
		// n1 =  Double.valueOf( Nombre1.getText()).doubleValue();
		str =  Nombre2.getText();
		n2 = Double.parseDouble(str);
		// n2 =   Double.parseDouble(Nombre2.getText());
		if (Source == Somme ) { Resultat.setText( String.valueOf( n1 + n2) );}
	}
}
public class CalculatriceSimple extends JFrame implements ActionListener {
	private Calculatrice UneCalculatrice; 
	JMenuItem MSomme,  MProduit ,  MQuitter ;

	CalculatriceSimple ( ) {
		UneCalculatrice = new Calculatrice();
		this.getContentPane().add( UneCalculatrice);
		this.setTitle(" Ma première calculatrice en Java" );
		this.setSize(450,150);    // MaCalculatrice.pack( );
		// Barre des menus 	  
	    JMenuBar MenuBar = new JMenuBar(); 
	    this.setJMenuBar(MenuBar);
	    JMenu MCalculatrice = new JMenu("Calculatrice");
	    MenuBar.add( MCalculatrice);
	    MSomme = new JMenuItem("Somme"); 
	    MSomme.setMnemonic( 'o' ); MSomme.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK) );
	    MProduit = new JMenuItem("Produit"); // MProduit.setIcon( new ImageIcon( "icons/new.png" ) );
	    MQuitter = new JMenuItem("Quitter");  MQuitter.setMnemonic('Q');
	    
	    MCalculatrice.add(MSomme); 
	    MCalculatrice.add(MProduit);
	    MCalculatrice.addSeparator();
	    MCalculatrice.add(MQuitter);
	    
	    MSomme.addActionListener(this);
	    MProduit.addActionListener(this);
	    MQuitter.addActionListener(this);
	    
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public  void actionPerformed(ActionEvent e) {
		double v1, v2;
		Object Source = e.getSource(); // Le bouton qui a généré l'évement
		
		v1 =  UneCalculatrice.getNombre1(); 
		v2 =  UneCalculatrice.getNombre2();
		if (Source == MSomme ) {    UneCalculatrice.setResultat( String.valueOf( v1 + v2) );  
		}
		}
		// UneCalculatrice.setResultat(String.valueOf( n1 + n2) );
	
	
	
	public static void main(String[] args) { CalculatriceSimple CS  = new CalculatriceSimple (); }
}	
		
		