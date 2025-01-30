package com.srm.project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class gg {

    class p {

	}

	private Connection connection;
    private JFrame frame;
    private JTextField firstNameField, lastNameField, ageField, genderField, specializationField, roleField, contactNumberField, deleteNameField;
    private JTextArea entityListArea;
    private JButton addButton, viewButton, deleteButton;
    private JComboBox<String> entityTypeComboBox;

    public gg() {
        initializeDatabase();
        createAndShowGUI();
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Pikachu6674@");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createAndShowGUI() {
        frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(9, 2));

        JLabel entityTypeLabel = new JLabel("Select Entity Type:");
        String[] entityTypes = {"Patient", "Doctor", "Staff"};
        entityTypeComboBox = new JComboBox<>(entityTypes);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(3);
        JLabel genderLabel = new JLabel("Gender:");
        genderField = new JTextField(10);
        JLabel specializationLabel = new JLabel("Specialization (Doctors only):");
        specializationField = new JTextField(20);
        JLabel roleLabel = new JLabel("Role (Staff only):");
        roleField = new JTextField(20);
        JLabel contactNumberLabel = new JLabel("Contact Number:");
        contactNumberField = new JTextField(15);

        JLabel deleteNameLabel = new JLabel("Name to Delete:");
        deleteNameField = new JTextField(20);

        inputPanel.add(entityTypeLabel);
        inputPanel.add(entityTypeComboBox);
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(genderLabel);
        inputPanel.add(genderField);
        inputPanel.add(specializationLabel);
        inputPanel.add(specializationField);
        inputPanel.add(roleLabel);
        inputPanel.add(roleField);
        inputPanel.add(contactNumberLabel);
        inputPanel.add(contactNumberField);
        inputPanel.add(deleteNameLabel);
        inputPanel.add(deleteNameField);

        addButton = new JButton("Add Entity");
        viewButton = new JButton("View Entities");
        deleteButton = new JButton("Delete Entity");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addEntity();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewEntities();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteEntity();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);

        entityListArea = new JTextArea(30, 60);
        entityListArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(entityListArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void addEntity() {
        String entityType = entityTypeComboBox.getSelectedItem().toString();
        String insertSQL = "";

        switch (entityType) {
            case "Patient":
                insertSQL = "INSERT INTO patients (first_name, last_name, age, gender, contact_number) VALUES (?, ?, ?, ?, ?)";
                break;
            case "Doctor":
                insertSQL = "INSERT INTO doctors (first_name, last_name, specialization, contact_number) VALUES (?, ?, ?, ?)";
                break;
            case "Staff":
                insertSQL = "INSERT INTO staff (first_name, last_name, role, contact_number) VALUES (?, ?, ?, ?)";
                break;
            default:
                break;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, firstNameField.getText());
            preparedStatement.setString(2, lastNameField.getText());

            if (entityType.equals("Patient")) {
                preparedStatement.setInt(3, Integer.parseInt(ageField.getText()));
                preparedStatement.setString(4, genderField.getText());
                preparedStatement.setString(5, contactNumberField.getText());
            } else if (entityType.equals("Doctor")) {
                preparedStatement.setString(3, specializationField.getText());
                preparedStatement.setString(4, contactNumberField.getText());
            } else if (entityType.equals("Staff")) {
                preparedStatement.setString(3, roleField.getText());
                preparedStatement.setString(4, contactNumberField.getText());
            }

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(frame, entityType + " added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewEntities() {
        entityListArea.setText("");
        try {
            viewEntitiesOfType("Patient");
            viewEntitiesOfType("Doctor");
            viewEntitiesOfType("Staff");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewEntitiesOfType(String entityType) throws SQLException {
        String viewSQL = "";
        String label = "";
        if (entityType.equals("Patient")) {
            viewSQL = "SELECT * FROM patients";
            label = "Patients";
        } else if (entityType.equals("Doctor")) {
            viewSQL = "SELECT * FROM doctors";
            label = "Doctors";
        } else if (entityType.equals("Staff")) {
            viewSQL = "SELECT * FROM staff";
            label = "Staff Members";
        }

        entityListArea.append(label + ":\n");

        try (PreparedStatement preparedStatement = connection.prepareStatement(viewSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                entityListArea.append("First Name: " + resultSet.getString("first_name") + "\n");
                entityListArea.append("Last Name: " + resultSet.getString("last_name") + "\n");

                if (entityType.equals("Patient")) {
                    entityListArea.append("Age: " + resultSet.getInt("age") + "\n");
                    entityListArea.append("Gender: " + resultSet.getString("gender") + "\n");
                } else if (entityType.equals("Doctor")) {
                    entityListArea.append("Specialization: " + resultSet.getString("specialization") + "\n");
                } else if (entityType.equals("Staff")) {
                    entityListArea.append("Role: " + resultSet.getString("role") + "\n");
                }

                entityListArea.append("Contact Number: " + resultSet.getString("contact_number") + "\n");
                entityListArea.append("\n");
            }
        }
    }

    private void deleteEntity() {
        String entityType = entityTypeComboBox.getSelectedItem().toString();
        String nameToDelete = deleteNameField.getText();
        String deleteSQL=null;
        if(entityType.equals("Staff")){
        deleteSQL = "DELETE FROM " + entityType.toLowerCase() + " WHERE first_name = ?";
        } else {
        deleteSQL = "DELETE FROM " + entityType.toLowerCase() +"s"+ " WHERE first_name = ?";
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, nameToDelete);
            int deleted = preparedStatement.executeUpdate();
            if (deleted > 0) {
                JOptionPane.showMessageDialog(frame, entityType + " with name " + nameToDelete + " deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(frame, "No " + entityType + " found with name " + nameToDelete);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new gg();
            }
        });
    }
}
