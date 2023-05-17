package Controller;

import entity.Portfolios;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PortfoliosUtil {
    List<Portfolios> portfoliosList = new ArrayList<Portfolios>();
    public List<Portfolios> getPortfolios(int indexOfStudentInformation) {
        try{
            JSONArray jsonArray= new JSONArray(new JSONTokener(new FileReader("src/Data/InformationOfStudents.json")));
            JSONObject jsonObject = jsonArray.getJSONObject(indexOfStudentInformation);
            JSONArray tempList=jsonObject.getJSONArray("portfolios");
            for(int i=0; i<tempList.length(); i++){
                String portfolioName=tempList.getJSONObject(i).getString("projectName");
                String projectIntroduction=tempList.getJSONObject(i).getString("projectIntroduction");
                String fileLink=tempList.getJSONObject(i).getString("fileLink");
                Portfolios portfolio=new Portfolios(portfolioName,projectIntroduction,fileLink);
                portfoliosList.add(portfolio);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return portfoliosList;
    }

}
