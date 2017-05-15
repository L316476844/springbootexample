package org.jon.lv.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jon.lv.domain.User;
import org.jon.lv.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: org.jon.lv.mapper.UserMapper.java
 * @Description: InnoDB free: 4096 kB
 * @Copyright: Copyright (c) 2017
 * All right reserved.
 * Author jon lv
 * @date 2017/05/12 15:24
 * version v1.0.0
 */
//@Mapper
public interface UserMapper {
    /**
     * @Description: 根据主键删除数据库的记录
     * @Title deleteByPrimaryKey
     * @Author jon lv
     * @Date 2017/05/12 15:24
     * @param id
     * @return int
     * @throws []
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: 插入数据库记录
     * @Title insert
     * @Author jon lv
     * @Date 2017/05/12 15:24
     * @param record
     * @return int
     * @throws []
     */
    int insert(User record);

    /**
     * @Description: 选择性插入数据库记录
     * @Title insertSelective
     * @Author jon lv
     * @Date 2017/05/12 15:24
     * @param record
     * @return int
     * @throws []
     */
    int insertSelective(User record);

    /**
     * @Description: 根据主键获取一条数据库记录
     * @Title selectByPrimaryKey
     * @Author jon lv
     * @Date 2017/05/12 15:24
     * @param id
     * @return org.jon.lv.domain.User
     * @throws []
     */
    User selectByPrimaryKey(Integer id);

    /**
     * @Description: 根据主键来更新对应数据库字段
     * @Title updateByPrimaryKeySelective
     * @Author jon lv
     * @Date 2017/05/12 15:24
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * @Description: 根据主键来更新数据库记录
     * @Title updateByPrimaryKey
     * @Author jon lv
     * @Date 2017/05/12 15:24
     * @param record
     * @return int
     * @throws []
     */
    int updateByPrimaryKey(User record);

    List<User> queryPage(Page<User> page);
}