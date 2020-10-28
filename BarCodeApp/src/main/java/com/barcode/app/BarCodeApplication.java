package com.barcode.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class BarCodeApplication extends Application {

	public static ConfigurableApplicationContext appContext;
	public static Parent root;
	public static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			appContext = SpringApplication.run(getClass());
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
			loader.setControllerFactory(appContext::getBean);
			Scene scene = new Scene(loader.load(), 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
