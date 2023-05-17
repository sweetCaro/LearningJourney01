package Controller;

import entity.Bulletin;
import entity.TodoList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BulletinUtil {
    public List<Bulletin> getBulletin(int indexOfStudentInformation) {
        List<Bulletin> bulletin=null;
        try{
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));

            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);
            JSONArray tempList=jsonObject.getJSONArray("bulletin");
            bulletin = new ArrayList<>();
            for(int i=0;i<tempList.length();i++){
                String notice=tempList.getJSONObject(i).getString("notice");
                String updateTime=tempList.getJSONObject(i).getString("updateTime");
                Bulletin item=new Bulletin(notice,updateTime);
                bulletin.add(item);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return bulletin;
    }
}
