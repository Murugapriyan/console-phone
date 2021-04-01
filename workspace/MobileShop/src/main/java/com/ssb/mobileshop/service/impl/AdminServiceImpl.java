package com.ssb.mobileshop.service.impl;

import com.ssb.mobileshop.dao.Admindao;
import com.ssb.mobileshop.model.Admin;
import com.ssb.mobileshop.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private static AdminServiceImpl adminService;
    //Singleton Instance for AdminServiceImpl
    public static AdminServiceImpl getInstance() {
        if (adminService == null) {
            adminService = new AdminServiceImpl();
        }
        return adminService;
    }
     //Login Validation for Admin
    @Override
    public Admin loginValidation(Admin admin) throws Exception {

        Admin login = Admindao.getInstance().getAdminDetails(admin);
        if ((login.getAdminName().equals(admin.getAdminName()))) {
            if ((login.getAdminPaswd().equals(admin.getAdminPaswd()))) {
                return login;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
