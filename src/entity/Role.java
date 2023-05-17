package entity;

public class Role {
    /**
     * "roleName": "Leader of basketball team",
     *       "roleTime": "2020.09-2021.09"
     */
    private String roleName;
    private String roleTime;

    public Role(String roleName, String roleTime) {
        this.roleName = roleName;
        this.roleTime = roleTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTime() {
        return roleTime;
    }

    public void setRoleTime(String roleTime) {
        this.roleTime = roleTime;
    }
}
