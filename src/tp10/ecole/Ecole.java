package tp10.ecole;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ecole {
    public ArrayList<Classe> classeList = new ArrayList<Classe>();

    public Ecole(){
        for(short i = 6; i != 2; i--){
            for(short j = 65; j != 71; j++){
                classeList.add(new Classe(i, (char) j));
            }
        }
    }

    public void createJsonFile() throws IOException {
        JSONObject classList = new JSONObject();

        for(Classe c : classeList){
            JSONObject studentList = new JSONObject();
            for(Eleve e : c.getListeEleve()){
                studentList.put(e.getName(),e.getBulletin().getNotes());
            }
            classList.put(String.valueOf(c.getChiffre())+c.getLettre(), studentList);

        }

        FileWriter file = new FileWriter("output.json");
        file.write(classList.toString());

        file.close();

        System.out.println("Json success !");
    }
}
