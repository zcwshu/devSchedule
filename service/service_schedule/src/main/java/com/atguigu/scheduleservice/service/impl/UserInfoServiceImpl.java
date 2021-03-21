package com.atguigu.scheduleservice.service.impl;

import com.atguigu.scheduleservice.entity.UserInfo;
import com.atguigu.scheduleservice.mapper.UserInfoMapper;
import com.atguigu.scheduleservice.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AndrewBar
 * @since 2021-03-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
