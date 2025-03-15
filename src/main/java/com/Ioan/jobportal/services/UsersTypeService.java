package com.Ioan.jobportal.services;


import com.Ioan.jobportal.entity.UsersType;
import com.Ioan.jobportal.repository.UsersTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {

    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeService) {
        this.usersTypeRepository = usersTypeService;
    }

    public List<UsersType> getAll(){
        return usersTypeRepository.findAll();
    }
}
