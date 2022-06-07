package com.example.restfulwebservice.user;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<User>();

    private static int usersCount =3;

    static {
        users.add(new User(1, "jkan", new Date(),"pas1","961211-111111"));
        users.add(new User(2, "shkim", new Date(),"pas2","961211-222222"));
        users.add(new User(3, "shlee", new Date(),"pas3","961211-333333"));
    }
        public List<User> findAll() {
            return users;
        }

        public User save(User user) {
            if (user.getId() == null) {
                user.setId(++usersCount);
            }
            users.add(user);
            return user;
        }

        public User findOne(int id) {
            for(User user : users){
                if(user.getId() == id) {
                    return user;
                }
            }
            return null;
        }

        public User deleteUser(int id){
            Iterator<User> iterator = users.iterator();

            while(iterator.hasNext()){
                User user = iterator.next();

                if(user.getId() == id){
                    iterator.remove();
                    return user;
                }
            }
        return null;
        }

    public User updateUser(User user){

        User updateUser = findOne(user.getId());

        String originName = user.getName();
        Date originJoinDate = user.getJoinDate();

        updateUser.setName(originName);
        updateUser.setJoinDate(originJoinDate);

         return updateUser;
    }
}
