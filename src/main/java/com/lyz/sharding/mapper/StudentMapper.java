package com.lyz.sharding.mapper;

import java.util.List;
import com.lyz.sharding.entity.Student;
 
/**
 * ����ѧ�������ݲ����ӿ�
 * @author liuyazhuang
 *
 */
public interface StudentMapper {  
      
    Integer insert(Student s);  
      
    List<Student> findAll();  
      
    List<Student> findByStudentIds(List<Integer> studentIds);  
 
}  
