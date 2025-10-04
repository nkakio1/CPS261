module mp3_nakio {
	requires javafx.controls;
	requires java.management;
	requires javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
