package com.atguigu.scheduleservice.service.impl;

import com.atguigu.scheduleservice.entity.EduSchedule;
import com.atguigu.scheduleservice.entity.vo.ScheduleQuery;
import com.atguigu.scheduleservice.mapper.EduScheduleMapper;
import com.atguigu.scheduleservice.service.EduScheduleService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 维修单 服务实现类
 * </p>
 *
 * @author AndrewBar
 * @since 2021-01-03
 */
@Service
public class EduScheduleServiceImpl extends ServiceImpl<EduScheduleMapper, EduSchedule> implements EduScheduleService {

    @Override
    public List<String> getPSOResult(ScheduleQuery scheduleQuery) {

        QueryWrapper<EduSchedule> wrapper = new QueryWrapper<>();
        String begin = scheduleQuery.getBegin();
        String end = scheduleQuery.getEnd();

        if (!StringUtils.isEmpty(begin)){//需要调度的开始和结束时间内的订单
            wrapper.ge("gmt_submit",begin);
        }

        if (!StringUtils.isEmpty(begin)){
            wrapper.le("gmt_submit",end);
        }

        //1 查询所有一级分类  parentid = 0
        QueryWrapper<EduSchedule> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id","0");
        List<EduSchedule> oneSubjectList = baseMapper.selectList(wrapperOne);
        oneSubjectList.size();//数量


        //2 查询所有二级分类  parentid != 0
        QueryWrapper<EduSchedule> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0");
        List<EduSchedule> twoSubjectList = baseMapper.selectList(wrapperTwo);

        return null;
    }
}
