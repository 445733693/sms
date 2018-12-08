package com.zju.sms.mapper;

import com.zju.sms.domain.AdminPermission;
import java.util.List;

public interface AdminPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminPermission record);

    AdminPermission selectByPrimaryKey(Integer id);

    List<AdminPermission> selectAll();

    int updateByPrimaryKey(AdminPermission record);

    void deleteByAdminId(Integer adminId);

    List<AdminPermission> selectByAdminId(Integer adminId);
}