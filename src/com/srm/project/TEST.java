package com.srm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TEST {

    private Connection connection;
    private JFrame frame;
    private JTextField firstNameField, lastNameField, ageField, genderField, contactNumberField;
    private JTextArea patientListArea;
    private JButton addButton, viewButton, searchButton;

    public TEST() {
        initializeDatabase();
        createAndShowGUI();
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Pikachu6674@");
            createPatientTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createAndShowGUI() {
        frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(3);
        JLabel genderLabel = new JLabel("Gender:");
        genderField = new JTextField(10);
        JLabel contactNumberLabel = new JLabel("Contact Number:");
        contactNumberField = new JTextField(15);

        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderField);
        inputPanel.add(contactNumberLabel);
        inputPanel.add(contactNumberField);

        addButton = new JButton("Add Patient");
        viewButton = new JButton("View Patients");
        searchButton = new JButton("Search Patient");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewPatients();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchPatient();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(searchButton);

        patientListArea = new JTextArea(10, 40);
        patientListArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(patientListArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void createPatientTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS patients ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "first_name VARCHAR(255),"
                    + "last_name VARCHAR(255),"
                    + "age INT,"
                    + "gender VARCHAR(10),"
                    + "contact_number VARCHAR(15))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addPatient() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO patients (first_name, last_name, age, gender, contact_number) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, firstNameField.getText());
            preparedStatement.setString(2, lastNameField.getText());
            preparedStatement.setInt(3, Integer.parseInt(ageField.getText()));
            preparedStatement.setString(4, genderField.getText());
            preparedStatement.setString(5, contactNumberField.getText());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Patient added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewPatients() {
        patientListArea.setText("");
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM patients")) {
            while (resultSet.next()) {
                patientListArea.append("Patient ID: " + resultSet.getInt("id") + "\n");
                patientListArea.append("First Name: " + resultSet.getString("first_name") + "\n");
                patientListArea.append("Last Name: " + resultSet.getString("last_name") + "\n");
                patientListArea.append("Age: " + resultSet.getInt("age") + "\n");
                patientListArea.append("Gender: " + resultSet.getString("gender") + "\n");
                patientListArea.append("Contact Number: " + resultSet.getString("contact_number") + "\n");
                patientListArea.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void searchPatient() {
        String searchQuery = JOptionPane.showInputDialog(frame, "Enter a part of the first name or last name to search:");
        patientListArea.setText("");
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM patients WHERE first_name LIKE ? OR last_name LIKE ?")) {
            preparedStatement.setString(1, "%" + searchQuery + "%");
            preparedStatement.setString(2, "%" + searchQuery + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    patientListArea.append("Patient ID: " + resultSet.getInt("id") + "\n");
                    patientListArea.append("First Name: " + resultSet.getString("first_name") + "\n");
                    patientListArea.append("Last Name: " + resultSet.getString("last_name") + "\n");
                    patientListArea.append("Age: " + resultSet.getInt("age") + "\n");
                    patientListArea.append("Gender: " + resultSet.getString("gender") + "\n");
                    patientListArea.append("Contact Number: " + resultSet.getString("contact_number") + "\n");
                    patientListArea.append("\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TEST();
            }
        });
    }
}
