package tp10.ecole;

import org.json.JSONArray;
import org.json.JSONObject;

public class tableauNotes {
    private String nom = null;

    private int nbrMatiere = 8;

    private JSONArray anglais = null;
    private Double anglais1 = null;
    private Double anglais2 = null;
    private Double anglais3 = null;
    private Double moyAnglais = null;

    private JSONArray anglaisAv = null;
    private Double anglaisAv1 = null;
    private Double anglaisAv2 = null;
    private Double anglaisAv3 = null;
    private Double moyAnglaisAv = null;

    private JSONArray langue = null;
    private Double langue1 = null;
    private Double langue2 = null;
    private Double langue3 = null;
    private Double moyLangue = null;

    private JSONArray sport = null;
    private Double sport1 = null;
    private Double sport2 = null;
    private Double moySport = null;

    private JSONArray latin = null;
    private Double latin1 = null;
    private Double latin2 = null;
    private Double latin3 = null;
    private Double moyLatin = null;

    private JSONArray grec = null;
    private Double grec1 = null;
    private Double grec2 = null;
    private Double grec3 = null;
    private Double moyGrec = null;

    private JSONArray mathematique = null;
    private Double mathematique1 = null;
    private Double mathematique2 = null;
    private Double mathematique3 = null;
    private Double moyMathematique = null;

    private JSONArray francais = null;
    private Double francais1 = null;
    private Double francais2 = null;
    private Double francais3 = null;
    private Double moyFrancais = null;

    private JSONArray science = null;
    private Double science1 = null;
    private Double science2 = null;
    private Double science3 = null;
    private Double moyScience = null;

    private JSONArray histoire = null;
    private Double histoire1 = null;
    private Double histoire2 = null;
    private Double histoire3 = null;
    private Double moyHistoire = null;

    private JSONArray physique = null;
    private Double physique1 = null;
    private Double physique2 = null;
    private Double physique3 = null;
    private Double moyPhysique = null;

    private JSONArray art = null;
    private Double art1 = null;
    private Double art2 = null;
    private Double art3 = null;
    private Double moyArt = null;

    private JSONArray musique = null;
    private Double musique1 = null;
    private Double musique2 = null;
    private Double moyMusique = null;

    private Double moyenne = 0.0;

