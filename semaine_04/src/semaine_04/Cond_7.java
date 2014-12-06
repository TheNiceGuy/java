package semaine_04;

import javax.swing.JOptionPane;

public class Cond_7 {
	public static void main(String[] args) {
		final String FORMAT[] = {"##-#-####", "##-#50-####", "#######", "###50####"};
		
		String strNumero;
		int i, j;
		boolean bValid;
		
		strNumero = JOptionPane.showInputDialog("Numéro de matricule:");
		
		for(i = 0, bValid = false; i<4; i++) {
			//vérifier si la longuer respect celle d'un format
			if(strNumero.length() == FORMAT[i].length())
				for(j = 0; j<strNumero.length(); j++) {
					//System.out.print(FORMAT[i].charAt(j)+" "+strNumero.charAt(j)+" ");
					//tester si un charactère doit être un chiffre
					if(FORMAT[i].charAt(j) == '#') {
						switch(strNumero.charAt(j)) {
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
								bValid = true; break;
							default:
								//sinon, sortir de la boucle
								bValid = false;
								j = strNumero.length(); break;
						}
					//tester si un charactère doit être quelque chose d'autre
					} else if(FORMAT[i].charAt(j) == strNumero.charAt(j)) {
						bValid = true;
					//sinon, sortir de la boucle
					} else {
						bValid = false;
						j = strNumero.length();
					}
					//System.out.print(bValid+"\n");
				}
				//si bValid est true, le numéro est valide et on peut partir
				if(bValid)
					i = strNumero.length();
		}
		
		//afficher la réponse
		if(bValid)
			JOptionPane.showMessageDialog(null, "VALIDE");
		else
			JOptionPane.showMessageDialog(null, "NON-VALIDE");
		System.exit(0);
	}
}
