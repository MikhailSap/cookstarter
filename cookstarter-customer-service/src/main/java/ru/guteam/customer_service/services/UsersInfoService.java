package ru.guteam.customer_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guteam.customer_service.entities.UsersInfo;
import ru.guteam.customer_service.entities.User;
import ru.guteam.customer_service.entities.utils.SystemUser;
import ru.guteam.customer_service.repositories.UsersInfoRepository;

import java.util.Optional;

@Service
public class UsersInfoService {
    private UsersInfoRepository usersInfoRepository;
    private UsersService usersService;
    @Autowired
    public void setUsersRepository(UsersInfoRepository customersRepository) {
        this.usersInfoRepository = customersRepository;
    }
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }


    @Transactional
    public UsersInfo saveBySystemUser(SystemUser systemUser) {
        final UsersInfo usersInfo = new UsersInfo();
        usersInfo.setFirstName(systemUser.getFirstName());
        usersInfo.setLastName(systemUser.getLastName());
        usersInfo.setEmail(systemUser.getEmail());
        User user = usersService.createBySystemCustomer(systemUser);
        user.setUsersInfo(usersInfo);
        usersInfo.setUser(user);
        return usersInfoRepository.save(usersInfo);
    }

}