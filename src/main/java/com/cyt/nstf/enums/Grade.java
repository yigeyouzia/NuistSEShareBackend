package com.cyt.nstf.enums;

/**
 * @author cyt
 * @date 2023/11/10 16:32
 * @desc
 */
public enum Grade {
    GRADE1("大一下"),
    GRADE2("大二上"),
    GRADE3("大二下"),
    GRADE4("大三上"),
    ;

    private String grade;

    Grade(String name) {
        this.grade = name;
    }
}
