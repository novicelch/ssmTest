package cn.liu.pojo;

public class Role {
    private String rId;

    private String rName;

    private String rPassword;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword;
    }

    public Role(String rId, String rName, String rPassword) {
        this.rId = rId;
        this.rName = rName;
        this.rPassword = rPassword;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "rId='" + rId + '\'' +
                ", rName='" + rName + '\'' +
                ", rPassword='" + rPassword + '\'' +
                '}';
    }
}