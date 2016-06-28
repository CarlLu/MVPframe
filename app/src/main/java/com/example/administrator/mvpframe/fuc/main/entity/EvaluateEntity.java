package com.example.administrator.mvpframe.fuc.main.entity;

import com.example.administrator.mvpframe.common.base.baseEntity.BaseEntity;

import java.util.List;

public class EvaluateEntity extends BaseEntity {

    private List<ScoreEntity> score;

    public void setScore(List<ScoreEntity> score) {
        this.score = score;
    }

    public List<ScoreEntity> getScore() {
        return score;
    }

    public static class ScoreEntity {
        private String content;
        private long createDate;
        private double diet;
        private double environment;
        private int id;
        private int mechanismID;
        private String name;
        private String phone;
        private String pic;
        private String relation;
        private double score;
        private double stay;
        private String studentName;
        private double teacher;
        private int userID;

        public void setContent(String content) {
            this.content = content;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public void setDiet(double diet) {
            this.diet = diet;
        }

        public void setEnvironment(double environment) {
            this.environment = environment;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMechanismID(int mechanismID) {
            this.mechanismID = mechanismID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public void setStay(double stay) {
            this.stay = stay;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public void setTeacher(double teacher) {
            this.teacher = teacher;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getContent() {
            return content;
        }

        public long getCreateDate() {
            return createDate;
        }

        public double getDiet() {
            return diet;
        }

        public double getEnvironment() {
            return environment;
        }

        public int getId() {
            return id;
        }

        public int getMechanismID() {
            return mechanismID;
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

        public String getRelation() {
            return relation;
        }

        public double getScore() {
            return score;
        }

        public double getStay() {
            return stay;
        }

        public String getStudentName() {
            return studentName;
        }

        public double getTeacher() {
            return teacher;
        }

        public int getUserID() {
            return userID;
        }
    }
}
