package com.demo.dbservice.dbservice.service.impl;

import com.demo.dbservice.dbservice.model.User;
import com.demo.dbservice.dbservice.repository.UserRepository;
import com.demo.dbservice.dbservice.service.UserService;
import com.netflix.discovery.converters.Auto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Override
    public List<User> getAllUsers() {
        List<User> listOfUsersResult = new ArrayList<>();
        List<com.demo.dbservice.dbservice.entities.User> listOfUserEntities = userRepository.findAll();
        mapperFactory.classMap(com.demo.dbservice.dbservice.entities.User.class, User.class).byDefault();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        if (listOfUserEntities != null ) {
            listOfUserEntities.forEach(userEntity -> listOfUsersResult.add(mapper.map(userEntity, User.class)));
        }
        return listOfUsersResult;
    }

    @Override
    public User getUserByUsername(String userId){
        User user;
        mapperFactory.classMap(com.demo.dbservice.dbservice.entities.User.class, User.class).byDefault();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        com.demo.dbservice.dbservice.entities.User userDetail = userRepository.findByuserid(userId);
        user = mapper.map(userDetail, User.class);
        return user;
    }

    @Override
    public User addUser(User user) {
        User result;
        mapperFactory.classMap(User.class, com.demo.dbservice.dbservice.entities.User.class).byDefault();
        MapperFacade mapperModelToEntity = mapperFactory.getMapperFacade();
        com.demo.dbservice.dbservice.entities.User resultAfterSave = userRepository.save(mapperModelToEntity.map(user, com.demo.dbservice.dbservice.entities.User.class));
        mapperFactory.classMap(com.demo.dbservice.dbservice.entities.User.class, User.class).byDefault();
        MapperFacade mapperEntityToModel = mapperFactory.getMapperFacade();
        result = mapperEntityToModel.map(resultAfterSave, User.class);
        return result;
    }
}
