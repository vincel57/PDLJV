package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyPlannerGUI extends JFrame {
    private JTable eventTable;
    private DefaultTableModel tableModel;

    public DailyPlannerGUI() {
        super("Planning quotidien");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panneau supérieur avec la date actuelle
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new FlowLayout());
        JLabel dateLabel = new JLabel();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.now();
        dateLabel.setText("Date: " + dateFormat.format(currentDate));
        datePanel.add(dateLabel);

        // Panneau central avec la table des événements
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        String[] columnNames = {"Heure", "Événement"};
        tableModel = new DefaultTableModel(columnNames, 0);
        eventTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(eventTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Panneau inférieur avec le bouton d'ajout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> {
            addEvent();
        });
        buttonPanel.add(addButton);

        // Ajout des panneaux à la fenêtre principale
        add(datePanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
    }

    private void addEvent() {
        String time = JOptionPane.showInputDialog(this, "Heure de l'événement (ex. 14:30) :");
        if (time != null && !time.isEmpty()) {
            String event = JOptionPane.showInputDialog(this, "Événement :");
            if (event != null && !event.isEmpty()) {
                tableModel.addRow(new String[]{time, event});
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DailyPlannerGUI().setVisible(true);
        });
    }
}
