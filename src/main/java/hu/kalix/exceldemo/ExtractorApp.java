package hu.kalix.exceldemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;


public final class ExtractorApp extends Application {
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Extract Data From Excel Document");
 
        final javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
 
        final Button button = new Button("Choose excel file and extract data");

        button.setOnAction(
                e -> {
                    fileChooser.setInitialDirectory(
                            new File(System.getProperty("user.home"))
                    );

                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        List<String> data = ExcelDataExtractor.extract(file.getPath());

                        System.out.println(data);
                    }
                });
 
        final StackPane pane = new StackPane();
        pane.getChildren().add(button);
        stage.setScene(new Scene(pane));
        stage.setWidth(600);
        stage.setHeight(200);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}