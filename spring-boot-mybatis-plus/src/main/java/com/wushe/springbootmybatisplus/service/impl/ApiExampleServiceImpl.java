package com.wushe.springbootmybatisplus.service.impl;

import com.wushe.springbootmybatisplus.model.ApiExampleBean;
import com.wushe.springbootmybatisplus.mapper.ApiExampleMapper;
import com.wushe.springbootmybatisplus.service.ApiExampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模拟数据 服务实现类
 * </p>
 *
 * @author jtb
 * @since 2020-12-14
 */
@Service
public class ApiExampleServiceImpl extends ServiceImpl<ApiExampleMapper, ApiExampleBean> implements ApiExampleService {

}
