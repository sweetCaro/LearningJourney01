package Controller;

import entity.Module;
import entity.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.Objects;

public class Login {
    public int checkValid(String studentNo, String password){
        Student student;
        Module module = null;
        boolean valid = false;
        try{
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));
            //step 2: Decode json to java object
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                student=new Student(jsonObject.getString("studentNo"),
                        jsonObject.getString("password"),
                        jsonObject.getString("studentName")
                );
//                student = new Student(jsonObject.getString("studentNo"),
//                        jsonObject.getString("password"),
//                        jsonObject.getString("studentName"),
//                        jsonObject.getJSONArray("module").toList(),
//                        jsonObject.getJSONArray("todoList").toList(),
//                        jsonObject.getJSONArray("role").toList(),
//                        jsonObject.getJSONArray("portfolios").toList(),
//                        jsonObject.getJSONArray("bulletin").toList(),
//                        jsonObject.getJSONArray("awards").toList()
//                        );

                if (Objects.equals(studentNo, student.getStudentNo())&&Objects.equals(password,student.getPassword())){
                    valid=true;
                    return i;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
