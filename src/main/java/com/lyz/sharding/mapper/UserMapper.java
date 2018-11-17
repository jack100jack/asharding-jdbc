package com.lyz.sharding.mapper;

import java.util.List;
import com.lyz.sharding.entity.User;  
  
  
/**
 * �����û������ݲ����ӿ�
 * @author liuyazhuang
 *
 */
public interface UserMapper {  
      
    Integer insert(User u);  
      
    List<User> findAll();  
      
    List<User> findByUserIds(List<Integer> userIds);  
      
  
}  

