package com.service;

import com.pojo.Manager;

public interface ManagerService {
    Manager login(String username, String password);
}
