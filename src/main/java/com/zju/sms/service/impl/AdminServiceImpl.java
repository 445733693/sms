package com.zju.sms.service.impl;

import com.zju.sms.mapper.AdminMapper;
import com.zju.sms.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService{
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void save(Admin admin) {
        admin.setAddDate(new Date());
        admin.setLoginDate(new Date());
        admin.setP_adminList(false);
        admin.setP_agentList(false);
        admin.setP_agentRecharge(false);
        admin.setP_agentRechargeRecord(false);
        admin.setP_announcement(false);
        admin.setP_blackWhiteList(false);
        admin.setP_changePassword(false);
        admin.setP_configureDeduction(false);
        admin.setP_channel(false);
        admin.setP_keyword(false);
        admin.setP_loginTime(false);
        admin.setP_messageReview(false);
        admin.setP_phoneLib(false);
        admin.setP_rechargeSolution(false);
        admin.setP_sendRecord(false);
        admin.setP_userExpenseRecord(false);
        admin.setP_userList(false);
        admin.setP_userRecharge(false);
        admin.setP_userRechargeRecord(false);
        adminMapper.insert(admin);
    }

    @Override
    public void delete(String adminId) {
        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public Admin get(String adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectAll();
    }
}
