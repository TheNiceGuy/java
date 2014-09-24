package semaine_4;

import javax.swing.JOptionPane;

public class Cond_6 {
	public static void main(String[] args) {
		final String FORMAT[] = {"###-####", "###-###-####", "(###)###-####", "(###) ###-####"};
		
		String strNumero;
		int i;
		int iFormat;
		
		strNumero = JOptionPane.showInputDialog("Numéro de téléphone:");
		
		//déterminer le format utilisé
		iFormat = 0;
		switch(strNumero.length()) {
			case  8:
				iFormat = 0; break;
			case 12:
				iFormat = 1; break;
			case 13:
				iFormat = 2; break;
			case 14:
				iFormat = 3; break;
			default:
				JOptionPane.showMessageDialog(null, "NON-VALIDE");
				System.exit(1);
		}
		
		//tester la validité du numéro entré avec le format
		for(i = 0; i<strNumero.length(); i++) {
			//si le format à telle position est un chiffre
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
