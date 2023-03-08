package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.annotation.PostConstruct;

@Component
public class Init {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Init(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Transactional
    public void doInit() {
        Role roleUser = new Role("ROLE_USER");
        Role roleAdmin = new Role("ROLE_ADMIN");
        roleDao.save(roleAdmin);
        roleDao.save(roleUser);

        User user = new User();
        user.setAge(10);
        user.setEmail("Admin@mail.ru");
        user.setFirstName("Misha");
        user.setLastName("Adminov");
        user.setPassword(passwordEncoder.encode("admin"));
        user.getRoles().add(roleDao.findRoleByRole("ROLE_ADMIN"));
        userDao.save(user);

        user = new User();
        user.setAge(20);
        user.setEmail("User@mail.ru");
        user.setFirstName("Serega");
        user.setLastName("Userov");
        user.setPassword(passwordEncoder.encode("user"));
        user.getRoles().add(roleDao.findRoleByRole("ROLE_USER"));
        userDao.save(user);
    }
}
