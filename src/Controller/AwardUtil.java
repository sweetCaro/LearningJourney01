package Controller;

import entity.Awards;
import entity.Role;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AwardUtil {
    public List<Awards> getAwards(int indexOfStudentInformation){
        List<Awards> awardsList = new ArrayList<>();
        try{
            JSONArray jsonArray= new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));
            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);
            JSONArray tempList=jsonObject.getJSONArray("awards");
            for(int i=0; i<tempList.length(); i++){
                String awardName=tempList.getJSONObject(i).getString("awardName");
                String awardTime=tempList.getJSONObject(i).getString("awardTime");
                Awards award=new Awards(awardName,awardTime);
                awardsList.add(award);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return awardsList;
    }
}
