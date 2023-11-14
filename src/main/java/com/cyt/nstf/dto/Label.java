package com.cyt.nstf.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cyt
 * @date 2023/11/14 19:18
 * @desc
 */

@Data
public class Label implements Serializable {
    private String label;
    private String value;

    public Label(String label, String value) {
        this.label = label;
        this.value = value;
    }
}
