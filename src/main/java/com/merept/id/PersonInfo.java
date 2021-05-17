package com.merept.id;

import java.util.Scanner;

public class PersonInfo implements Result {
    private String name;
    private String gender;

    public PersonInfo() {
    }

    public PersonInfo(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    /**
     * 可以通过读取填入的gender将gender值规范化
     * 并且输入错误的gender值将提供修改
     *
     * @return gender
     */
    public String setGender(String gender, int language) {
        Scanner in = new Scanner(System.in);

        if (CheckinInfo.sexDecide(gender) == 1) gender = "Male";
        else if (CheckinInfo.sexDecide(gender) == 2) gender = "Female";
        else {
            do {
                if (language == 1) System.out.print("Please input gender again(\"Male\" or \"Female\") > ");
                else if (language == 2) System.out.print("重新输入性别(\"男\"或\"女\") > ");
                gender = in.nextLine();
            } while (CheckinInfo.sexDecide(gender) != 1 && CheckinInfo.sexDecide(gender) != 2);
            if (CheckinInfo.sexDecide(gender) == 1) gender = "Male";
            else if (CheckinInfo.sexDecide(gender) == 2) gender = "Female";
        }
        return gender;
    }

    public String getGenderEN() {
        return gender;
    }

    public String getGenderZH() {
        var genderCN = gender;
        if (genderCN.equals("Male")) genderCN = "男";
        if (genderCN.equals("Female")) genderCN = "女";
        return genderCN;
    }

    public String getResultZH() {
        return "";
    }

    public String getResultEN() {
        return "";
    }
}
