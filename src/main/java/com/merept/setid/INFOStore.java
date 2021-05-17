package com.merept.setid;

import com.merept.id.CheckinInfo;
import com.merept.id.PersonInfo;
import com.merept.id.StudentInfo;
import com.merept.id.TeacherInfo;

import java.util.Scanner;

/**
 * <p>所属包名: com.merept.setid</p>
 * <p>项目名称: SetPersonInfo</p>
 * <p>文件名称: INFOStore</p>
 * @author MerePT
 */

public class INFOStore {
    private final int language;

    INFOStore() {
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        var i = in.nextLine();
        language = Integer.parseInt(i);
        switch (language) {
            case 1 -> idEN();
            case 2 -> idZH();
        }
        in.close();
    }

    public void idEN() {
        var in = new Scanner(System.in);

        System.out.print("\n" + "How many people do you want to? > ");
        var num = in.nextLine();
        int n = Integer.parseInt(num);
        var student = new PersonInfo[n];
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("You are (\"Teacher\" or \"Student\") > ");
            var idr = in.nextLine();
            if (CheckinInfo.identityRecognition(idr) == 1) {
                System.out.print("Input your name > ");
                var name = in.nextLine();
                System.out.print("Input your gender > ");
                var gender = in.nextLine();
                var checkGender = new PersonInfo();
                gender = checkGender.setGender(gender, language);
                System.out.print("Input your major > ");
                var major = in.nextLine();
                student[i] = new TeacherInfo(name, gender, major);
                System.out.println();
            } else if (CheckinInfo.identityRecognition(idr) == 2) {
                System.out.print("Input your name > ");
                var name = in.nextLine();
                System.out.print("Input your gender > ");
                var gender = in.nextLine();
                var checkGender = new PersonInfo();
                gender = checkGender.setGender(gender, language);
                System.out.print("Input your birthday > ");
                var bd = in.nextLine();
                int birthday = Integer.parseInt(bd);
                student[i] = new StudentInfo(name, gender, birthday);
                System.out.println();
            }
        }
        for (PersonInfo s : student) System.out.println(s.getResultEN());
        in.close();
    }

    public void idZH() {
        var in = new Scanner(System.in);

        System.out.print("\n" + "一共多少人 > ");
        var num = in.nextLine();
        int n = Integer.parseInt(num);
        var student = new PersonInfo[n];
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("你是老师还是学生？ > ");
            var idr = in.nextLine();
            if (CheckinInfo.identityRecognition(idr) == 1) {
                System.out.print("输入你的名字 > ");
                var name = in.nextLine();
                System.out.print("输入你的性别 > ");
                var gender = in.nextLine();
                var checkGender = new PersonInfo();
                gender = checkGender.setGender(gender, language);
                System.out.print("输入你的专业 > ");
                var major = in.nextLine();
                student[i] = new TeacherInfo(name, gender, major);
                System.out.println();
            } else if (CheckinInfo.identityRecognition(idr) == 2) {
                System.out.print("输入你的名字 > ");
                var name = in.nextLine();
                System.out.print("输入你的性别 > ");
                var gender = in.nextLine();
                var checkGender = new PersonInfo();
                gender = checkGender.setGender(gender, language);
                System.out.print("输入你的生日 > ");
                var bd = in.nextLine();
                int birthday = Integer.parseInt(bd);
                student[i] = new StudentInfo(name, gender, birthday);
                System.out.println();
            }
        }
        for (PersonInfo s : student) System.out.println(s.getResultZH());
        in.close();
    }
}
