package com.example.administrator.mvpframe.fuc.detail.model;

import com.example.administrator.mvpframe.common.base.baseEntity.BaseEntity;
import com.example.administrator.mvpframe.fuc.main.entity.TeacherEntity;

public class TeacherInfoEntity extends BaseEntity {


    private TeacherEntity teacher;

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }
}
