package com.cyt.nstf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyt.nstf.dao.Lesson;
import com.cyt.nstf.mapper.LessonMapper;
import com.cyt.nstf.service.LessonService;
import org.springframework.stereotype.Service;

/**
 * @author cyt
 * @date 2023/11/10 16:07
 * @desc
 */
@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson> implements LessonService {
}
