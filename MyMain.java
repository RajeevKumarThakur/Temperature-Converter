package com.mnr.javafx_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Optional;

public class MyMain extends Application {
    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menubar=createMenu();
        rootNode.getChildren().add(0,menubar);
        Scene scene = new Scene(rootNode, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Toll");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu(){
        //File Menu
        Menu fileMenu =new Menu("File");
        MenuItem newFile=new MenuItem("New");
        newFile.setOnAction(event -> {
            System.out.println("New project is open");
            //more code
        });

        MenuItem quitFile =new MenuItem("Quit");
        quitFile.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        SeparatorMenuItem separator1=new SeparatorMenuItem();

        MenuItem openFile = new MenuItem("Open");
        openFile.setOnAction(event -> {
            System.out.println("X file is got open");
            //more code
        });
        fileMenu.getItems().addAll(newFile,quitFile,separator1,openFile);


        //Help Menu
        Menu helpMenu = new Menu("Help");

        MenuItem about=new MenuItem("About");
        about.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(about);

        //menuBar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    public static void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("MY First Desktop app");
        alertDialog.setHeaderText("Learning javaFX");
        alertDialog.setContentText("I am a beginner,but soon i will become a pro and start developing games.");

        ButtonType yesBut=new ButtonType("Yes");
        ButtonType noBut = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBut,noBut);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
        if(clickedBtn.isPresent() && clickedBtn.get()==yesBut) {
            System.out.println("Yes button clicked");
        } else {
            System.out.println("No button clicked");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
