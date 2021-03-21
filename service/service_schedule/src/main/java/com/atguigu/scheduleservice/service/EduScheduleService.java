package com.atguigu.scheduleservice.service;

import com.atguigu.scheduleservice.entity.EduSchedule;
import com.atguigu.scheduleservice.entity.vo.ScheduleQuery;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 维修单 服务类
 * </p>
 *
 * @author AndrewBar
 * @since 2021-01-03
 */
public interface EduScheduleService extends IService<EduSchedule> {

    List<String> getPSOResult(ScheduleQuery scheduleQuery);
}
