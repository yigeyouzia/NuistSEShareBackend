package com.cyt.nstf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyt.nstf.common.R;
import com.cyt.nstf.dao.FileData;
import com.cyt.nstf.service.FileDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cyt
 * @date 2023/11/10 15:02
 * @desc
 */
@Slf4j
@RestController
@RequestMapping("/file")
@Api("文件信息模块")
public class FileDataController {

    @Resource
    private FileDataService fileDataService;


    @ApiOperation(value = "获取所有文件信息")
    @RequestMapping("/list")
    public R<List<FileData>> queryAllDataFile() {
        List<FileData> list = fileDataService.list();
        return R.success(list);
    }

    // @RequestMapping("/page")
    // public R<Page> page(int page, int pageSize) {
    //     log.info("page = {}, pageisze = {}", page, pageSize);
    //     Page<FileData> fileDataPage = new Page<>(page, pageSize);
    //     fileDataService.page(fileDataPage);
    //     return R.success(fileDataPage);
    // }

    @ApiOperation(value = "分页查询和模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = false),
            @ApiImplicitParam(name = "pageSize", value = "一页数据大小", required = false),
            @ApiImplicitParam(name = "term", value = "学期", required = false),
            @ApiImplicitParam(name = "lesson", value = "课程名", required = false),
            @ApiImplicitParam(name = "filename", value = "文件名关键字", required = false)
    })
    @RequestMapping("/page")
    public R<Page> page(Integer page, Integer pageSize, String term, String lesson, String filename) {
        log.info("page = {}, pageisze = {}, term={}, lesson={}, filename={}", page, pageSize, term, lesson, filename);
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 100;
        }
        if (term.equals("")) {
            term = null;
        }
        if (lesson.equals("")) {
            lesson = null;
        }
        if (filename.equals("")) {
            filename = null;
        }
        Page<FileData> fileDataPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<FileData> lqw = new LambdaQueryWrapper<>();
        lqw.eq(term != null, FileData::getFileTerm, term);
        lqw.eq(lesson != null, FileData::getFileBelongsToLesson, lesson);
        lqw.like(filename != null, FileData::getFileName, filename);
        fileDataService.page(fileDataPage, lqw);
        return R.success(fileDataPage);
    }
}
