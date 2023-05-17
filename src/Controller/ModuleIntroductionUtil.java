package Controller;

import entity.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModuleIntroductionUtil extends ModuleUtil{
    public List<Module> getModules(int indexOfStudentInformation) {
        List<Module> moduleList=super.getModules(indexOfStudentInformation);
        List<Module> currentModuleList=new ArrayList<Module>();
        for(Module module : moduleList){
            if(Objects.equals(module.getState(), "current")){
                currentModuleList.add(module);
            }
        }
        return currentModuleList;
    }
}
