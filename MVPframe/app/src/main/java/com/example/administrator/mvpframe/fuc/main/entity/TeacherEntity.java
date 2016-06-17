package com.example.administrator.mvpframe.fuc.main.entity;

public class TeacherEntity{
    private long birthday;
    private String content;
    private int enable;
    private int id;
    private int mechanismID;
    private String mechanismName;
    private String name;
    private String password;
    private String phone;
    private String pic;
    private int seniority;
    private String seniorityName;
    private int sex;
    private String specialty;

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getContent() {
        return content;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMechanismID(int mechanismID) {
        this.mechanismID = mechanismID;
    }

    public void setMechanismName(String mechanismName) {
        this.mechanismName = mechanismName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public void setSeniorityName(String seniorityName) {
        this.seniorityName = seniorityName;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public int getMechanismID() {
        return mechanismID;
    }

    public String getMechanismName() {
        return mechanismName;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPic() {
        return pic;
    }

    public int getSeniority() {
        return seniority;
    }

    public String getSeniorityName() {
        return seniorityName;
    }

    public int getSex() {
        return sex;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "birthday=" + birthday +
                ", content='" + content + '\'' +
                ", enable=" + enable +
                ", id=" + id +
                ", mechanismID=" + mechanismID +
                ", mechanismName='" + mechanismName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", pic='" + pic + '\'' +
                ", seniority=" + seniority +
                ", seniorityName='" + seniorityName + '\'' +
                ", sex=" + sex +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}