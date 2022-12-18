package com.example.doan.repository;

import com.example.doan.model.Role;
import com.example.doan.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserRepoImp implements UserRepo {
    public static ArrayList<User> arrayListUser;

//    @Autowired
//    PasswordEncoder passwordEncoder ;

@PostConstruct
    public void init() {
        ArrayList<Role> arrayRole1 =new ArrayList<>();
        arrayRole1.add(new Role("ROLE_USER"));
        ArrayList<Role> arrayRole2 = new ArrayList<>();
        arrayRole2.add(new Role("ROLE_ADMIN"));
        BCryptPasswordEncoder passEncode = new BCryptPasswordEncoder();
        arrayListUser = new ArrayList<User>();
        arrayListUser.add(new User(1L, "Jhon Travolate", "transachthien",passEncode.encode("1234"), arrayRole1));
        arrayListUser.add(new User(3L, "Jim Carry", "danghoaisonnam", passEncode.encode("1234"), arrayRole2));

        }

//    @Override
//    public User findByUsername(String username) {
//        for(User x : arrayListUser){
//            if(x.getUsername().equals(username)){
//                return x;
//            }
//        }
//        return null;
//    }
    @Override
    public User findByUsername(String username){
        List<User> users = arrayListUser
                .stream()
                .filter(c -> c.getUsername().equals(username)).collect(toList());
        if(users.size() >=1){
            return users.get(0);
        }
        else{
            return null;
        }

    }


    @Override
    public List<User> findAll() {
        return arrayListUser;
    }
}
