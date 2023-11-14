package com.cyt.nstf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyt.nstf.common.R;
import com.cyt.nstf.dao.Lesson;
import com.cyt.nstf.dto.Label;
import com.cyt.nstf.service.LessonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cyt
 * @date 2023/11/10 16:08
 * @desc
 */
@RestController
@RequestMapping("/lessons")
@Slf4j
@Api("课程模块")
public class LessonController {
    @Resource
    private LessonService lessonService;

    @ApiOperation(value = "获取年级列表")
    @RequestMapping("/classify/list")
    public R<ArrayList<Label>> getTerms() {
        List<Lesson> list = lessonService.list();
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("",""));
        list.stream().map(Lesson::getTerm).distinct().forEach(term -> labels.add(new Label(term, term)));
        return R.success(labels);
    }

    @ApiOperation(value = "根据年级获取课程")
    @ApiImplicitParams({@ApiImplicitParam(name = "grade", value = "年级", required = true)})
    @RequestMapping("/classify") // R<List<LessonClassify>>
    public R<ArrayList<Label>> getLessonsClassify(String term) {
        LambdaQueryWrapper<Lesson> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Lesson::getTerm, term);
        List<Lesson> list = lessonService.list(queryWrapper);
        ArrayList<Label> labels = new ArrayList<>();
        labels.add(new Label("",""));
        list.stream().map(Lesson::getLessonName).forEach(lesson -> labels.add(new Label(lesson, lesson)));
        log.info("list res: {}", labels);
        return R.success(labels);
    }
}
