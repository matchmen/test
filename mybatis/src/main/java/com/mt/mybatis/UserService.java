package com.mt.mybatis;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mt.mybatis.entity.User;

/**
 * author: liqm
 * 2020-01-07
 */
public interface UserService {

    void add(User user);

    void update(User user);

    void delete(Integer id);

    User getById(Integer id);

    Page<User> listPage(Page page);

}
