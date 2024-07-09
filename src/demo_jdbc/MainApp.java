package demo_jdbc;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import demo_jdbc.models.ConstructorResult;
import demo_jdbc.respositories.ConstructorResultRepository;

public class MainApp extends Application {

    private ConstructorResultRepository constructorResultRepository = new ConstructorResultRepository();
    private TableView<ConstructorResult> tableView = new TableView<>();
    private ObservableList<ConstructorResult> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        ComboBox<Integer> yearComboBox = new ComboBox<>();
        for (int year = 2000; year <= 2016; year++) {
            yearComboBox.getItems().add(year);
        }
        yearComboBox.setOnAction(event -> updateTableView(yearComboBox.getValue()));

        // Configure TableView
        TableColumn<ConstructorResult, String> constructorNameCol = new TableColumn<>("Constructor");
        constructorNameCol.setCellValueFactory(new PropertyValueFactory<>("constructor"));

        TableColumn<ConstructorResult, Integer> winsCol = new TableColumn<>("Wins");
        winsCol.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<ConstructorResult, Integer> totalPointsCol = new TableColumn<>("Total Points");
        totalPointsCol.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<ConstructorResult, Integer> rankCol = new TableColumn<>("Rank");
        rankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));

        tableView.getColumns().add(constructorNameCol);
        tableView.getColumns().add(winsCol);
        tableView.getColumns().add(totalPointsCol);
        tableView.getColumns().add(rankCol);

        tableView.setItems(data);

        VBox vbox = new VBox(yearComboBox, tableView);
        Scene scene = new Scene(vbox, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Constructor Results");
        primaryStage.show();
    }

    private void updateTableView(int year) {
        data.clear();
        data.addAll(constructorResultRepository.getResultByYear(year));
    }

    public static void main(String[] args) {
        launch(args);
    }
}