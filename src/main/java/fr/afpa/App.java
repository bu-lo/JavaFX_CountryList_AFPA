package fr.afpa;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        
        //*** TITLE IN STAGE ***
        stage.setTitle(" COUNTRY LIST / SELECTOR");

        //ICON
        Image icon = new Image(getClass().getResourceAsStream("world.png"));
        stage.getIcons().add(icon); // Add icon in stage


        // *** SCENE ***
       
        //INSTANCIATION

        //labelFormulary
        Label labelFormulary = new Label("Country List");

        //buttons Up / Down
        Button butUpElement = new Button("Up");
        Button butDownElement = new Button("Down");

        //hBoxButtonsUD
        HBox hBoxButtonsUD = new HBox(10);
        hBoxButtonsUD.getChildren().addAll(butUpElement,butDownElement);

        //*** hBox labelFormulary + hBoxButtonsUD // HBOXLABELFORMUD ***
        HBox hBoxlabelFormUD = new HBox(30);
        hBoxlabelFormUD.getChildren().addAll(labelFormulary,hBoxlabelFormUD);

        //observableList<Country>
        ObservableList<Country> comboBoxList = FXCollections.observableArrayList();
        comboBoxList.add(new Country ("Belgium", "BEL"));
        comboBoxList.add(new Country("England", "GBR"));
        comboBoxList.add(new Country("France", "FRA"));
        comboBoxList.add(new Country("Germany", "DEU"));
        comboBoxList.add(new Country("Italy", "ITA"));
        comboBoxList.add(new Country("Portugal", "PRT"));
        comboBoxList.add(new Country("Spain", "ESP"));
        comboBoxList.add(new Country("Switzerland", "CHE"));
        
        ComboBox<Country> comboBoxCountries = new ComboBox<Country>(comboBoxList);

        //moving buttons
        Button addButton = new Button(">");
        Button addAllButton = new Button(">>");
        Button getButton = new Button("<");
        Button getAllButton = new Button("<<");

        //vbox 4 buttons
        VBox vBox4buttons = new VBox(10);
        vBox4buttons.getChildren().addAll(addButton,addAllButton,getButton,getAllButton);

        //listViewCountries
        ListView<Country> listViewCountries = new ListView<>();

        //*** hBoxMiddle = comboBoxCountry + vBox4buttons + listViewCountry ***
        HBox hBoxMiddle = new HBox(10);
        hBoxMiddle.getChildren().addAll(comboBoxCountries,vBox4buttons,listViewCountries);

        //*** quitButton ***
        Button quitButton = new Button("Quit");

        //*** vBoxGeneral = hBoxLaberFormUD + hBoxMiddle + quitButton *** //
        VBox vBoxGeneral = new VBox(5);
        vBoxGeneral.getChildren().addAll(hBoxlabelFormUD,hBoxMiddle,quitButton);

    
        //ASSEMBLY
        var scene = new Scene(new StackPane(vBoxGeneral), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}