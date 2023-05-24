package Controller;

import entity.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScheduleUtil extends CurrentModuleUtil{
    @Override
    public List<Module> getModules(int indexOfStudentInformation) {
        return super.getModules(indexOfStudentInformation);
    }
    public int[] getTimeAndDay(Module module) {
        int[] timeAndDay = new int[2];
        for(int i=7;i<=21;i++){
            if(module.getBeginTime()==i){
                timeAndDay[0]=i-7;
            }
        }
        if(Objects.equals(module.getWeekday(), "Monday")){
            timeAndDay[1]=1;
        }
        if(Objects.equals(module.getWeekday(), "Tuesday")){
            timeAndDay[1]=2;
        }
        if(Objects.equals(module.getWeekday(), "Wednesday")){
            timeAndDay[1]=3;
        }
        if(Objects.equals(module.getWeekday(), "Thursday")){
            timeAndDay[1]=4;
        }
        if(Objects.equals(module.getWeekday(), "Friday")){
            timeAndDay[1]=5;
        }

        return timeAndDay;
    }
}
