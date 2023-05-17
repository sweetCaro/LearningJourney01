package Boundary;

import Controller.TodoListUtil;
import entity.Student;
import entity.TodoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TodoListPage extends JFrame implements ActionListener{
        JList<String> itemList;
        DefaultListModel<String> listModel;
        JTextField itemText;
        JButton addButton;
        JButton deleteButton;
        int index;
        List<TodoList> todoLists;
        public TodoListPage(int indexOfStudentInformation) {
            this.index = indexOfStudentInformation;
            // Initialize the JFrame
            setTitle("Todo List");
            setSize(300, 500);
            JPanel panel = new JPanel();
            add(panel);
            panel.setLayout(null);
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Initialize the list model and add some items
            listModel = new DefaultListModel<String>();
            //List<TodoList> todoLists = new ArrayList<TodoList>();
            todoLists=new TodoListUtil().getTodoList(indexOfStudentInformation);
            for(int i = 0; i < todoLists.size(); i++){
                listModel.addElement(todoLists.get(i).getTodoThing());
            }

            // Create the JList and add it to a JScrollPane
            itemList = new JList<String>(listModel);
            JScrollPane listScrollPane = new JScrollPane(itemList);
            // Create the text field and buttons
            itemText = new JTextField("Add some todo items!",20);
            itemText.setForeground(Color.GRAY);
            addButton = new JButton("Add");
            deleteButton = new JButton("Delete");
            // Add action listeners to the buttons
            addButton.addActionListener(this);
            deleteButton.addActionListener(this);
            // a JPanel to hold the text field and buttons
            panel.add(itemText);
            panel.add(addButton);
            panel.add(deleteButton);
            panel.add(listScrollPane);
            // Add the JList and input panel to the JFrame
            addButton.setBounds(20,5,100,20);
            deleteButton.setBounds(150,5,100,20);
            itemText.setBounds(5,30,300,20);
            listScrollPane.setBounds(5,60,300,400);

            setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                // Add a new item to the list
                String item = itemText.getText();
                listModel.addElement(item);
                itemText.setText("");
                boolean initialState=false;
                TodoList newItem = new TodoList(item, initialState);
                new TodoListUtil().addTodoList(this.index,newItem);
            } else if (e.getSource() == deleteButton) {
                // Remove the selected item from the list
                int index = itemList.getSelectedIndex();
                if (index != -1) {


                    boolean finishState = true;
                    TodoList finishItem = new TodoList(listModel.get(index), finishState);
                    System.out.println(listModel.get(index));
                    new TodoListUtil().deleteTodoList(this.index, finishItem);
                    listModel.remove(index);
                }
            }
        }

}



