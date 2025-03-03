package com.example.midproject;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CreditCardViewController
{
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> gatewayColumn;
    @javafx.fxml.FXML
    private TextField cardNumberTextField;
    @javafx.fxml.FXML
    private TableView<CreditCard> cardTableView;
    @javafx.fxml.FXML
    private TextField holderNameTextField;
    @javafx.fxml.FXML
    private DatePicker expireDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> cardNumberColumn;
    @javafx.fxml.FXML
    private TextField cardLimitTextField;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, String> holderNameColumn;
    @javafx.fxml.FXML
    private TableColumn<CreditCard, Float> creditLimitColumn;
    @javafx.fxml.FXML
    private ComboBox<String> cardTypeCombobox;
    @javafx.fxml.FXML
    private ComboBox<String> gatewayCombobox;
    @javafx.fxml.FXML
    private ComboBox<String> filteredGatewayCombobox;
    @javafx.fxml.FXML
    private TextField filteredCardLimitTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addCardToListButtonOnclick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchAndLoadTableOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CreditAverageAndLoadTableOnAction(ActionEvent actionEvent) {
    }
}