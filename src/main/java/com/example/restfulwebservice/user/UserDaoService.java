package com.example.restfulwebservice.user;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<Users> users = new ArrayList<Users>();

    private static int usersCount =3;

    static {
        users.add(new Users(1, "jkan", new Date(),"pas1","961211-111111"));
        users.add(new Users(2, "shkim", new Date(),"pas2","961211-222222"));
        users.add(new Users(3, "shlee", new Date(),"pas3","961211-333333"));
    }
        public List<Users> findAll() {
            return users;
        }

        public Users save(Users user) {
            if (user.getUserId() == null) {
                user.setUserId(++usersCount);
            }
            users.add(user);
            return user;
        }

        public Users findOne(int id) {
            for(Users user : users){
                if(user.getUserId() == id) {
                    return user;
                }
            }
            return null;
        }

        public Users deleteUser(int id){
            Iterator<Users> iterator = users.iterator();

            while(iterator.hasNext()){
                Users user = iterator.next();

                if(user.getUserId() == id){
                    iterator.remove();
                    return user;
                }
            }
        return null;
        }

    public Users updateUser(Users user){

        Users updateUser = findOne(user.getUserId());

        String originName = user.getUserName();
        Date originJoinDate = user.getJoinDate();

        updateUser.setUserName(originName);
        updateUser.setJoinDate(originJoinDate);

         return updateUser;
    }
}
