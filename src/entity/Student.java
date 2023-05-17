package entity;

import java.util.Collections;
import java.util.List;

public class Student {
    private String studentNo;
    private String password;
    private String studentName;
    private List<Module> module;
    private List<TodoList> todoList;
    private List<Role> roles;
    private List<Portfolios> portfolios;
    private List<Bulletin> bulletins;
    private List<Awards> awards;
    private String trainingProgram;

    public Student(String studentNo, String password, String studentName) {
        this.studentNo = studentNo;
        this.password = password;
        this.studentName = studentName;
    }

    public Student(String studentNo, String password, String studentName, List<Module> module, List<TodoList> todoList, List<Role> roles, List<Portfolios> portfolios, List<Bulletin> bulletins, List<Awards> awards,String trainingProgram) {
        this.studentNo = studentNo;
        this.password = password;
        this.studentName = studentName;
        //this.module= module;//左边是实体类module的list，右边是object的list，想让传进来的list<Object>变成List<Module>
        this.module=module;
        this.todoList = todoList;
        this.roles = roles;
        this.portfolios = portfolios;
        this.bulletins = bulletins;
        this.awards = awards;
        this.trainingProgram= trainingProgram;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Module> getModule() {
        return module;
    }

    public void setModule(List<Module> module) {
        this.module = module;
    }


    public List<TodoList> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoList> todoList) {
        this.todoList = todoList;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Portfolios> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolios> portfolios) {
        this.portfolios = portfolios;
    }

    public List<Bulletin> getBulletins() {
        return bulletins;
    }

    public void setBulletins(List<Bulletin> bulletins) {
        this.bulletins = bulletins;
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }

    public String getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(String trainingProgram) {
        this.trainingProgram = trainingProgram;
    }
}
