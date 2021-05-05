package org.sci.finalproj.repo;

import org.sci.finalproj.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    // findBy => predefined syntax
    public User findByUserName(String userName);

//    @Query("SELECT u FROM User u WHERE u.userName = ?1 and u.name = ?2")
//    public User customQuery(String userName, String name);
//
//    @Query("SELECT u FROM User u WHERE u.userName = :#{#jmn.userName}")
//    public User customQuery1(@Param("jmn") User user);
//
//    @Query("SELECT u from User u WHERE u.userName = :username")
//    User findByUserNameParam(@Param("username") final String username);

//    public boolean updateByName
//    public boolean deleteByUserName

//    public void createUser() {
//
//    }
//
//    public void updateUser() {
//
//    }
//
//    public void getUser() {
//
//    }
//
//    public void deleteUser() {
//
//    }



}
