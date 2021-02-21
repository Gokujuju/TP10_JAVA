package tp10.ecole;

import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonManipulation {
    private JSONObject school;
    private String filePath = "./output.json";

    public JsonManipulation(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))){
            JSONTokener token = new JSONTokener(reader);
            this.school = new JSONObject(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getSchool() {
        return school;
    }

}
