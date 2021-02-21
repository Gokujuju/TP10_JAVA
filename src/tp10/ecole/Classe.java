package tp10.ecole;

import java.util.ArrayList;

public class Classe {
    private short chiffre;
    private char lettre;
    private ArrayList<Eleve> listeEleve = new ArrayList<Eleve>();

    public Classe(short c, char l){
        this.chiffre = c;
        this.lettre = l;
        createListeEleve();
    }

    private void createListeEleve(){
        for(short i = 0; i < 20; i++){
            this.listeEleve.add(new Eleve(this.chiffre, this.lettre));
        }
    }

    public short getChiffre() {
        return chiffre;
    }

    public char getLettre() {
        return lettre;
    }

    public ArrayList<Eleve> getListeEleve() {
        return listeEleve;
    }
}
