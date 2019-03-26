package com.cnpc.service;

import com.cnpc.model.UserDetail;
import com.cnpc.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//基础
public interface UserDetailService {
     Page<UserDetail> findByCondition(UserDetailParam userDetailParam, Pageable pageable);
}
