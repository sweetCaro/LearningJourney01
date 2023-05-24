package Controller;

import entity.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AssessmentUtil extends ModuleUtil{
    @Override
    public List<Module> getModules(int indexOfStudentInformation) {
        List<Module> modules = super.getModules(indexOfStudentInformation);
        List<Module> passedModule=new ArrayList<Module>();
        for(Module module : modules){
            if(Objects.equals(module.getState(), "passed")){
                passedModule.add(module);
            }
        }
        return passedModule;
    }
    public double getWeight(List<Module> passedModule) {
        double weight=0;
        int gotGrade=0;
        int totalGrade=0;
        for(int i=0;i<passedModule.size();i++){
            gotGrade+=passedModule.get(i).getScore()*passedModule.get(i).getCredit();
            totalGrade+=100*passedModule.get(i).getCredit();

            weight = gotGrade*100.0/totalGrade;

        }
        return weight;
    }
    public double getGpa(double weightedAverageGrade){
        double gpa=0;
        if(weightedAverageGrade>89&&weightedAverageGrade<=100)  gpa=4.0;
        if(weightedAverageGrade>84&&weightedAverageGrade<=89)  gpa=3.7;
        if(weightedAverageGrade>81&&weightedAverageGrade<=84)  gpa=3.3;
        if(weightedAverageGrade>77&&weightedAverageGrade<=81)  gpa=3.0;
        if(weightedAverageGrade>74&&weightedAverageGrade<=77)  gpa=2.7;
        if(weightedAverageGrade>71&&weightedAverageGrade<=74)  gpa=2.3;
        if(weightedAverageGrade>67&&weightedAverageGrade<=71)  gpa=2.0;
        if(weightedAverageGrade>63&&weightedAverageGrade<=67)  gpa=1.7;
        if(weightedAverageGrade>59&&weightedAverageGrade<=63)  gpa=1.0;
        if(weightedAverageGrade>0&&weightedAverageGrade<=59)  gpa=0;
        return gpa;

    }

}
