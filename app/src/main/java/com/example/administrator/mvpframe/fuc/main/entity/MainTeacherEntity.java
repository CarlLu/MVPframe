package com.example.administrator.mvpframe.fuc.main.entity;

import com.example.administrator.mvpframe.common.base.baseEntity.BaseEntity;

import java.util.List;

public class MainTeacherEntity extends BaseEntity {

    private List<TeacherEntity> teacher;

    public void setTeacher(List<TeacherEntity> teacher) {
        this.teacher = teacher;
    }

    public List<TeacherEntity> getTeacher() {
        return teacher;
    }

}
