package tp10.ecole;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class Onglets {

    private TableView notesGrid;
    private VBox choosePanel;
    private VBox choosePanelHistogramme;
    private BarChart histogramme;

    public TabPane onglets(){
        TabPane pane = new TabPane();
        pane.getTabs().add(notes());
        pane.getTabs().add(graphiques());
        return pane;
    }

    private Tab notes() {
        Tab Notes = new Tab("Notes");
        Notes.setClosable(false);
        this.choosePanel = choosePanel();
        this.notesGrid = notesGrid();
        HBox notesPanel = new HBox(this.choosePanel, this.notesGrid);
        notesPanel.setSpacing(2);
        notesPanel.setStyle("-fx-background-color: #726c6c");
        notesPanel.setAlignment(Pos.CENTER);
        Notes.setContent(notesPanel);

        return Notes;
    }

    private void refreshNotesList(String c){
        this.notesGrid.getItems().clear();

        JsonManipulation json = new JsonManipulation();
        JSONObject school = json.getSchool();
        JSONObject listEleves = (JSONObject) school.get(c);

        String[] eleves = JSONObject.getNames(listEleves);

        for(String e : eleves){
            this.notesGrid.getItems().add(new tableauNotes(e,(JSONObject) listEleves.get(e)));
        }
    }

    private VBox choosePanel(){

        ObservableList<String> classes = FXCollections.observableArrayList("6A","6B","6C","6D","6E","6F","5A","5B","5C","5D","5E","5F","4A","4B","4C","4D","4E","4F","3A","3B","3C","3D","3E","3F");

        ChoiceBox listClasses = new ChoiceBox(classes);


        Button okButton = new Button("Ok");

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String c = (String) listClasses.getSelectionModel().getSelectedItem();
                if(c != null){
                    refreshNotesList(c);
                }
            }
        });

        VBox vBox = new VBox();
        vBox.setSpacing(30);
        vBox.getChildren().add(listClasses);
        vBox.getChildren().add(okButton);

        vBox.setMaxWidth(Double.MAX_VALUE);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPadding(new Insets(100,110,100,110));
        vBox.setStyle("-fx-background-color: #3e3232");

        return vBox;
    }

    private TableView notesGrid(){
        TableView tableView = new TableView();

        TableColumn<String, String> nom = new TableColumn<>("Nom");
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<String, String> anglais = new TableColumn<>("Anglais");
        TableColumn<String, String> anglais1 = new TableColumn<>("1");
        TableColumn<String, String> anglais2 = new TableColumn<>("2");
        TableColumn<String, String> anglais3 = new TableColumn<>("3");
        TableColumn<String, String> moyAnglais = new TableColumn<>("Moy");

        anglais1.setCellValueFactory(new PropertyValueFactory<>("anglais1"));
        anglais2.setCellValueFactory(new PropertyValueFactory<>("anglais2"));
        anglais3.setCellValueFactory(new PropertyValueFactory<>("anglais3"));
        moyAnglais.setCellValueFactory(new PropertyValueFactory<>("moyAnglais"));

        anglais.getColumns().addAll(anglais1,anglais2,anglais3,moyAnglais);

        TableColumn<String, String> anglaisAv = new TableColumn<>("Anglais Avancé");
        TableColumn<String, String> anglaisAv1 = new TableColumn<>("1");
        TableColumn<String, String> anglaisAv2 = new TableColumn<>("2");
        TableColumn<String, String> anglaisAv3 = new TableColumn<>("3");
        TableColumn<String, String> moyAnglaisAv = new TableColumn<>("Moy");

        anglaisAv1.setCellValueFactory(new PropertyValueFactory<>("anglaisAv1"));
        anglaisAv2.setCellValueFactory(new PropertyValueFactory<>("anglaisAv2"));
        anglaisAv3.setCellValueFactory(new PropertyValueFactory<>("anglaisAv3"));
        moyAnglaisAv.setCellValueFactory(new PropertyValueFactory<>("moyAnglaisAv"));

        anglaisAv.getColumns().addAll(anglaisAv1,anglaisAv2,anglaisAv3,moyAnglaisAv);

        TableColumn<String, String> langue = new TableColumn<>("Langue Vivante");
        TableColumn<String, String> langue1 = new TableColumn<>("1");
        TableColumn<String, String> langue2 = new TableColumn<>("2");
        TableColumn<String, String> langue3 = new TableColumn<>("3");
        TableColumn<String, String> moyLangue = new TableColumn<>("Moy");

        langue1.setCellValueFactory(new PropertyValueFactory<>("langue1"));
        langue2.setCellValueFactory(new PropertyValueFactory<>("langue2"));
        langue3.setCellValueFactory(new PropertyValueFactory<>("langue3"));
        moyLangue.setCellValueFactory(new PropertyValueFactory<>("moyLangue"));

        langue.getColumns().addAll(langue1,langue2,langue3,moyLangue);

        TableColumn<String, String> sport = new TableColumn<>("Sport");
        TableColumn<String, String> sport1 = new TableColumn<>("1");
        TableColumn<String, String> sport2 = new TableColumn<>("2");
        TableColumn<String, String> moySport = new TableColumn<>("Moy");

        sport1.setCellValueFactory(new PropertyValueFactory<>("sport1"));
        sport2.setCellValueFactory(new PropertyValueFactory<>("sport2"));
        moySport.setCellValueFactory(new PropertyValueFactory<>("moySport"));

        sport.getColumns().addAll(sport1,sport2,moySport);

        TableColumn<String, String> latin = new TableColumn<>("Latin");
        TableColumn<String, String> latin1 = new TableColumn<>("1");
        TableColumn<String, String> latin2 = new TableColumn<>("2");
        TableColumn<String, String> latin3 = new TableColumn<>("3");
        TableColumn<String, String> moyLatin = new TableColumn<>("Moy");

        latin1.setCellValueFactory(new PropertyValueFactory<>("latin1"));
        latin2.setCellValueFactory(new PropertyValueFactory<>("latin2"));
        latin3.setCellValueFactory(new PropertyValueFactory<>("latin3"));
        moyLatin.setCellValueFactory(new PropertyValueFactory<>("moyLatin"));

        latin.getColumns().addAll(latin1,latin2,latin3,moyLatin);

        TableColumn<String, String> grec = new TableColumn<>("Grec");
        TableColumn<String, String> grec1 = new TableColumn<>("1");
        TableColumn<String, String> grec2 = new TableColumn<>("2");
        TableColumn<String, String> grec3 = new TableColumn<>("3");
        TableColumn<String, String> moyGrec = new TableColumn<>("Moy");

        grec1.setCellValueFactory(new PropertyValueFactory<>("grec1"));
        grec2.setCellValueFactory(new PropertyValueFactory<>("grec2"));
        grec3.setCellValueFactory(new PropertyValueFactory<>("grec3"));
        moyGrec.setCellValueFactory(new PropertyValueFactory<>("moyGrec"));

        grec.getColumns().addAll(grec1,grec2,grec3,moyGrec);

        TableColumn<String, String> mathematique = new TableColumn<>("Mathématique");
        TableColumn<String, String> mathematique1 = new TableColumn<>("1");
        TableColumn<String, String> mathematique2 = new TableColumn<>("2");
        TableColumn<String, String> mathematique3 = new TableColumn<>("3");
        TableColumn<String, String> moyMathematique = new TableColumn<>("Moy");

        mathematique1.setCellValueFactory(new PropertyValueFactory<>("mathematique1"));
        mathematique2.setCellValueFactory(new PropertyValueFactory<>("mathematique2"));
        mathematique3.setCellValueFactory(new PropertyValueFactory<>("mathematique3"));
        moyMathematique.setCellValueFactory(new PropertyValueFactory<>("moyMathematique"));

        mathematique.getColumns().addAll(mathematique1,mathematique2,mathematique3,moyMathematique);

        TableColumn<String, String> francais = new TableColumn<>("Français");
        TableColumn<String, String> francais1 = new TableColumn<>("1");
        TableColumn<String, String> francais2 = new TableColumn<>("2");
        TableColumn<String, String> francais3 = new TableColumn<>("3");
        TableColumn<String, String> moyFrancais = new TableColumn<>("Moy");

        francais1.setCellValueFactory(new PropertyValueFactory<>("francais1"));
        francais2.setCellValueFactory(new PropertyValueFactory<>("francais2"));
        francais3.setCellValueFactory(new PropertyValueFactory<>("francais3"));
        moyFrancais.setCellValueFactory(new PropertyValueFactory<>("moyFrancais"));

        francais.getColumns().addAll(francais1,francais2,francais3,moyFrancais);

        TableColumn<String, String> science = new TableColumn<>("Science Naturel");
        TableColumn<String, String> science1 = new TableColumn<>("1");
        TableColumn<String, String> science2 = new TableColumn<>("2");
        TableColumn<String, String> science3 = new TableColumn<>("3");
        TableColumn<String, String> moyScience = new TableColumn<>("Moy");

        science1.setCellValueFactory(new PropertyValueFactory<>("science1"));
        science2.setCellValueFactory(new PropertyValueFactory<>("science2"));
        science3.setCellValueFactory(new PropertyValueFactory<>("science3"));
        moyScience.setCellValueFactory(new PropertyValueFactory<>("moyScience"));

        science.getColumns().addAll(science1,science2,science3,moyScience);

        TableColumn<String, String> histoire = new TableColumn<>("Hitoire-Géographique");
        TableColumn<String, String> histoire1 = new TableColumn<>("1");
        TableColumn<String, String> histoire2 = new TableColumn<>("2");
        TableColumn<String, String> histoire3 = new TableColumn<>("3");
        TableColumn<String, String> moyHistoire = new TableColumn<>("Moy");

        histoire1.setCellValueFactory(new PropertyValueFactory<>("histoire1"));
        histoire2.setCellValueFactory(new PropertyValueFactory<>("histoire2"));
        histoire3.setCellValueFactory(new PropertyValueFactory<>("histoire3"));
        moyHistoire.setCellValueFactory(new PropertyValueFactory<>("moyHistoire"));

        histoire.getColumns().addAll(histoire1,histoire2,histoire3,moyHistoire);

        TableColumn<String, String> physique = new TableColumn<>("Physique");
        TableColumn<String, String> physique1 = new TableColumn<>("1");
        TableColumn<String, String> physique2 = new TableColumn<>("2");
        TableColumn<String, String> physique3 = new TableColumn<>("3");
        TableColumn<String, String> moyPhysique = new TableColumn<>("Moy");

        physique1.setCellValueFactory(new PropertyValueFactory<>("physique1"));
        physique2.setCellValueFactory(new PropertyValueFactory<>("physique2"));
        physique3.setCellValueFactory(new PropertyValueFactory<>("physique3"));
        moyPhysique.setCellValueFactory(new PropertyValueFactory<>("moyPhysique"));

        physique.getColumns().addAll(physique1,physique2,physique3,moyPhysique);

        TableColumn<String, String> art = new TableColumn<>("Arts");
        TableColumn<String, String> art1 = new TableColumn<>("1");
        TableColumn<String, String> art2 = new TableColumn<>("2");
        TableColumn<String, String> art3 = new TableColumn<>("3");
        TableColumn<String, String> moyArt = new TableColumn<>("Moy");

        art1.setCellValueFactory(new PropertyValueFactory<>("art1"));
        art2.setCellValueFactory(new PropertyValueFactory<>("art2"));
        art3.setCellValueFactory(new PropertyValueFactory<>("art3"));
        moyArt.setCellValueFactory(new PropertyValueFactory<>("moyArt"));

        art.getColumns().addAll(art1,art2,art3,moyArt);

        TableColumn<String, String> musique = new TableColumn<>("Musique");
        TableColumn<String, String> musique1 = new TableColumn<>("1");
        TableColumn<String, String> musique2 = new TableColumn<>("2");
        TableColumn<String, String> moyMusique = new TableColumn<>("Moy");

        musique1.setCellValueFactory(new PropertyValueFactory<>("musique1"));
        musique2.setCellValueFactory(new PropertyValueFactory<>("musique2"));
        moyMusique.setCellValueFactory(new PropertyValueFactory<>("moyMusique"));

        musique.getColumns().addAll(musique1,musique2,moyMusique);

        TableColumn<String, String> moyenne = new TableColumn<>("Moyenne Général");
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));

        tableView.getColumns().addAll(nom,moyenne,anglais,anglaisAv,langue,sport,latin,grec,mathematique,francais,science,histoire,physique,art,musique);

        return tableView;
    }

    private Tab graphiques() {
        Tab Graphiques = new Tab("Graphiques");
        Graphiques.setClosable(false);
        this.histogramme = histogramme();

        this.choosePanelHistogramme = choosePanelHistogramme();
        HBox graphiquePanel = new HBox(this.choosePanelHistogramme, this.histogramme);

        Graphiques.setContent(graphiquePanel);
        return Graphiques;
    }

    private BarChart histogramme(){
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Élèves");

        NumberAxis yAxis = new NumberAxis(0, 20, 1);
        yAxis.setLabel("Moyenne");

        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);

        barChart.setMinWidth(1400);
        barChart.setMinHeight(900);

        return barChart;
    }

    private void refreshHistogramme(String c){
        this.histogramme.getData().clear();

        JsonManipulation json = new JsonManipulation();
        JSONObject school = json.getSchool();
        JSONObject listEleves = (JSONObject) school.get(c);

        String[] eleves = JSONObject.getNames(listEleves);

        XYChart.Series<String, Number> classe = new XYChart.Series<String, Number>();
        classe.setName(c);


        for(String e : eleves){
            tableauNotes notes = new tableauNotes(e,(JSONObject) listEleves.get(e));
            classe.getData().add(new XYChart.Data<String, Number>(e,  notes.getMoyenne()));
        }
        this.histogramme.getData().add(classe);
    }

    private VBox choosePanelHistogramme(){

        ObservableList<String> classes = FXCollections.observableArrayList("6A","6B","6C","6D","6E","6F","5A","5B","5C","5D","5E","5F","4A","4B","4C","4D","4E","4F","3A","3B","3C","3D","3E","3F");

        ChoiceBox listClasses = new ChoiceBox(classes);


        Button okButton = new Button("Ok");

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String c = (String) listClasses.getSelectionModel().getSelectedItem();
                if(c != null){
                    refreshHistogramme(c);
                }
            }
        });

        VBox vBox = new VBox();
        vBox.setSpacing(30);
        vBox.getChildren().add(listClasses);
        vBox.getChildren().add(okButton);

        vBox.setMaxWidth(Double.MAX_VALUE);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPadding(new Insets(100,110,100,110));
        vBox.setStyle("-fx-background-color: #3e3232");

        return vBox;
    }
}
