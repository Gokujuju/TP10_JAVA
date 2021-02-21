package tp10.ecole;


public class Matiere {

    private final String nom;
    private final short nbrEpreuve;
    private final Boolean option;         //Optionnel ou non

    public Matiere(String n, short nbr, Boolean o){
        this.nom = n;
        this.nbrEpreuve = nbr;
        this.option = o;
    }

    public String getNom() {
        return nom;
    }

    public short getNbrEpreuve() {
        return nbrEpreuve;
    }

    public Boolean getOption() {
        return option;
    }
}
