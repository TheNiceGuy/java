package semaine_4;

import javax.swing.JOptionPane;

public class Cond_7 {
	public static void main(String[] args) {
		final String FORMAT[] = {"###-####", "##########","###-###-####", "(###)###-####", "(###) ###-####"};
		
		String strNumero;
		int i;
		int iFormat;
		
		strNumero = JOptionPane.showInputDialog("Numéro de téléphone:");
		
		//déterminer le format utilisé
		iFormat = 0;
		for(i = 0; i<5; i++) {
			if(strNumero.length() == FORMAT[i].length())
				iFormat = i;
		}
		
		//tester la validité du numéro entré avec le format
		for(i = 0; i<strNumero.length(); i++) {
			//si le charactère doit être un chiffre
			if(FORMAT[iFormat].charAt(i) == '#') {
				switch(strNumero.charAt(i)) {
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
					case '0':
						break;
					default:
						JOptionPane.showMessageDialog(null, "NON-VALIDE");
						System.exit(1);							
				}
			//si le charactère est équivalent à celle du format
			} else if(FORMAT[iFormat].charAt(i) != strNumero.charAt(i)){
				JOptionPane.showMessageDialog(null, "NON-VALIDE");
				System.exit(1);					
			}
		}
		
		//afficher la réponse
		JOptionPane.showMessageDialog(null, "VALIDE");
		System.exit(0);
	}
}
