package Boundary;

import Controller.PortfoliosUtil;
import entity.Portfolios;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PortfoliosPage extends JPanel implements ActionListener {
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<Portfolios> projects;
//    public PortfoliosPage() {
//
//    }
    public PortfoliosPage(int indexOfStudentInformation){
        projects = new ArrayList<>();

        // Initialize the table
        String[] columnNames = {"Project Name", "Project Description", "Project File Address"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        List<Portfolios> portfoliosList=new PortfoliosUtil().getPortfolios(indexOfStudentInformation);

        for(Portfolios portfolio :portfoliosList) {
            tableModel.addRow(new Object[]{portfolio.getProjectName(), portfolio.getProjectIntroduction(), portfolio.getFileLink()});
        }
        projects.addAll(portfoliosList);
        // Initialize the buttons
        JButton uploadButton = new JButton("Upload Project");
        JButton deleteButton = new JButton("Delete Project");
        // Add action listeners to the buttons
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(PortfoliosPage.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String name = JOptionPane.showInputDialog(PortfoliosPage.this, "Enter project name:");
                    String description = JOptionPane.showInputDialog(PortfoliosPage.this, "Enter project description:");
                    Portfolios project = new Portfolios(name, description, file.getAbsolutePath());
                    projects.add(project);
                    tableModel.addRow(new Object[]{project.getProjectName(), project.getProjectIntroduction(), project.getFileLink()});
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    projects.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                }
            }
        });
        // Add the components to the panel
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(uploadButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