    public tableauNotes(String n, JSONObject notes){
        this.nom = n;
        this.anglais = (JSONArray) notes.get("Anglais");
        this.anglais1 = ((JSONArray) notes.get("Anglais")).getDouble(0);
        this.anglais2 = ((JSONArray) notes.get("Anglais")).getDouble(1);
        this.anglais3 = ((JSONArray) notes.get("Anglais")).getDouble(2);
        this.moyAnglais = Math.round(((this.anglais1+this.anglais2+this.anglais3)/3)*10.0)/10.0;
        this.moyenne += this.moyAnglais;


        if(notes.has("Anglais Avancé")){
            this.anglaisAv = (JSONArray) notes.get("Anglais Avancé");
            this.anglaisAv1 = ((JSONArray) notes.get("Anglais Avancé")).getDouble(0);
            this.anglaisAv2 = ((JSONArray) notes.get("Anglais Avancé")).getDouble(1);
            this.anglaisAv3 = ((JSONArray) notes.get("Anglais Avancé")).getDouble(2);
            this.moyAnglaisAv = Math.round(((this.anglaisAv1+this.anglaisAv2+this.anglaisAv3)/3)*10.0)/10.0;
            this.nbrMatiere += 1;
            this.moyenne += this.moyAnglaisAv;
        }

        if(notes.has("Langue Vivante")){
            this.langue = (JSONArray) notes.get("Langue Vivante");
            this.langue1 = ((JSONArray) notes.get("Langue Vivante")).getDouble(0);
            this.langue2 = ((JSONArray) notes.get("Langue Vivante")).getDouble(1);
            this.langue3 = ((JSONArray) notes.get("Langue Vivante")).getDouble(2);
            this.moyLangue = Math.round(((this.langue1+this.langue2+this.langue3)/3)*10.0)/10.0;
            this.nbrMatiere += 1;
            this.moyenne += this.moyLangue;
        }

        this.sport = (JSONArray) notes.get("Sport");
        this.sport1 = ((JSONArray) notes.get("Sport")).getDouble(0);
        this.sport2 = ((JSONArray) notes.get("Sport")).getDouble(1);
        this.moySport = Math.round(((this.sport1+this.sport2)/2)*10.0)/10.0;
        this.moyenne += this.moySport;

        if(notes.has("Latin")){
            this.latin = (JSONArray) notes.get("Latin");
            this.latin1 = ((JSONArray) notes.get("Latin")).getDouble(0);
            this.latin2 = ((JSONArray) notes.get("Latin")).getDouble(1);
            this.latin3 = ((JSONArray) notes.get("Latin")).getDouble(2);
            this.moyLatin = Math.round(((this.latin1+this.latin2+this.latin3)/3)*10.0)/10.0;
            this.nbrMatiere += 1;
            this.moyenne += this.moyLatin;
        }

        if(notes.has("Grec")){
            this.grec = (JSONArray) notes.get("Grec");
            this.grec1 = ((JSONArray) notes.get("Grec")).getDouble(0);
            this.grec2 = ((JSONArray) notes.get("Grec")).getDouble(1);
            this.grec3 = ((JSONArray) notes.get("Grec")).getDouble(2);
            this.moyGrec = Math.round(((this.grec1+this.grec2+this.grec3)/3)*10.0)/10.0;
            this.nbrMatiere += 1;
            this.moyenne += this.moyGrec;
        }

        this.mathematique = (JSONArray) notes.get("Mathématique");
        this.mathematique1 = ((JSONArray) notes.get("Mathématique")).getDouble(0);
        this.mathematique2 = ((JSONArray) notes.get("Mathématique")).getDouble(1);
        this.mathematique3 = ((JSONArray) notes.get("Mathématique")).getDouble(2);
        this.moyMathematique = Math.round(((this.mathematique1+this.mathematique2+this.mathematique3)/3)*10.0)/10.0;
        this.moyenne += this.moyMathematique;

        this.francais = (JSONArray) notes.get("Français");
        this.francais1 = ((JSONArray) notes.get("Français")).getDouble(0);
        this.francais2 = ((JSONArray) notes.get("Français")).getDouble(1);
        this.francais3 = ((JSONArray) notes.get("Français")).getDouble(2);
        this.moyFrancais = Math.round(((this.francais1+this.francais2+this.francais3)/3)*10.0)/10.0;
        this.moyenne += this.moyFrancais;

        this.science = (JSONArray) notes.get("Sciences Naturelles");
        this.science1 = ((JSONArray) notes.get("Sciences Naturelles")).getDouble(0);
        this.science2 = ((JSONArray) notes.get("Sciences Naturelles")).getDouble(1);
        this.science3 = ((JSONArray) notes.get("Sciences Naturelles")).getDouble(2);
        this.moyScience = Math.round(((this.science1+this.science2+this.science3)/3)*10.0)/10.0;
        this.moyenne += this.moyScience;

        this.histoire = (JSONArray) notes.get("Histoire-Géographique");
        this.histoire1 = ((JSONArray) notes.get("Histoire-Géographique")).getDouble(0);
        this.histoire2 = ((JSONArray) notes.get("Histoire-Géographique")).getDouble(1);
        this.histoire3 = ((JSONArray) notes.get("Histoire-Géographique")).getDouble(2);
        this.moyHistoire = Math.round(((this.histoire1+this.histoire2+this.histoire3)/3)*10.0)/10.0;
        this.moyenne += this.moyHistoire;

        if(notes.has("Physique")){
            this.physique = (JSONArray) notes.get("Physique");
            this.physique1 = ((JSONArray) notes.get("Physique")).getDouble(0);
            this.physique2 = ((JSONArray) notes.get("Physique")).getDouble(1);
            this.physique3 = ((JSONArray) notes.get("Physique")).getDouble(2);
            this.moyPhysique = Math.round(((this.physique1+this.physique2+this.physique3)/3)*10.0)/10.0;
            this.nbrMatiere += 1;
            this.moyenne += this.moyPhysique;
        }

        this.art = (JSONArray) notes.get("Arts");
        this.art1 = ((JSONArray) notes.get("Arts")).getDouble(0);
        this.art2 = ((JSONArray) notes.get("Arts")).getDouble(1);
        this.art3 = ((JSONArray) notes.get("Arts")).getDouble(2);
        this.moyArt = Math.round(((this.art1+this.art2+this.art3)/3)*10.0)/10.0;
        this.moyenne += this.moyArt;

        this.musique = (JSONArray) notes.get("Musique");
        this.musique1 = ((JSONArray) notes.get("Musique")).getDouble(0);
        this.musique2 = ((JSONArray) notes.get("Musique")).getDouble(1);
        this.moyMusique = Math.round(((this.musique1+this.musique2)/2)*10.0)/10.0;
        this.moyenne += this.moyMusique;

        this.moyenne = Math.round((this.moyenne/this.nbrMatiere)*10.0)/10.0;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public JSONArray getAnglais() {
        return anglais;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public void setAnglais(JSONArray anglais) {
        this.anglais = anglais;
    }

    public Double getAnglais1() {
        return anglais1;
    }

    public void setAnglais1(Double anglais1) {
        this.anglais1 = anglais1;
    }

    public Double getAnglais2() {
        return anglais2;
    }

    public void setAnglais2(Double anglais2) {
        this.anglais2 = anglais2;
    }

    public Double getAnglais3() {
        return anglais3;
    }

    public void setAnglais3(Double anglais3) {
        this.anglais3 = anglais3;
    }

    public Double getMoyAnglais() {
        return moyAnglais;
    }

    public void setMoyAnglais(Double moyAnglais) {
        this.moyAnglais = moyAnglais;
    }

    public JSONArray getAnglaisAv() {
        return anglaisAv;
    }

    public void setAnglaisAv(JSONArray anglaisAv) {
        this.anglaisAv = anglaisAv;
    }

    public Double getAnglaisAv1() {
        return anglaisAv1;
    }

    public void setAnglaisAv1(Double anglaisAv1) {
        this.anglaisAv1 = anglaisAv1;
    }

    public Double getAnglaisAv2() {
        return anglaisAv2;
    }

    public void setAnglaisAv2(Double anglaisAv2) {
        this.anglaisAv2 = anglaisAv2;
    }

    public Double getAnglaisAv3() {
        return anglaisAv3;
    }

    public void setAnglaisAv3(Double anglaisAv3) {
        this.anglaisAv3 = anglaisAv3;
    }

    public Double getMoyAnglaisAv() {
        return moyAnglaisAv;
    }

    public void setMoyAnglaisAv(Double moyAnglaisAv) {
        this.moyAnglaisAv = moyAnglaisAv;
    }

    public JSONArray getLangue() {
        return langue;
    }

    public void setLangue(JSONArray langue) {
        this.langue = langue;
    }

    public Double getLangue1() {
        return langue1;
    }

    public void setLangue1(Double langue1) {
        this.langue1 = langue1;
    }

    public Double getLangue2() {
        return langue2;
    }

    public void setLangue2(Double langue2) {
        this.langue2 = langue2;
    }

    public Double getLangue3() {
        return langue3;
    }

    public void setLangue3(Double langue3) {
        this.langue3 = langue3;
    }

    public Double getMoyLangue() {
        return moyLangue;
    }

    public void setMoyLangue(Double moyLangue) {
        this.moyLangue = moyLangue;
    }

    public JSONArray getSport() {
        return sport;
    }

    public void setSport(JSONArray sport) {
        this.sport = sport;
    }

    public Double getSport1() {
        return sport1;
    }

    public void setSport1(Double sport1) {
        this.sport1 = sport1;
    }

    public Double getSport2() {
        return sport2;
    }

    public void setSport2(Double sport2) {
        this.sport2 = sport2;
    }

    public Double getMoySport() {
        return moySport;
    }

    public void setMoySport(Double moySport) {
        this.moySport = moySport;
    }

    public JSONArray getLatin() {
        return latin;
    }

    public void setLatin(JSONArray latin) {
        this.latin = latin;
    }

    public Double getLatin1() {
        return latin1;
    }

    public void setLatin1(Double latin1) {
        this.latin1 = latin1;
    }

    public Double getLatin2() {
        return latin2;
    }

    public void setLatin2(Double latin2) {
        this.latin2 = latin2;
    }

    public Double getLatin3() {
        return latin3;
    }

    public void setLatin3(Double latin3) {
        this.latin3 = latin3;
    }

    public Double getMoyLatin() {
        return moyLatin;
    }

    public void setMoyLatin(Double moyLatin) {
        this.moyLatin = moyLatin;
    }

    public JSONArray getGrec() {
        return grec;
    }

    public void setGrec(JSONArray grec) {
        this.grec = grec;
    }

    public Double getGrec1() {
        return grec1;
    }

    public void setGrec1(Double grec1) {
        this.grec1 = grec1;
    }

    public Double getGrec2() {
        return grec2;
    }

    public void setGrec2(Double grec2) {
        this.grec2 = grec2;
    }

    public Double getGrec3() {
        return grec3;
    }

    public void setGrec3(Double grec3) {
        this.grec3 = grec3;
    }

    public Double getMoyGrec() {
        return moyGrec;
    }

    public void setMoyGrec(Double moyGrec) {
        this.moyGrec = moyGrec;
    }

    public JSONArray getMathematique() {
        return mathematique;
    }

    public void setMathematique(JSONArray mathematique) {
        this.mathematique = mathematique;
    }

    public Double getMathematique1() {
        return mathematique1;
    }

    public void setMathematique1(Double mathematique1) {
        this.mathematique1 = mathematique1;
    }

    public Double getMathematique2() {
        return mathematique2;
    }

    public void setMathematique2(Double mathematique2) {
        this.mathematique2 = mathematique2;
    }

    public Double getMathematique3() {
        return mathematique3;
    }

    public void setMathematique3(Double mathematique3) {
        this.mathematique3 = mathematique3;
    }

    public Double getMoyMathematique() {
        return moyMathematique;
    }

    public void setMoyMathematique(Double moyMathematique) {
        this.moyMathematique = moyMathematique;
    }

    public JSONArray getFrancais() {
        return francais;
    }

    public void setFrancais(JSONArray francais) {
        this.francais = francais;
    }

    public Double getFrancais1() {
        return francais1;
    }

    public void setFrancais1(Double francais1) {
        this.francais1 = francais1;
    }

    public Double getFrancais2() {
        return francais2;
    }

    public void setFrancais2(Double francais2) {
        this.francais2 = francais2;
    }

    public Double getFrancais3() {
        return francais3;
    }

    public void setFrancais3(Double francais3) {
        this.francais3 = francais3;
    }

    public Double getMoyFrancais() {
        return moyFrancais;
    }

    public void setMoyFrancais(Double moyFrancais) {
        this.moyFrancais = moyFrancais;
    }

    public JSONArray getScience() {
        return science;
    }

    public void setScience(JSONArray science) {
        this.science = science;
    }

    public Double getScience1() {
        return science1;
    }

    public void setScience1(Double science1) {
        this.science1 = science1;
    }

    public Double getScience2() {
        return science2;
    }

    public void setScience2(Double science2) {
        this.science2 = science2;
    }

    public Double getScience3() {
        return science3;
    }

    public void setScience3(Double science3) {
        this.science3 = science3;
    }

    public Double getMoyScience() {
        return moyScience;
    }

    public void setMoyScience(Double moyScience) {
        this.moyScience = moyScience;
    }

    public JSONArray getHistoire() {
        return histoire;
    }

    public void setHistoire(JSONArray histoire) {
        this.histoire = histoire;
    }

    public Double getHistoire1() {
        return histoire1;
    }

    public void setHistoire1(Double histoire1) {
        this.histoire1 = histoire1;
    }

    public Double getHistoire2() {
        return histoire2;
    }

    public void setHistoire2(Double histoire2) {
        this.histoire2 = histoire2;
    }

    public Double getHistoire3() {
        return histoire3;
    }

    public void setHistoire3(Double histoire3) {
        this.histoire3 = histoire3;
    }

    public Double getMoyHistoire() {
        return moyHistoire;
    }

    public void setMoyHistoire(Double moyHistoire) {
        this.moyHistoire = moyHistoire;
    }

    public JSONArray getPhysique() {
        return physique;
    }

    public void setPhysique(JSONArray physique) {
        this.physique = physique;
    }

    public Double getPhysique1() {
        return physique1;
    }

    public void setPhysique1(Double physique1) {
        this.physique1 = physique1;
    }

    public Double getPhysique2() {
        return physique2;
    }

    public void setPhysique2(Double physique2) {
        this.physique2 = physique2;
    }

    public Double getPhysique3() {
        return physique3;
    }

    public void setPhysique3(Double physique3) {
        this.physique3 = physique3;
    }

    public Double getMoyPhysique() {
        return moyPhysique;
    }

    public void setMoyPhysique(Double moyPhysique) {
        this.moyPhysique = moyPhysique;
    }

    public JSONArray getArt() {
        return art;
    }

    public void setArt(JSONArray art) {
        this.art = art;
    }

    public Double getArt1() {
        return art1;
    }

    public void setArt1(Double art1) {
        this.art1 = art1;
    }

    public Double getArt2() {
        return art2;
    }

    public void setArt2(Double art2) {
        this.art2 = art2;
    }

    public Double getArt3() {
        return art3;
    }

    public void setArt3(Double art3) {
        this.art3 = art3;
    }

    public Double getMoyArt() {
        return moyArt;
    }

    public void setMoyArt(Double moyArt) {
        this.moyArt = moyArt;
    }

    public JSONArray getMusique() {
        return musique;
    }

    public void setMusique(JSONArray musique) {
        this.musique = musique;
    }

    public Double getMusique1() {
        return musique1;
    }

    public void setMusique1(Double musique1) {
        this.musique1 = musique1;
    }

    public Double getMusique2() {
        return musique2;
    }

    public void setMusique2(Double musique2) {
        this.musique2 = musique2;
    }

    public Double getMoyMusique() {
        return moyMusique;
    }

    public void setMoyMusique(Double moyMusique) {
        this.moyMusique = moyMusique;
    }
}
