package com.merept.id;

/**
 * <p>所属包名: com.merept.id</p>
 * <p>项目名称: SetPersonInfo</p>
 * <p>文件名称: TeacherInfo</p>
 * @author MerePT
 */

public class TeacherInfo extends PersonInfo implements Result {
    private final String major;

    public TeacherInfo(String name, String gender, String major) {
        super(name, gender);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String getResultEN() {
        return "Name: " + super.getName() + " - Teacher" + "\n" +
                "Gender: " + super.getGenderEN() + "\n" +
                "Major: " + getMajor() + "\n";
    }

    @Override
    public String getResultZH() {
        return  "姓名: " + super.getName() + " 老师" + "\n" +
                "性别: " + super.getGenderZH() + "\n" +
                "专业: " + getMajor() + "\n";
    }
}
