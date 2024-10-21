package com.example.kursova;

import com.example.kursova.Table.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.*;

import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class auctionController implements Initializable {


    @FXML
    private TableColumn<AntiqueLot, Integer> antique_lot_antique;

    @FXML
    private TableColumn<AntiqueLot, Date> antique_lot_date;

    @FXML
    private TableColumn<AntiqueLot, Integer> antique_lot_id;

    @FXML
    private TableColumn<AntiqueLot, Integer> antique_lot_lot;

    @FXML
    private TableColumn<AntiqueLot, Integer> antique_lot_organizer;

    @FXML
    private TableColumn<AntiqueLot, Time> antique_lot_time;

    @FXML
    private TableColumn<AntiqueLot, Integer> antique_lot_purchaser;

    @FXML
    private TableView<AntiqueLot> antique_lot_table;

    @FXML
    private TableColumn<Antique, String> antique_description;

    @FXML
    private TableColumn<Antique, Integer> antique_id;

    @FXML
    private TableColumn<Antique, Boolean> antique_photo;

    @FXML
    private TableColumn<Antique, Integer> antique_position_type;

    @FXML
    private TableColumn<Antique, Integer> antique_rating;

    @FXML
    private TableColumn<Antique, String> antique_status;

    @FXML
    private TableView<Antique> antique_table;

    @FXML
    private TableColumn<Lot, Date> lots_end_date;

    @FXML
    private TableColumn<Lot, Integer> lots_id;

    @FXML
    private TableColumn<Lot, Integer> lots_start_cost;

    @FXML
    private TableColumn<Lot, Date> lots_start_date;

    @FXML
    private TableView<Lot> lots_table;

    @FXML
    private AnchorPane main_anchor_pain;

    @FXML
    private TableColumn<Organizer, Date> organizer_birthday;

    @FXML
    private TableColumn<Organizer, Date> organizer_dismissal;

    @FXML
    private TableColumn<Organizer, Date> organizer_employment;

    @FXML
    private TableColumn<Organizer, String> organizer_full_name;

    @FXML
    private TableColumn<Organizer, Integer> organizer_id;

    @FXML
    private TableColumn<Organizer, String> organizer_phone;

    @FXML
    private TableColumn<Organizer, String> organizer_sex;

    @FXML
    private TableView<Organizer> organizer_table;

    @FXML
    private TableColumn<Purchaser, Date> purchaser_birthday;

    @FXML
    private TableColumn<Purchaser, String> purchaser_full_name;

    @FXML
    private TableColumn<Purchaser, Integer> purchaser_id;

    @FXML
    private TableColumn<Purchaser, String> purchaser_phone;

    @FXML
    private TableColumn<Purchaser, Date> purchaser_registration_date;

    @FXML
    private TableColumn<Purchaser, String> purchaser_sex;

    @FXML
    private TableView<Purchaser> purchaser_table;

    @FXML
    private TableColumn<Type, Integer> type_id;

    @FXML
    private TableColumn<Type, Integer> type_manufacturer_year;

    @FXML
    private TableColumn<Type, String> type_material;

    @FXML
    private TableColumn<Type, String> type_style;

    @FXML
    private TableView<Type> type_table;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataBase dataBase = new DataBase();

        antique_lot_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        antique_lot_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        antique_lot_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        antique_lot_organizer.setCellValueFactory(new PropertyValueFactory<>("organizer_id"));
        antique_lot_purchaser.setCellValueFactory(new PropertyValueFactory<>("purchaser_id"));
        antique_lot_lot.setCellValueFactory(new PropertyValueFactory<>("lot_id"));
        antique_lot_antique.setCellValueFactory(new PropertyValueFactory<>("antique_id"));

        antique_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        antique_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        antique_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        antique_rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        antique_photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        antique_position_type.setCellValueFactory(new PropertyValueFactory<>("position_type"));

        lots_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        lots_start_date.setCellValueFactory(new PropertyValueFactory<>("start_date"));
        lots_end_date.setCellValueFactory(new PropertyValueFactory<>("end_date"));
        lots_start_cost.setCellValueFactory(new PropertyValueFactory<>("start_cost"));

        organizer_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        organizer_full_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        organizer_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        organizer_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        organizer_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        organizer_employment.setCellValueFactory(new PropertyValueFactory<>("employment_date"));
        organizer_dismissal.setCellValueFactory(new PropertyValueFactory<>("dismissal_date"));

        purchaser_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        purchaser_full_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        purchaser_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        purchaser_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        purchaser_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        purchaser_registration_date.setCellValueFactory(new PropertyValueFactory<>("registration_date"));

        type_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type_material.setCellValueFactory(new PropertyValueFactory<>("material"));
        type_manufacturer_year.setCellValueFactory(new PropertyValueFactory<>("manufacture_year"));
        type_style.setCellValueFactory(new PropertyValueFactory<>("style"));

        antique_lot_table.setItems(dataBase.getAntiqueLots());
        antique_table.setItems(dataBase.getAntiques());
        lots_table.setItems(dataBase.getLots());
        organizer_table.setItems(dataBase.getOrganizers());
        purchaser_table.setItems(dataBase.getPurchasers());
        type_table.setItems(dataBase.getTypes());

        antique_lot_table.setEditable(true);
        antique_table.setEditable(true);
        lots_table.setEditable(true);
        organizer_table.setEditable(true);
        purchaser_table.setEditable(true);
        type_table.setEditable(true);

        antique_lot_antique.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        antique_lot_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        antique_lot_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        antique_lot_lot.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        antique_lot_organizer.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        antique_lot_purchaser.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        antique_description.setCellFactory(TextFieldTableCell.forTableColumn());
        antique_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        antique_photo.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        antique_position_type.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        antique_rating.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        antique_status.setCellFactory(TextFieldTableCell.forTableColumn());

        lots_end_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        lots_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        lots_start_cost.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        lots_start_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));

        organizer_birthday.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        organizer_dismissal.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        organizer_employment.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        organizer_full_name.setCellFactory(TextFieldTableCell.forTableColumn());
        organizer_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        organizer_phone.setCellFactory(TextFieldTableCell.forTableColumn());
        organizer_sex.setCellFactory(TextFieldTableCell.forTableColumn());

        purchaser_birthday.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        purchaser_full_name.setCellFactory(TextFieldTableCell.forTableColumn());
        purchaser_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        purchaser_phone.setCellFactory(TextFieldTableCell.forTableColumn());
        purchaser_registration_date.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        purchaser_sex.setCellFactory(TextFieldTableCell.forTableColumn());

        type_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        type_manufacturer_year.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        type_material.setCellFactory(TextFieldTableCell.forTableColumn());
        type_style.setCellFactory(TextFieldTableCell.forTableColumn());

        antique_lot_antique.setOnEditCommit(event -> updateAntiqueLot(event, "antique_id"));
        antique_lot_date.setOnEditCommit(event -> updateAntiqueLot(event, "date"));
        antique_lot_id.setOnEditCommit(event -> updateAntiqueLot(event, "id"));
        antique_lot_lot.setOnEditCommit(event -> updateAntiqueLot(event, "lot_id"));
        antique_lot_organizer.setOnEditCommit(event -> updateAntiqueLot(event, "organizer_id"));
        antique_lot_purchaser.setOnEditCommit(event -> updateAntiqueLot(event, "purchaser_id"));
        antique_lot_time.setOnEditCommit(event -> updateAntiqueLot(event, "time"));

        antique_description.setOnEditCommit(event -> updateAntique(event, "description"));
        antique_id.setOnEditCommit(event -> updateAntique(event, "id"));
        antique_photo.setOnEditCommit(event -> updateAntique(event, "photo"));
        antique_position_type.setOnEditCommit(event -> updateAntique(event, "position_type"));
        antique_rating.setOnEditCommit(event -> updateAntique(event, "rating"));
        antique_status.setOnEditCommit(event -> updateAntique(event, "status"));

        lots_end_date.setOnEditCommit(event -> updateLot(event, "end_date"));
        lots_id.setOnEditCommit(event -> updateLot(event, "id"));
        lots_start_cost.setOnEditCommit(event -> updateLot(event, "start_cost"));
        lots_start_date.setOnEditCommit(event -> updateLot(event, "start_date"));

        organizer_birthday.setOnEditCommit(event -> updateOrganizer(event, "birthday"));
        organizer_dismissal.setOnEditCommit(event -> updateOrganizer(event, "dismissal_date"));
        organizer_employment.setOnEditCommit(event -> updateOrganizer(event, "employment_date"));
        organizer_full_name.setOnEditCommit(event -> updateOrganizer(event, "full_name"));
        organizer_id.setOnEditCommit(event -> updateOrganizer(event, "id"));
        organizer_phone.setOnEditCommit(event -> updateOrganizer(event, "phone"));
        organizer_sex.setOnEditCommit(event -> updateOrganizer(event, "sex"));

        purchaser_birthday.setOnEditCommit(event -> updatePurchaser(event, "birthday"));
        purchaser_full_name.setOnEditCommit(event -> updatePurchaser(event, "full_name"));
        purchaser_id.setOnEditCommit(event -> updatePurchaser(event, "id"));
        purchaser_phone.setOnEditCommit(event -> updatePurchaser(event, "phone"));
        purchaser_registration_date.setOnEditCommit(event -> updatePurchaser(event, "registration_date"));
        purchaser_sex.setOnEditCommit(event -> updatePurchaser(event, "sex"));

        type_id.setOnEditCommit(event -> updateType(event, "id"));
        type_manufacturer_year.setOnEditCommit(event -> updateType(event, "manufacture_year"));
        type_material.setOnEditCommit(event -> updateType(event, "material"));
        type_style.setOnEditCommit(event -> updateType(event, "style"));

    }

    private <T> void updateAntiqueLot(TableColumn.CellEditEvent<AntiqueLot, T> event, String column) {
        AntiqueLot antiqueLot = event.getRowValue();
        T newValue = event.getNewValue();
        switch (column) {
            case "antique_id":
                antiqueLot.setAntique_id((Integer) newValue);
                break;
            case "date":
                antiqueLot.setDate((Date) newValue);
                break;
            case "id":
                antiqueLot.setId((Integer) newValue);
                break;
            case "lot_id":
                antiqueLot.setLot_id((Integer) newValue);
                break;
            case "organizer_id":
                antiqueLot.setOrganizer_id((Integer) newValue);
                break;
            case "purchaser_id":
                antiqueLot.setPurchaser_id((Integer) newValue);
                break;
            case "time":
                antiqueLot.setTime((Time) newValue);
                break;
        }
        DataBase dataBase = new DataBase();
        dataBase.updateAntiqueLot(antiqueLot);
    }

    private <T> void updateAntique(TableColumn.CellEditEvent<Antique, T> event, String column) {
        Antique antique = event.getRowValue();
        T newValue = event.getNewValue();
        switch (column) {
            case "description":
                antique.setDescription((String) newValue);
                break;
            case "id":
                antique.setId((Integer) newValue);
                break;
            case "photo":
                antique.setPhoto((Boolean) newValue);
                break;
            case "position_type":
                antique.setPosition_type((Integer) newValue);
                break;
            case "rating":
                antique.setRating((Integer) newValue);
                break;
            case "status":
                antique.setStatus((String) newValue);
                break;
        }
        DataBase dataBase = new DataBase();
        dataBase.updateAntique(antique);
    }

    private <T> void updateLot(TableColumn.CellEditEvent<Lot, T> event, String column) {
        Lot lot = event.getRowValue();
        T newValue = event.getNewValue();
        switch (column) {
            case "end_date":
                lot.setEnd_date((Date) newValue);
                break;
            case "id":
                lot.setId((Integer) newValue);
                break;
            case "start_cost":
                lot.setStart_cost((Integer) newValue);
                break;
            case "start_date":
                lot.setStart_date((Date) newValue);
                break;
        }
        DataBase dataBase = new DataBase();
        dataBase.updateLot(lot);
    }

    private <T> void updateOrganizer(TableColumn.CellEditEvent<Organizer, T> event, String column) {
        Organizer organizer = event.getRowValue();
        T newValue = event.getNewValue();
        switch (column) {
            case "birthday":
                organizer.setBirthday((Date) newValue);
                break;
            case "dismissal_date":
                organizer.setDismissal_date((Date) newValue);
                break;
            case "employment_date":
                organizer.setEmployment_date((Date) newValue);
                break;
            case "full_name":
                organizer.setFull_name((String) newValue);
                break;
            case "id":
                organizer.setId((Integer) newValue);
                break;
            case "phone":
                organizer.setPhone((String) newValue);
                break;
            case "sex":
                organizer.setSex((String) newValue);
                break;
        }
        DataBase dataBase = new DataBase();
        dataBase.updateOrganizer(organizer);
    }

    private <T> void updatePurchaser(TableColumn.CellEditEvent<Purchaser, T> event, String column) {
        Purchaser purchaser = event.getRowValue();
        T newValue = event.getNewValue();
        switch (column) {
            case "birthday":
                purchaser.setBirthday((Date) newValue);
                break;
            case "full_name":
                purchaser.setFull_name((String) newValue);
                break;
            case "id":
                purchaser.setId((Integer) newValue);
                break;
            case "phone":
                purchaser.setPhone((String) newValue);
                break;
            case "registration_date":
                purchaser.setRegistration_date((Date) newValue);
                break;
            case "sex":
                purchaser.setSex((String) newValue);
                break;
        }
        DataBase dataBase = new DataBase();
        dataBase.updatePurchaser(purchaser);
    }

    private <T> void updateType(TableColumn.CellEditEvent<Type, T> event, String column) {
        Type type = event.getRowValue();
        T newValue = event.getNewValue();
        switch (column) {
            case "id":
                type.setId((Integer) newValue);
                break;
            case "manufacture_year":
                type.setManufacture_year((Integer) newValue);
                break;
            case "material":
                type.setMaterial((String) newValue);
                break;
            case "style":
                type.setStyle((String) newValue);
                break;
        }
        DataBase dataBase = new DataBase();
        dataBase.updateType(type);
    }

    // Метод для відображення Alert
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void showLotsInformation(ActionEvent actionEvent) {
        DataBase dataBase = new DataBase();
        int organizerId = 1;
        ObservableList<Lot> lots = dataBase.getLotsByOrganizerId(organizerId);

        if (lots.isEmpty()) {
            showAlert("No Lots", "There are no lots organized by organizer with ID " + organizerId);
        } else {
            StringBuilder lotsInfo = new StringBuilder();
            for (Lot lot : lots) {
                lotsInfo.append("Lot ID: ").append(lot.getId())
                        .append("\nStart Date: ").append(lot.getStart_date())
                        .append("\nStart Cost: ").append(lot.getStart_cost())
                        .append("\nEnd Date: ").append(lot.getEnd_date())
                        .append("\n\n");
            }
            showAlert("Lots Organized by Organizer " + organizerId, lotsInfo.toString());
        }
    }

    public void showPurchasersWithLastNameStartingWithM() {
        DataBase dataBase = new DataBase();
        ObservableList<Purchaser> purchasers = dataBase.getPurchasersWithLastNameStartingWithM();
        if (purchasers.isEmpty()) {
            showAlert("No Purchasers", "There are no purchasers with last name starting with 'M'.");
        } else {
            StringBuilder purchasersInfo = new StringBuilder();
            for (Purchaser purchaser : purchasers) {
                purchasersInfo.append("ID: ").append(purchaser.getId())
                        .append("\nFull Name: ").append(purchaser.getFull_name())
                        .append("\nSex: ").append(purchaser.getSex())
                        .append("\nPhone: ").append(purchaser.getPhone())
                        .append("\nBirthday: ").append(purchaser.getBirthday())
                        .append("\nRegistration Date: ").append(purchaser.getRegistration_date())
                        .append("\n\n");
            }
            showAlert("Purchasers with Last Name Starting with 'M'", purchasersInfo.toString());
        }
    }

    public void showLotsWithCostBetween0And2000() {
        DataBase dataBase = new DataBase();
        ObservableList<Lot> lots = dataBase.getLotsWithCostBetween0And2000();
        if (lots.isEmpty()) {
            showAlert("No Lots", "There are no lots with cost between 0 and 2000.");
        } else {
            StringBuilder lotsInfo = new StringBuilder();
            for (Lot lot : lots) {
                lotsInfo.append("ID: ").append(lot.getId())
                        .append("\nStart Date: ").append(lot.getStart_date())
                        .append("\nStart Cost: ").append(lot.getStart_cost())
                        .append("\nEnd Date: ").append(lot.getEnd_date())
                        .append("\n\n");
            }
            showAlert("Lots with Cost Between 0 and 2000", lotsInfo.toString());
        }
    }

    public void showLotCountForLastMonth() {
        DataBase dataBase = new DataBase();
        int lotCount = dataBase.getLotCountForLastMonth();
        String message = "Number of lots listed for the last month: " + lotCount;
        showAlert("Lots Listed for Last Month", message);
    }

    public void showLotCountPerOrganizer() {
        DataBase dataBase = new DataBase();
        ObservableList<OrganizerLotData> lotDataList = dataBase.getLotCountPerOrganizer();

        StringBuilder message = new StringBuilder();
        for (OrganizerLotData lotData : lotDataList) {
            message.append("Organizer: ").append(lotData.getFull_name()).append(", Lots: ").append(lotData.getLot_count()).append("\n");
        }

        showAlert("Lot Count per Organizer", message.toString());
    }

    public void showLeastPopularAntiquityTypeAlert() {
        DataBase dataBase = new DataBase();
        ObservableList<AntiquityTypeData> dataList = dataBase.getLeastPopularAntiquityType();

        StringBuilder message = new StringBuilder();
        for (AntiquityTypeData data : dataList) {
            message.append("Material: ").append(data.getMaterial()).append("\n")
                    .append("Manufacture Year: ").append(data.getManufacture_year()).append("\n")
                    .append("Style: ").append(data.getStyle()).append("\n")
                    .append("Antiquity Count: ").append(data.getAntiquity_count()).append("\n\n");
        }

        showAlert("Least Popular Antiquity Type", message.toString());
    }

    public void showMostExpensiveLotPerTypeAlert() {
        DataBase dataBase = new DataBase();
        ObservableList<MostExpensiveLotData> dataList = dataBase.getMostExpensiveLotPerType();

        StringBuilder message = new StringBuilder();
        for (MostExpensiveLotData data : dataList) {
            message.append("Material: ").append(data.getMaterial()).append("\n")
                    .append("Manufacture Year: ").append(data.getManufacture_year()).append("\n")
                    .append("Style: ").append(data.getStyle()).append("\n")
                    .append("Lot ID: ").append(data.getId()).append("\n")
                    .append("Start Cost: ").append(data.getStart_cost()).append("\n")
                    .append("Start Date: ").append(data.getStart_date()).append("\n")
                    .append("End Date: ").append(data.getEnd_date()).append("\n\n");
        }

        showAlert("Most Expensive Lot per Type", message.toString());
    }

    public void showInactiveBuyersAlert() {
        DataBase dataBase = new DataBase();
        ObservableList<String> inactiveBuyers = dataBase.getInactiveBuyers();

        StringBuilder message = new StringBuilder();
        for (String fullName : inactiveBuyers) {
            message.append("Inactive Buyer: ").append(fullName).append("\n");
        }

        showAlert("Inactive Buyers", message.toString());
    }

    public void showUnionQueryOperationAlert() {
        DataBase dataBase = new DataBase();
        ObservableList<String> resultData = dataBase.executeUnionQueryOperation();

        StringBuilder message = new StringBuilder();
        for (String data : resultData) {
            message.append(data).append("\n");
        }

        showAlert("Union Query Operation Result", message.toString());
    }


}