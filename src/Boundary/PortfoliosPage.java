package Boundary;

import Controller.PortfoliosUtil;
import entity.Portfolios;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PortfoliosPage extends JPanel implements ActionListener {
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<Portfolios> projects;
    private int indexOfStudentInformation;
    private JLabel hyperlinkLabel;
    private JPanel buttonPanel;

    public PortfoliosPage(int indexOfStudentInformation) {
        setLayout(null);
        this.indexOfStudentInformation = indexOfStudentInformation;
        projects = new ArrayList<>();

        // Initialize the table
        String[] columnNames = {"Project Name", "Project Description"};
        //String[] columnNames = {"Project Name", "Project Description"};
        tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable(tableModel);
        //table.setBounds(5,5,600,300);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        List<Portfolios> portfoliosList = new PortfoliosUtil().getPortfolios(indexOfStudentInformation);

        for (Portfolios portfolio : portfoliosList) {
            tableModel.addRow(new Object[]{portfolio.getProjectName(), portfolio.getProjectIntroduction()});
            addOpenFile(tableModel.getRowCount(),portfolio);
            projects.add(portfolio);
        }

        // Set table header style
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(98, 154, 208));
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        header.setFont(header.getFont().deriveFont(Font.BOLD));

        // Set table row height
        table.setRowHeight(30);

        // Set table selection color
        table.setSelectionBackground(new Color(169, 202, 239));

        // Set table cell background color
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(new Color(207, 224, 245));
        table.setDefaultRenderer(Object.class, renderer);

        // Initialize the buttons
        JButton uploadButton = new JButton("Upload Project");
        uploadButton.setBounds(80,20,150,20);
        add(uploadButton);
        JButton deleteButton = new JButton("Delete Project");
        deleteButton.setBounds(280,20,150,20);
        add(deleteButton);

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
                    tableModel.addRow(new Object[]{project.getProjectName(), project.getProjectIntroduction()});

                    updateJSON(); // 更新JSON文件
                    addOpenFile(tableModel.getRowCount(),project);
                    System.out.println(tableModel.getRowCount());
                    repaint();
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

                    updateJSON(); // 更新JSON文件
                    removeOpenFile();
                    repaint();
                }
            }
        });

        // Set panel border
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Portfolios",
                TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.BOLD + Font.ITALIC, 12), Color.BLACK));

        // Add components to the panel
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(5,50,500,300);
        add(tableScrollPane);

        // Set panel background gradient
        setBackground(new Color(142, 178, 231));
        setPreferredSize(new Dimension(600, 400));
        setSize(600,400);

        // Center the panel on the screen
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PortfoliosPage.this);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    public void updateJSON() {
        try {
            JSONTokener tokener = new JSONTokener(new FileReader("src/Data/InformationOfStudents.json"));
            JSONArray jsonArray = new JSONArray(tokener);
            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);

            // Update portfolios in JSON
            JSONArray tempList = new JSONArray();
            for (Portfolios portfolio : projects) {
                JSONObject portfolioObject = new JSONObject();
                portfolioObject.put("projectName", portfolio.getProjectName());
                portfolioObject.put("projectIntroduction", portfolio.getProjectIntroduction());
                portfolioObject.put("fileLink", portfolio.getFileLink());
                tempList.put(portfolioObject);

            }
            jsonObject.put("portfolios", tempList);
            jsonArray.put(indexOfStudentInformation, jsonObject);

            // Write JSON file
            FileWriter fileWriter = new FileWriter("src/Data/InformationOfStudents.json");
            fileWriter.write(jsonArray.toString());
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addOpenFile(int numberOfRows,Portfolios portfolio){
        hyperlinkLabel=new JLabel("<html><a href='file:///C:/path/to/file.txt'>Open File</a></html>");
        hyperlinkLabel.setBounds(520,numberOfRows*30+45,400,20);
        hyperlinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hyperlinkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        String fileAddress = portfolio.getFileLink();
                        Desktop.getDesktop().open(new File(fileAddress));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        add(hyperlinkLabel);
    }
    public void removeOpenFile(){
        remove(hyperlinkLabel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
