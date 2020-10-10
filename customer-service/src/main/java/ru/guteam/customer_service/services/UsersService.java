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
import ru.guteam.customer_service.entities.User;
import ru.guteam.customer_service.entities.Role;
import ru.guteam.customer_service.entities.utils.SystemRestaurant;
import ru.guteam.customer_service.repositories.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService implements UserDetailsService {
    private UserRepository userRepository;
    private RolesService rolesService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUsersRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
                true, true, user.isEnable(), mapRolesToAuthorities(Arrays.asList(user.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public User findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Невозможно найти пользователя по логину = " + username));
    }

    public Optional<User> findOptionalByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }


    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User save(SystemRestaurant systemRestaurant) {
        User user = new User();
        Customer customer = new Customer();
        customer.setId(systemRestaurant.getRestaurantId());
        user.setCustomer(customer);
        user.setPassword(passwordEncoder.encode(systemRestaurant.getPassword()));
        user.setFirstName(systemRestaurant.getFirstName());
        user.setLastName(systemRestaurant.getLastName());
        user.setEmail(systemRestaurant.getEmail());
        user.setEnable(true);
        user.setRoles(Arrays.asList(rolesService.findByName("ROLE_CUSTOMER")));
        return usersRepository.save(user);
    }

}