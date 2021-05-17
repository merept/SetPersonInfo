
# SetPersonInfo / 个人信息录入程序

在学习Java**面向对象程序设计**时的**练习程序**

分别有英文和中文版

前8位数字可以根据当前年份以及生日创建学号

最后一位是根据性别添加一个随机数

最新版可以选择读取老师或者学生的信息

## 代码库地址

> + GitHub: <https://github.com/merept/SetPersonInfo>
> + Gitee: <https://gitee.com/merept/SetPersonInfo>

## 部分代码展示

### 老师和学生的选择

```Java
    System.out.print("你是老师还是学生？ > ");
    var idr = in.nextLine();
    if (CheckinInfo.identityRecognition(idr) == 1) {
        ...
    }
    else if (CheckinInfo.identityRecognition(idr) == 2) {
        ...
    }
```

这里用了CheckinInfo类的identityRecognition方法

```Java
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
```

CheckinInfo类的sexDecide也与其类似，我不知道有没有更好的办法来对输入内容判断，只能用这种笨办法（一个一个列出来）

### 输入错性别时的重新输入

```Java
    if (!CheckinInfo.nameDecide(name))
        System.out.print("Please input " + name + "'s gender again(\"Male\" or \"Female\") > ");
    if (CheckinInfo.nameDecide(name))
        System.out.print("重新输入" + name + "的性别(\"男\"或\"女\") > ");
    gender = in.nextLine();
```

这里用的是CheckinInfo类的nameDecide方法

```Java
    int n = 0;
    for(int i = 0; i < name.length(); i++)  n = name.charAt(i);
    return n >= 19968 && n < 40869;
```

这一部分可以根据输入的姓名的语言种类输出不同语言的重新输入性别要求，但是这之后并没有再次检查，我不知道该如何实现每次输入性别就可以检查是否错误并且重新输入

### 根据当前年份、生日、性别设置学生的学号

```Java
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
        }
        if (CheckinInfo.sexDecide(gender) == 2) {
            while (r % 2 != 0)
                r = (int) (Math.random() * 9);
        }
        if (r == 0) id += (r + 2);
        id += r;
        r = 0;
        return id;
    }
```

today变量是声明的private的LocalDate变量

```Java
    private final LocalDate today = LocalDate.now();
```

设置前四位（根据当前年份）

```Java
    var nowYear = today.getYear();
    id += (nowYear * 1000000);
```

第五到九位（根据生日）

```Java
    for (int i = 2000; i < year; i++) id += 100000; //年份确定第五位
    id += (month * 1000); //月份确定第六、七位
    id += (day * 10); //日期确定第八、九位
```

最后一位（随机数，男为奇数，女为偶数）

```Java
    int r = (int) (Math.random() * 9);
    if (CheckinInfo.sexDecide(gender) == 1) {
        while (r % 2 == 0)
            r = (int) (Math.random() * 9);
    }
    if (CheckinInfo.sexDecide(gender) == 2) {
        while (r % 2 != 0)
            r = (int) (Math.random() * 9);
    }
    if (r == 0) id += (r + 2);
    id += r;
    r = 0;
```

sexDecide方法与identityRecognition方法类似

## 总结

这个是我在学习面向对象程序设计时的练手程序，肯定会有很多不足，后面也会根据新学的内容添加更多的东西进去

于 2021 辛丑牛年 5 月 7 日 下午
