package com.cyt.nstf.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cyt
 * @date 2023/11/10 16:05
 * @desc
 */
@Data
public class Lesson implements Serializable {
    private Integer LessonId;
    private String LessonName;
    private String Term;
}
