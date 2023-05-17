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
}
