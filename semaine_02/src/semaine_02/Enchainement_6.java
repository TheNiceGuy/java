package semaine_02;


import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class Enchainement_6 {
	public static void main(String[] args) {
		final double COUT_PAR_JOURNEE = 55;
		
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		String strNbrJour;
		String strNbrKM;
		String strPrixEssence;
		String strMontantVerse;
		
		int iNbrJour;
		double dNbrKM;
		double dPrixEssence;
		double dMontantVerse;
		double dCoutLocation;
		double dCoutEssence;
		double dTotal;
		
		strNbrJour      = JOptionPane.showInputDialog("Nombre de jours: ");
		strNbrKM        = JOptionPane.showInputDialog("Nombre de km: ");
		strPrixEssence  = JOptionPane.showInputDialog("Prix d'un litre essence: ");
		strMontantVerse = JOptionPane.showInputDialog("Montant versé: ");
		
		iNbrJour      = Integer.parseInt(strNbrJour);
		dNbrKM        = Double.parseDouble(strNbrKM);
		dPrixEssence  = Double.parseDouble(strPrixEssence);
		dMontantVerse = Double.parseDouble(strMontantVerse);
		
		dCoutLocation = COUT_PAR_JOURNEE*iNbrJour;
		dCoutEssence = (dNbrKM*10/150)*dPrixEssence;
		dTotal = dCoutLocation+dCoutEssence;
		
		JOptionPane.showMessageDialog(null, "Coût de location: "+argent.format(dCoutLocation)+"\n"+
		                                    "Montant essence: "+argent.format(dCoutEssence)+"\n"+
		                                    "Montant total facture: "+argent.format(dTotal)+"\n"+
		                                    "\n"+
		                                    "Montant versé: "+argent.format(dMontantVerse)+"\n"+
		                                    "Montant du:"+argent.format(dTotal-dMontantVerse));
		
		System.exit(0);
	}
}