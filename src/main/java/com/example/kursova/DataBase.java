package com.example.kursova;

import com.example.kursova.Table.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/auction";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connection;


    public DataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // select
    public <T>ObservableList<T> getAntiques() {
        ObservableList<T> antiques = FXCollections.observableArrayList();
        String sql = "SELECT * FROM antique";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Integer rating = resultSet.getInt("rating");
                Boolean photo = resultSet.getBoolean("photo");
                Integer position_type = resultSet.getInt("position_type");
                Antique antique = new Antique(id, description, status, rating, photo, position_type);
                antiques.add((T)antique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return antiques;
    }

    public <T> ObservableList<T> getPurchasers() {
        ObservableList<T> purchasers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM purchaser";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                Date birthday = resultSet.getDate("birthday");
                Date registration_date = resultSet.getDate("registration_date");
                Purchaser purchaser = new Purchaser(id, full_name, sex, phone, birthday, registration_date);
                purchasers.add((T) purchaser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchasers;
    }

    public <T> ObservableList<T> getTypes() {
        ObservableList<T> types = FXCollections.observableArrayList();
        String sql = "SELECT * FROM type";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String material = resultSet.getString("material");
                int manufacture_year = resultSet.getInt("manufacture_year");
                String style = resultSet.getString("style");
                Type type = new Type(id, material, manufacture_year, style);
                types.add((T) type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    public <T> ObservableList<T> getOrganizers() {
        ObservableList<T> organizers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM organizer";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                Date birthday = resultSet.getDate("birthday");
                Date employment_date = resultSet.getDate("employment_date");
                Date dismissal_date = resultSet.getDate("dismissal_date");
                Organizer organizer = new Organizer(id, full_name, sex, phone, birthday, employment_date, dismissal_date);
                organizers.add((T) organizer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return organizers;
    }

    public <T> ObservableList<T> getReceipts() {
        ObservableList<T> receipts = FXCollections.observableArrayList();
        String sql = "SELECT * FROM receipt";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date date = resultSet.getDate("date");
                int summ = resultSet.getInt("summ");
                int organizer_id = resultSet.getInt("organizer_id");
                Receipt receipt = new Receipt(id, date, summ, organizer_id);
                receipts.add((T) receipt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receipts;
    }

    public <T> ObservableList<T> getLots() {
        ObservableList<T> lots = FXCollections.observableArrayList();
        String sql = "SELECT * FROM lot";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date start_date = resultSet.getDate("start_date");
                int start_cost = resultSet.getInt("start_cost");
                Date end_date = resultSet.getDate("end_date");
                Lot lot = new Lot(id, start_date, start_cost, end_date);
                lots.add((T) lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lots;
    }

    public <T> ObservableList<T> getAntiqueLots() {
        ObservableList<T> antiqueLots = FXCollections.observableArrayList();
        String sql = "SELECT * FROM antique_lot";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date date = resultSet.getDate("date");
                Time time = resultSet.getTime("time");
                int organizer_id = resultSet.getInt("organizer_id");
                int purchaser_id = resultSet.getInt("purchaser_id");
                int lot_id = resultSet.getInt("lot_id");
                int antique_id = resultSet.getInt("antique_id");
                AntiqueLot antiqueLot = new AntiqueLot(id, date, time, organizer_id, purchaser_id, lot_id, antique_id);
                antiqueLots.add((T) antiqueLot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return antiqueLots;
    }


    // UPDATE

    public void updateAntique(Antique antique) {
        String sql = "UPDATE antique SET description = ?, status = ?, rating = ?, photo = ?, position_type = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, antique.getDescription());
            statement.setString(2, antique.getStatus());
            statement.setInt(3, antique.getRating());
            statement.setBoolean(4, antique.isPhoto());
            statement.setInt(5, antique.getPosition_type());
            statement.setInt(6, antique.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateAntiqueLot(AntiqueLot antiqueLot) {
        String sql = "UPDATE antique_lot SET date = ?, time = ?, organizer_id = ?, purchaser_id = ?, lot_id = ?, antique_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(antiqueLot.getDate().getTime()));
            statement.setTime(2, antiqueLot.getTime());
            statement.setInt(3, antiqueLot.getOrganizer_id());
            statement.setInt(4, antiqueLot.getPurchaser_id());
            statement.setInt(5, antiqueLot.getLot_id());
            statement.setInt(6, antiqueLot.getAntique_id());
            statement.setInt(7, antiqueLot.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateLot(Lot lot) {
        String sql = "UPDATE lot SET start_date = ?, start_cost = ?, end_date = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(lot.getStart_date().getTime()));
            statement.setInt(2, lot.getStart_cost());
            statement.setDate(3, new java.sql.Date(lot.getEnd_date().getTime()));
            statement.setInt(4, lot.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateOrganizer(Organizer organizer) {
        String sql = "UPDATE organizer SET full_name = ?, sex = ?, phone = ?, birthday = ?, employment_date = ?, dismissal_date = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, organizer.getFull_name());
            statement.setString(2, organizer.getSex());
            statement.setString(3, organizer.getPhone());
            statement.setDate(4, new java.sql.Date(organizer.getBirthday().getTime()));
            statement.setDate(5, new java.sql.Date(organizer.getEmployment_date().getTime()));
            if (organizer.getDismissal_date() != null) {
                statement.setDate(6, new java.sql.Date(organizer.getDismissal_date().getTime()));
            } else {
                statement.setNull(6, java.sql.Types.DATE);
            }
            statement.setInt(7, organizer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePurchaser(Purchaser purchaser) {
        String sql = "UPDATE purchaser SET full_name = ?, sex = ?, phone = ?, birthday = ?, registration_date = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, purchaser.getFull_name());
            statement.setString(2, purchaser.getSex());
            statement.setString(3, purchaser.getPhone());
            statement.setDate(4, new java.sql.Date(purchaser.getBirthday().getTime()));
            statement.setDate(5, new java.sql.Date(purchaser.getRegistration_date().getTime()));
            statement.setInt(6, purchaser.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateReceipt(Receipt receipt) {
        String sql = "UPDATE receipt SET date = ?, summ = ?, organizer_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(receipt.getDate().getTime()));
            statement.setInt(2, receipt.getSumm());
            statement.setInt(3, receipt.getOrganizer_id());
            statement.setInt(4, receipt.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateType(Type type) {
        String sql = "UPDATE type SET material = ?, manufacture_year = ?, style = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type.getMaterial());
            statement.setInt(2, type.getManufacture_year());
            statement.setString(3, type.getStyle());
            statement.setInt(4, type.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // sql 9 query

    public ObservableList<Lot> getLotsByOrganizerId(int organizerId) {
        String query = "SELECT lot.* " +
                "FROM lot " +
                "JOIN antique_lot ON lot.Id = antique_lot.lot_id " +
                "JOIN organizer ON antique_lot.organizer_id = organizer.Id " +
                "WHERE organizer.Id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, organizerId);
            ResultSet resultSet = statement.executeQuery();

            ObservableList<Lot> lotsList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date startDate = resultSet.getDate("start_date");
                int startCost = resultSet.getInt("start_cost");
                Date endDate = resultSet.getDate("end_date");

                Lot lot = new Lot(id, startDate, startCost, endDate);
                lotsList.add(lot);
            }
            return lotsList;
        } catch (SQLException e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }

    public ObservableList<Purchaser> getPurchasersWithLastNameStartingWithM() {
        ObservableList<Purchaser> purchasersList = FXCollections.observableArrayList();
        String query = "SELECT * FROM purchaser WHERE full_name LIKE 'M%'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                Date birthday = resultSet.getDate("birthday");
                Date registration_date = resultSet.getDate("registration_date");

                Purchaser purchaser = new Purchaser(id, full_name, sex, phone, birthday, registration_date);
                purchasersList.add(purchaser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchasersList;
    }

    public ObservableList<Lot> getLotsWithCostBetween0And2000() {
        ObservableList<Lot> lotsList = FXCollections.observableArrayList();
        String query = "SELECT * FROM lot WHERE start_cost BETWEEN 0 AND 2000";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date start_date = resultSet.getDate("start_date");
                int start_cost = resultSet.getInt("start_cost");
                Date end_date = resultSet.getDate("end_date");

                Lot lot = new Lot(id, start_date, start_cost, end_date);
                lotsList.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lotsList;
    }

    public int getLotCountForLastMonth() {
        int lotCount = 0;
        String query = "SELECT COUNT(*) AS lots_for_the_last_month FROM lot WHERE start_date >= CURDATE() - INTERVAL 1 MONTH";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                lotCount = resultSet.getInt("lots_for_the_last_month");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lotCount;
    }

    public ObservableList<Organizer> getAllOrganizers() {
        ObservableList<Organizer> organizersList = FXCollections.observableArrayList();
        String query = "SELECT * FROM organizer";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String full_name = resultSet.getString("full_name");
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                Date birthday = resultSet.getDate("birthday");
                Date employment_date = resultSet.getDate("employment_date");
                Date dismissal_date = resultSet.getDate("dismissal_date");

                Organizer organizer = new Organizer(id, full_name, sex, phone, birthday, employment_date, dismissal_date);
                organizersList.add(organizer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return organizersList;
    }

    public ObservableList<OrganizerLotData> getLotCountPerOrganizer() {
        ObservableList<OrganizerLotData> lotDataList = FXCollections.observableArrayList();
        String query = "SELECT organizer.full_name, COUNT(*) AS lot_count " +
                "FROM organizer " +
                "JOIN antique_lot ON organizer.Id = antique_lot.organizer_id " +
                "JOIN lot ON antique_lot.lot_id = lot.Id " +
                "GROUP BY organizer.Id";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                int lotCount = resultSet.getInt("lot_count");
                lotDataList.add(new OrganizerLotData(fullName, lotCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lotDataList;
    }

    public ObservableList<AntiquityTypeData> getLeastPopularAntiquityType() {
        ObservableList<AntiquityTypeData> dataList = FXCollections.observableArrayList();

        String query = "SELECT t.material, t.manufacture_year, t.style, COUNT(a.id) AS antiquity_count " +
                "FROM type t " +
                "LEFT JOIN antique a ON t.id = a.position_type " +
                "LEFT JOIN antique_lot al ON a.id = al.antique_id " +
                "GROUP BY t.id " +
                "HAVING COUNT(a.id) = (" +
                "    SELECT MIN(cnt) " +
                "    FROM (" +
                "        SELECT COUNT(a.id) AS cnt " +
                "        FROM type t " +
                "        LEFT JOIN antique a ON t.id = a.position_type " +
                "        LEFT JOIN antique_lot al ON a.id = al.antique_id " +
                "        GROUP BY t.id " +
                "    ) AS subquery" +
                ")";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String material = resultSet.getString("material");
                int manufactureYear = resultSet.getInt("manufacture_year");
                String style = resultSet.getString("style");
                int antiquityCount = resultSet.getInt("antiquity_count");

                dataList.add(new AntiquityTypeData(material, manufactureYear, style, antiquityCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public ObservableList<MostExpensiveLotData> getMostExpensiveLotPerType() {
        ObservableList<MostExpensiveLotData> dataList = FXCollections.observableArrayList();

        String query = "SELECT t.material, t.manufacture_year, t.style, l.id, l.start_cost, l.start_date, l.end_date " +
                "FROM type t " +
                "JOIN antique a ON t.id = a.position_type " +
                "JOIN antique_lot al ON a.id = al.antique_id " +
                "JOIN lot l ON al.lot_id = l.id " +
                "WHERE l.start_cost = (" +
                "    SELECT MAX(l2.start_cost) " +
                "    FROM type t2 " +
                "    JOIN antique a2 ON t2.id = a2.position_type " +
                "    JOIN antique_lot al2 ON a2.id = al2.antique_id " +
                "    JOIN lot l2 ON al2.lot_id = l2.id " +
                "    WHERE t2.id = t.id " +
                ")";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String material = resultSet.getString("material");
                int manufactureYear = resultSet.getInt("manufacture_year");
                String style = resultSet.getString("style");
                int lotId = resultSet.getInt("id");
                int startCost = resultSet.getInt("start_cost");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");

                dataList.add(new MostExpensiveLotData(material, manufactureYear, style, lotId, startCost, startDate, endDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public ObservableList<String> getInactiveBuyers() {
        ObservableList<String> inactiveBuyers = FXCollections.observableArrayList();

        String query = "SELECT purchaser.full_name " +
                "FROM purchaser " +
                "LEFT JOIN antique_lot ON purchaser.id = antique_lot.purchaser_id " +
                "WHERE antique_lot.id IS NULL";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                inactiveBuyers.add(fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inactiveBuyers;
    }

    public ObservableList<String> executeUnionQueryOperation() {
        ObservableList<String> resultData = FXCollections.observableArrayList();

        String query = "(SELECT 'Має максимальну кількість лотів' AS comment, organizer.full_name " +
                "FROM organizer " +
                "JOIN antique_lot ON organizer.id = antique_lot.organizer_id " +
                "GROUP BY organizer.id " +
                "HAVING COUNT(*) = (" +
                "    SELECT MAX(cnt) " +
                "    FROM (" +
                "        SELECT COUNT(*) AS cnt " +
                "        FROM antique_lot " +
                "        GROUP BY organizer_id " +
                "    ) AS subquery" +
                ")) " +
                "UNION " +
                "(SELECT 'Не має жодного лоту' AS comment, organizer.full_name " +
                "FROM organizer " +
                "WHERE organizer.id NOT IN (" +
                "    SELECT organizer_id " +
                "    FROM antique_lot " +
                "))";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String comment = resultSet.getString("comment");
                String fullName = resultSet.getString("full_name");
                resultData.add(comment + ": " + fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultData;
    }

}
