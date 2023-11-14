package com.cyt.nstf.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cyt
 * @date 2023/11/10 16:14
 * @desc
 */
@Data
public class LessonClassify implements Serializable {
    private String term;
    private String[] LessonTable;
}
