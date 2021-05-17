package com.merept.id;

import java.time.LocalDate;

/**
 * <p>所属包名: com.merept.id</p>
 * <p>项目名称: SetPersonInfo</p>
 * <p>文件名称: StudentInfo</p>
 * @author MerePT
 */

public class StudentInfo extends PersonInfo implements Result {
    private final LocalDate today = LocalDate.now();
    private final String gender;
    private int year = 0;
    private int month = 0;
    private int day = 0;
    public int id = 100000;

    public StudentInfo(String name, String gender, int birthday) {
        super(name, gender);
        this.gender = gender;
        year = birthday / 10000;
        month = (birthday % 10000) / 100;
        day = birthday % 100;
        id = setID();
    }

    public int setID() {
        var nowYear = today.getYear();
        id += (nowYear * 1000000);
        for (int i = 2000; i < year; i++) id += 100000;
        id += (month * 1000);
        id += (day * 10);
        int r = (int) (Math.random() * 9);
        if (CheckinInfo.sexDecide(gender) == 1) {
            while (r % 2 == 0)
                r = (int) (Math.random() * 9);
        } else if (CheckinInfo.sexDecide(gender) == 2) {
            while (r % 2 != 0)
                r = (int) (Math.random() * 9);
        }
        if (r == 0) id += (r + 2);
        id += r;
        r = 0;
        return id;
    }

    public int getID() {
        return id;
    }

    @Override
    public String getResultEN() {
        return "Name: " + super.getName() + " - Student" + "\n" +
                "Gender: " + super.getGenderEN() + "\n" +
                "Your ID is " + getID() + "\n";
    }

    @Override
    public String getResultZH() {
        return  "姓名: " + super.getName() + " 同学" +"\n" +
                "性别: " + super.getGenderZH() + "\n" +
                "学号: " + getID() + "\n";
    }
}