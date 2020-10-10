package ru.guteam.customer_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.guteam.customer_service.entities.Customer;
import ru.guteam.customer_service.entities.Role;
import ru.guteam.customer_service.exceptions.ResourceNotFoundException;
import ru.guteam.customer_service.repositories.CustomersRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomersService {
    private CustomersRepository customersRepository;

    @Autowired
    public void setUsersRepository(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Customer findById(Long id) {
        return customersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Невозможно найти пользователя с id = " + id));
    }

    public Customer saveOrUpdate(Customer customer) {
        return customersRepository.save(customer);
    }

}