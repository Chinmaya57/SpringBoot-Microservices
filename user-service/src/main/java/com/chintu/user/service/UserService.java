package com.chintu.user.service;

import com.chintu.user.VO.Department;
import com.chintu.user.VO.ResponseTemplateVO;
import com.chintu.user.entity.User;
import com.chintu.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        log.info("inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(long userId) {
        log.info("inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo= new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"
                        + user.getDepartmentId(),
                Department.class);

        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
