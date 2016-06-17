package com.example.administrator.mvpframe.fuc.main.entity;

import com.example.administrator.mvpframe.common.base.baseEntity.BaseEntity;

import java.util.List;

public class MainTeacherEntity extends BaseEntity {

    /**
     * id : 1
     * mechanismID : 1
     * mechanismName : 北京大学托儿所
     * name : 小天逗比
     * phone : 13480807000
     * pic : /upload/image/2015/20151124/20151124163237829.jpg
     * seniority : 5
     * seniorityName : 3~5年
     * sex : 0
     * specialty : 语文,英语
     */

    private List<TeacherEntity> teacher;

    public void setTeacher(List<TeacherEntity> teacher) {
        this.teacher = teacher;
    }

    public List<TeacherEntity> getTeacher() {
        return teacher;
    }

}
