package com.cyt.nstf.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cyt
 * @date 2023/11/10 14:56
 * @desc
 */
@Data
public class FileData implements Serializable {
    private String FileId;
    private String FileBelongsToLesson;
    private String FileName;
    private String FileType;
    private Long FileSize;
    private String FilePath;
    private String FileTerm;
}
