package com.subodh.springbooot.service;

import java.util.List;

import com.subodh.springbooot.entity.RegisterEntity;

public interface MysqlService {

	List<RegisterEntity> getAllRegisterRecords();

}
