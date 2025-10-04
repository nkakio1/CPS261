/*
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
 

*/
package application; // ← keep your package

import java.lang.management.ManagementFactory;   // requires java.management (if modular)
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

  @Override public void start(Stage stage) {

    // ---- Debug prints: what's the JVM really using? ----
    try {
      System.out.println("VM args -> " + ManagementFactory.getRuntimeMXBean().getInputArguments());
    } catch (Throwable t) {
      // If java.management isn't available, at least don’t crash
      System.out.println("Could not read VM args via ManagementFactory: " + t);
    }

    System.out.println("java.version = " + System.getProperty("java.version"));
    System.out.println("java.home    = " + System.getProperty("java.home"));
    System.out.println("os.arch      = " + System.getProperty("os.arch"));

    // List any loaded JavaFX modules so you know they’re present
    ModuleLayer.boot().modules().stream()
        .map(Module::getName)
        .filter(n -> n.startsWith("javafx"))
        .sorted()
        .forEach(n -> System.out.println("FOUND module: " + n));

    // ---- Normal UI ----
    StackPane root = new StackPane(new Label("JavaFX is visible ✅"));
    Scene scene = new Scene(root, 500, 300); // explicit size
    stage.setTitle("HelloFX");
    stage.setScene(scene);
    stage.setX(100); stage.setY(100);        // avoid off-screen placement
    stage.centerOnScreen();                  // belt-and-suspenders
    stage.show();
    stage.toFront();
  }

  public static void main(String[] args) { launch(args); }
}

