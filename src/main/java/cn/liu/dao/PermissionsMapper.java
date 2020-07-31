package cn.liu.dao;

import cn.liu.pojo.Permissions;

import java.util.List;

public interface PermissionsMapper {
    
    int deleteByPrimaryKey(Integer permissionsId);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer permissionsId);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);

    List<Permissions> queryRolesBypri(String pri);
}