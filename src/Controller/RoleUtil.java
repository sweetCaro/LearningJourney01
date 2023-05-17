package Controller;

import entity.Role;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RoleUtil {
    public List<Role> getRoles(int indexOfStudentInformation){
        List<Role> roleList = null;
        try{
            JSONArray jsonArray= new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));
            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);
            JSONArray tempList=jsonObject.getJSONArray("role");
            roleList=new ArrayList<>();
            for(int i=0; i<tempList.length(); i++){
                String roleName=tempList.getJSONObject(i).getString("roleName");
                String roleTime=tempList.getJSONObject(i).getString("roleTime");
                Role role=new Role(roleName,roleTime);
                roleList.add(role);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return roleList;
    }
}
