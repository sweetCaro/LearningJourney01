package Controller;

import entity.Module;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ModuleUtil {
    public List<Module> getModules(int indexOfStudentInformation) {
        List<Module> moduleList=null;
        try{
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));
            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);
            JSONArray tempList=jsonObject.getJSONArray("module");
            moduleList=new ArrayList<>();
            for(int i=0; i<tempList.length(); i++){
                String moduleName = tempList.getJSONObject(i).getString("moduleName");
                String moduleId=tempList.getJSONObject(i).getString("moduleId");
                String state = tempList.getJSONObject(i).getString("state");
                int beginTime=tempList.getJSONObject(i).getInt("beginTime");
                String weekDay=tempList.getJSONObject(i).getString("weekday");
                int endTime=tempList.getJSONObject(i).getInt("endTime");
                int score = tempList.getJSONObject(i).getInt("score");
                int credit=tempList.getJSONObject(i).getInt("credit");
                String year=tempList.getJSONObject(i).getString("openYear");
                String teacher=tempList.getJSONObject(i).getString("teacher");
                String teacherEmail=tempList.getJSONObject(i).getString("teacherEmail");
                String intro=tempList.getJSONObject(i).getString("intro");
                Module module = new Module(moduleName,moduleId,state,beginTime,weekDay,endTime,score,credit,year,teacher,teacherEmail,intro);
                moduleList.add(module);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return moduleList;
    }
}
