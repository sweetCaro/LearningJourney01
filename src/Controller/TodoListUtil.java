package Controller;

import entity.Student;
import entity.TodoList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.oracle.jrockit.jfr.Transition.To;

public class TodoListUtil {
    public List<TodoList> getTodoList(int indexOfStudentInformation) {

        List<TodoList> todoLists = null;
        try {
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));

            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);
            JSONArray tempList=jsonObject.getJSONArray("todoList");
            todoLists = new ArrayList<>();
            for(int i=0;i<tempList.length();i++){
                String todoThing=tempList.getJSONObject(i).getString("todoThing");
                boolean statusOfThing=tempList.getJSONObject(i).getBoolean("statusOfThing");
                TodoList todoList=new TodoList(todoThing,statusOfThing);
                if(!statusOfThing){
                    todoLists.add(todoList);//只返回未完成的
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return todoLists;
    }
    //点击Add按钮之后使用该函数，重写文件
    public void addTodoList(int indexOfStudentInformation, TodoList newItem){
        try {
            //读到大数组
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));
            //for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);//找到todolist数组
                //读到小数组
                JSONArray arr = jsonObject.getJSONArray("todoList");
                List<TodoList> list = new ArrayList<TodoList>();
                for(int j = 0; j < arr.length(); j++) {
                    String todoThing=arr.getJSONObject(j).getString("todoThing");
                    boolean statusOfThing=arr.getJSONObject(j).getBoolean("statusOfThing");
                    TodoList item=new TodoList(todoThing,statusOfThing);
                    list.add(item);
                }
                list.add(newItem);//把传进来的事项添加进去
                jsonObject.remove("todoList");
                jsonObject.put("todoList",list);
            //}

            File jsonFile = new File("src/Data/InformationOfStudents.json");
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    FileWriter fileWriter = new FileWriter(jsonFile.getAbsoluteFile(), false);
                    BufferedWriter writer = new BufferedWriter(fileWriter);
                    writer.write(String.valueOf(jsonArray));
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //点击delete按钮之后，设置该状态为false,还是要重写文件
    public void deleteTodoList (int indexOfStudentInformation, TodoList finishItem){
        try {
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));
            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);
            JSONArray arr = jsonObject.getJSONArray("todoList");
            List<TodoList> list = new ArrayList<TodoList>();
            for(int j = 0; j < arr.length(); j++) {
                String todoThing=arr.getJSONObject(j).getString("todoThing");
                boolean statusOfThing=arr.getJSONObject(j).getBoolean("statusOfThing");
                if(Objects.equals(todoThing, finishItem.getTodoThing())){
                    statusOfThing=true;
                }
                TodoList item=new TodoList(todoThing,statusOfThing);
                list.add(item);
            }
            //list.add(finishItem);//把传进来的事项添加进去
            jsonObject.remove("todoList");
            jsonObject.put("todoList",list);
            System.out.println(list.get(4).getStatusOfThing());

            File jsonFile = new File("src/Data/InformationOfStudents.json");
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    FileWriter fileWriter = new FileWriter(jsonFile.getAbsoluteFile(), false);
                    BufferedWriter writer = new BufferedWriter(fileWriter);
                    writer.write(String.valueOf(jsonArray));
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
