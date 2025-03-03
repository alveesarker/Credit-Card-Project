package com.example.midproject;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class CreditCardViewController {
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

    private final List<CreditCard> creditCardList = new ArrayList<>();
    @javafx.fxml.FXML
    private Text averageCreditLimitText;

    @javafx.fxml.FXML
    public void initialize() {
        gatewayCombobox.getItems().addAll("Visa", "MasterCard");
        filteredGatewayCombobox.getItems().addAll("All", "Visa", "MasterCard");
        cardTypeCombobox.getItems().addAll("silver", "gold", "platinum", "titanium");

        cardNumberColumn.setCellValueFactory(new PropertyValueFactory<>("cardNo"));
        gatewayColumn.setCellValueFactory(new PropertyValueFactory<>("gatewayName"));
        holderNameColumn.setCellValueFactory(new PropertyValueFactory<>("holderName"));
        creditLimitColumn.setCellValueFactory(new PropertyValueFactory<>("creditLimit"));
    }


    //CreditCard(String cardNo, String holderName, LocalDate dateOfExpire,
    // String cardType, String gatewayName, float creditLimit)
    @javafx.fxml.FXML
    public void addCardToListButtonOnclick() {
        String cardNumber = cardNumberTextField.getText();
        String gateWay = gatewayCombobox.getValue();
        if (validateCardNumber(cardNumber, gateWay)) {

            creditCardList.add(
                    new CreditCard(
                            cardNumberTextField.getText(),
                            holderNameTextField.getText(),
                            expireDatePicker.getValue(),
                            cardTypeCombobox.getValue(),
                            gatewayCombobox.getValue(),
                            Float.parseFloat(cardLimitTextField.getText())
                    )
            );
        }
    }

    @javafx.fxml.FXML
    public void searchAndLoadTableOnAction() {
        cardTableView.getItems().clear(); // Clear previous data
        String gateWay = filteredGatewayCombobox.getValue();
        float minLimit = Float.parseFloat(filteredCardLimitTextField.getText());


        // Manually add each CreditCard to the TableView
        if (gateWay.equals("All")) {
            for (CreditCard card : creditCardList) {
                if (minLimit <= card.getCreditLimit()) {
                    cardTableView.getItems().add(card);
                }
            }
        } else {
            for (CreditCard card : creditCardList) {
                if (gateWay.equals(card.getGatewayName()) && minLimit <= card.getCreditLimit()) {
                    cardTableView.getItems().add(card);
                }
            }
        }
    }

    private boolean validateCardNumber(String cardNo, String gateWay) {
        if (cardNo == null || cardNo.length() != 16) {
            showAlert("Invalid card number! Card number must contains 16 digits.");
            return false;
        }

        if ((gateWay.equals("Visa") && !cardNo.startsWith("4")) || (gateWay.equals("MasterCard") && !cardNo.startsWith("5"))) {
            showAlert("Invalid card number!");
            return false;
        }

        return true;
    }

    @javafx.fxml.FXML
    public void CreditAverageAndLoadTableOnAction() {
        List<CreditCard> tableViewItems = cardTableView.getItems();
        float total = 0;
        for (CreditCard c : tableViewItems) {
            total += c.getCreditLimit();
        }
        float average = total / tableViewItems.size();
        String totalString = Float.toString(average);
        averageCreditLimitText.setText(totalString);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

