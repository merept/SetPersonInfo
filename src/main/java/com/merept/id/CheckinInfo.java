package com.merept.id;

public class CheckinInfo {
    private CheckinInfo() {}

    /**
     * 通过读取gender值，判断不同输入方法的性别返回int值，达到对性别进行判断的效果
     * @param gender 读取的性别，String变量
     * @return int
     */
    public static int sexDecide(String gender) {
        int i = 0;
        if (gender.equals("男") || gender.equals("nan") || gender.equals("Nan")
                || gender.equals("NAN") || gender.equals("M") || gender.equals("m")
                || gender.equals("male") || gender.equals("Male") || gender.equals("MALE")
        )  i = 1;
        else if (gender.equals("女") || gender.equals("nv") || gender.equals("Nv")
                || gender.equals("NV") || gender.equals("F") || gender.equals("f")
                || gender.equals("female") || gender.equals("Female") || gender.equals("FEMALE")
        ) i = 2;
        return i;
    }

    /**
     * 通过读取identity值，判断不同输入方法的身份返回int值，达到对身份进行判断的效果
     * @param identity 读取的身份，String变量
     * @return int
     */
    public static int identityRecognition(String identity) {
        int i = 0;
        if (identity.equals("老师") || identity.equals("laoshi") || identity.equals("Laoshi")
                || identity.equals("LAOSHI") || identity.equals("T") || identity.equals("t")
                || identity.equals("teacher") || identity.equals("Teacher") || identity.equals("TEACHER")
        )  i = 1;
        else if (identity.equals("学生") || identity.equals("xuesheng") || identity.equals("Xuesheng")
                || identity.equals("XUESHENG") || identity.equals("S") || identity.equals("s")
                || identity.equals("student") || identity.equals("Student") || identity.equals("STUDENT")
        )  i = 2;
        return i;
    }
}
