package com.barcode.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.barcode.app.services.ProviderService;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class BarCodeApplication extends Application {

	@Autowired
	ProviderService serviceProvider;

	public static ConfigurableApplicationContext appContext;
	public static Parent root;
	public static Stage stage;

	public static void main(String[] args) {
		// SpringApplication.run(BarCodeApplication.class, args);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			appContext = SpringApplication.run(BarCodeApplication.class);
			FXMLLoader loader = new FXMLLoader(BarCodeApplication.class.getResource("Sample.fxml"));
			loader.setControllerFactory(appContext::getBean);
			Scene scene = new Scene(loader.load(), 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
