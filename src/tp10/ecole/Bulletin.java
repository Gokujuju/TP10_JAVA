package tp10.ecole;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;


public class Bulletin {
    private final ArrayList<Matiere> listeMatiere = new ArrayList<Matiere>();
    private final TreeMap<String, ArrayList<Double>> notes = new TreeMap<String, ArrayList<Double>>();
    private double moyenneGeneral;

    public Bulletin(short c){
        createBulletin(c);
    }

    private void createBulletin(short c){
        createListeMatiere(c);
        addNotes();                                     //Notes généré aléatoirement avec clé - valeur (Nom Matière - Tableau de notes)
        this.moyenneGeneral = createMoyenneGeneral();
    }

    private void createListeMatiere(short c){
        String[] names = {"Mathématique", "Français", "Anglais", "Histoire-Géographique", "Physique", "Sciences Naturelles", "Arts", "Musique", "Sport", "Langue Vivante"};
        String[] options = {"Latin", "Grec", "Anglais Avancé"};

        Faker faker = new Faker();

        for(String n : names){
            short nbrEpreuve = 3;

            if(n.equals("Sport") || n.equals("Musique")){
                nbrEpreuve = 2;
            }

            if(!(c == 6 && (n.equals("Langue Vivante") || n.equals("Physique")))){      // Langue vivant ou Physique ne démarre que en 5 ème
                this.listeMatiere.add(new Matiere(n, nbrEpreuve, false));
            }

        }

        int nbrOpt = faker.random().nextInt(0,2);

        if(nbrOpt == 2){
            this.listeMatiere.add(new Matiere(options[2], (short) 3, true));
            int randomMatiere = faker.random().nextInt(0,2);
            this.listeMatiere.add(new Matiere(options[randomMatiere], (short) 3, true));        // Latin ou Grec

        }else if (nbrOpt == 1){
            this.listeMatiere.add(new Matiere(options[faker.random().nextInt(0,2)], (short) 3, true));
        }

    }

    private void addNotes(){
        for(Matiere m : this.listeMatiere){

            this.notes.put(m.getNom(),randomNotes(m.getNbrEpreuve()));
        }
    }

    private ArrayList<Double> randomNotes(short n){
        ArrayList<Double> notes = new ArrayList<Double>();
        double randomNote;
        for(short i = 0; i < n; i++){
            Faker faker = new Faker(new Locale("fr"));
            randomNote = faker.number().randomDouble(2, 0, 20);
            notes.add(randomNote);
        }
        return notes;
    }

    private double createMoyenneGeneral(){
        double somme = 0;
        double sommeOpt = 0;
        int nbrNotes= 0;


        for(Map.Entry<String, ArrayList<Double>> entry : this.notes.entrySet()){
            String nom = entry.getKey();
            ArrayList<Double> listeNotes = entry.getValue();
            if(nom.equals("Latin") || nom.equals("Grec") || nom.equals("Anglais Avancé")){
                double moyenneOpt = 0;

                for(double n : listeNotes){
                    moyenneOpt += n;
                }
                moyenneOpt = moyenneOpt-10;
                if(moyenneOpt > 10){
                    moyenneOpt = moyenneOpt/10;
                }
                sommeOpt += moyenneOpt;            // TODO: réduire les décimals à 0.1
            }
            else{
                for(double v : listeNotes){
                    somme += v;
                    nbrNotes++;
                }
            }
        }
        somme = somme/nbrNotes;

        return somme+sommeOpt;
    }

    public TreeMap<String, ArrayList<Double>> getNotes() {
        return notes;
    }

    public ArrayList<Matiere> getListeMatiere() {
        return listeMatiere;
    }

    public double getMoyenneGeneral() {
        return moyenneGeneral;
    }
}
