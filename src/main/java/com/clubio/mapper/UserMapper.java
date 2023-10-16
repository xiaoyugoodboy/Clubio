package com.clubio.mapper;

import com.clubio.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
