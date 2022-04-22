/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vanthuandev.repository;

import com.vanthuandev.pojos.User;
import java.util.List;

/**
 *
 * @author ngova
 */
public interface UserRepository {
    User getUserById(int userId);
    boolean addUser(User user);
    List<User> getUsers(String username);
}
