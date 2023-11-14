package com.cyt.nstf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyt.nstf.dao.FileData;
import com.cyt.nstf.mapper.FileDataMapper;
import com.cyt.nstf.service.FileDataService;
import org.springframework.stereotype.Service;

/**
 * @author cyt
 * @date 2023/11/10 15:01
 * @desc
 */
@Service
public class FileDataServiceImpl extends ServiceImpl<FileDataMapper, FileData> implements FileDataService {
}
