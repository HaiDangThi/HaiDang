package com.vti.railway41;

import com.vti.railway41.entity.Role;
import com.vti.railway41.entity.User;
import com.vti.railway41.repository.UserRepository;

import java.util.List;

import static com.vti.railway41.repository.UserRepository.createUser;
import static com.vti.railway41.repository.UserRepository.deleteById;

public class MainProgram {
    public static void main(String[] args) {
//        bai2();
//        bai3(20);
//        login();
//        bai4(1);
        taoUser();
    }

    static void bai2() {
        List<User> all = UserRepository.findAll();
        System.out.printf("%-10s | %-20s | %-15s\n", "ID", "FULL_NAME", "EMAIL");
        System.out.println("____________________________________________________________");
        for (User user : all) {
            System.out.printf("%-10s | %-20s | %-15s\n", user.getId(), user.getFullName(), user.getEmail());
        }
    }

    static void bai3(int id) {
        User user = UserRepository.findById(id);
        System.out.println(user);
    }

    static void bai4(int id) {
        boolean isDelete = deleteById(id);
        if (isDelete) {
            System.out.println("delete success");
        } else {
            System.out.println("Delete fail");
        }

    }

    static void bai5() {
        User user = new User();

        boolean isCreate = createUser(user);
        if (isCreate) {
            System.out.println("Create success");
        }
    }

    public static void taoUser() {
        User user = new User();
        user.setFullName("Nguyen Van A");
        user.setEmail("Anv@gmail.com");
        user.setPassword("A123456");
        user.setProjectId(30);
        user.setProSkill("java");
        user.setExpInYear(10);
        user.setRole(Role.MANAGER);
        boolean isCreate = createUser(user);
        if (isCreate) {
            System.out.println("Create success");
        }
    }
}


