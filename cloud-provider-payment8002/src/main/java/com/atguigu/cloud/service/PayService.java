package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Date: 2024/04/11 16:08</p>
 *
 * @author cuiyy
 * @version v1.0.0
 **/
public interface PayService {

    int add(Pay pay);

    int update(Pay pay);

    int delete(Integer id);

    Pay getById(Integer id);

    List<Pay> getAll();

}
