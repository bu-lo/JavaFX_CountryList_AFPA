package fr.afpa;

import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final double BUTTON_WIDTH = 47.0;
    private static final double BUTTON_HEIGHT = 10.0;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // *** TITLE IN STAGE ***
        stage.setTitle(" COUNTRY SELECTOR");

        // ICON
        Image icon = new Image(getClass().getResourceAsStream("world.png"));
        stage.getIcons().add(icon); // Add icon in stage

        // *** SCENE ***

        // INSTANCIATION

        // labelFormulary
        Label labelFormulary = new Label(" Country List : ");
        labelFormulary.setStyle("-fx-font-weight: bold; -fx-background-color: cornflowerblue");

        // buttons Up / Down
        Button butUpElement = new Button("");
        Button butDownElement = new Button("");

        Image imageUp = new Image(getClass().getResourceAsStream("up.png"));
        ImageView imageUpView = new ImageView(imageUp);
        butUpElement.setGraphic(imageUpView);

        Image imageDown = new Image(getClass().getResourceAsStream("down.png"));
        ImageView imageDownView = new ImageView(imageDown);
        butDownElement.setGraphic(imageDownView);

        setButtonSize(butUpElement);
        setButtonSize(butDownElement);


        // hBoxButtonsUD
        HBox hBoxButtonsUD = new HBox(10);
        hBoxButtonsUD.getChildren().addAll(butUpElement, butDownElement);

        // *** hBoxLabelFormUD labelFormulary + hBoxButtonsUD ***
        HBox hBoxLabelFormUD = new HBox(408);
        hBoxLabelFormUD.getChildren().addAll(labelFormulary, hBoxButtonsUD);

        // observableList<Country>
        ObservableList<Country> comboBoxList = FXCollections.observableArrayList();
        // comboBoxList.add(new Country("Belgium", "BEL"));
        // comboBoxList.add(new Country("England", "GBR"));
        // comboBoxList.add(new Country("France", "FRA"));
        // comboBoxList.add(new Country("Germany", "DEU"));
        // comboBoxList.add(new Country("Italy", "ITA"));
        // comboBoxList.add(new Country("Portugal", "PRT"));
        // comboBoxList.add(new Country("Spain", "ESP"));
        // comboBoxList.add(new Country("Switzerland", "CHE"));

        List<Country> countryList = Country.getCountriesList();
        comboBoxList.addAll(countryList);

        ComboBox<Country> comboBoxCountries = new ComboBox<>(comboBoxList);
        //comboBoxCountries.setPrefWidth(250);

        // ADD LISTENER
        // comboBoxList.addListener(new ListChangeListener<Country>() {
        // @Override
        // public void onChanged(Change<? extends Country> country) {
        // System.out.print("Something changed !");
        // }
        // });

        // moving buttons
        Button addButton = new Button(">");
        Button addAllButton = new Button(">>");
        Button getButton = new Button("<");
        Button getAllButton = new Button("<<");

        setButtonSize(addButton);
        setButtonSize(addAllButton);
        setButtonSize(getButton);
        setButtonSize(getAllButton);

        // vbox 4 buttons
        VBox vBox4buttons = new VBox(10);
        vBox4buttons.getChildren().addAll(addButton, addAllButton, getButton, getAllButton);

        vBox4buttons.setMargin(getButton, new Insets(120, 0, 0, 10));

        vBox4buttons.setMargin(addButton, new Insets(0, 0, 0, 10));
        vBox4buttons.setMargin(addAllButton, new Insets(0, 0, 0, 10));
        vBox4buttons.setMargin(getAllButton, new Insets(0, 0, 0, 10));
        

        // listViewCountries
        ListView<Country> listViewCountries = new ListView<>();

        ScrollPane scrollPane = new ScrollPane(listViewCountries);
        scrollPane.setFitToHeight(true);

        // *** hBoxMiddle = comboBoxCountry + vBox4buttons + listViewCountry ***
        HBox hBoxMiddle = new HBox(10);
        hBoxMiddle.getChildren().addAll(comboBoxCountries, vBox4buttons, listViewCountries);

        // *** quitButton ***
        Button quitButton = new Button("Quit");

        setButtonSize(quitButton);

        // *** vBoxGeneral = hBoxLaberFormUD + hBoxMiddle + quitButton *** //
        VBox vBoxGeneral = new VBox(5);
        vBoxGeneral.getChildren().addAll(hBoxLabelFormUD, hBoxMiddle, quitButton);

        vBoxGeneral.setPadding(new Insets(20, 20, 20, 20));

        vBoxGeneral.setMargin(quitButton, new Insets(10, 0, 0, 552));

        // ACTIONS
        addButton.setOnAction(value -> {
            listViewCountries.getItems().add(comboBoxCountries.getValue());
            comboBoxCountries.getItems().remove(comboBoxCountries.getValue());
        });

        addAllButton.setOnAction(value -> {
            listViewCountries.getItems().addAll(comboBoxCountries.getItems());
            comboBoxCountries.getItems().clear();
        });

        getButton.setOnAction(value -> {
            comboBoxCountries.getItems().add(listViewCountries.getSelectionModel().getSelectedItem());
            listViewCountries.getItems().remove(listViewCountries.getSelectionModel().getSelectedItem());
        });

        getAllButton.setOnAction(value -> {
            comboBoxCountries.getItems().addAll(listViewCountries.getItems());
            listViewCountries.getItems().clear();
        });

        butUpElement.setOnAction(value -> {

        });

        butDownElement.setOnAction(value -> {

        });

        quitButton.setOnAction(value -> {
            Platform.exit();
        });

        // ASSEMBLY
        var scene = new Scene(vBoxGeneral, 635, 355);
        stage.setScene(scene);
        stage.show();
    }

    private void setButtonSize(Button button) {
        button.setPrefWidth(BUTTON_WIDTH);
        button.setPrefHeight(BUTTON_HEIGHT);
    }

}
