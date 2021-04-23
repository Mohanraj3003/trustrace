package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepo extends JpaRepository <User,Integer>  {


    @Modifying
    @Query("update User u SET name=?2 where id=?1")
    @Transactional
    void findNameReplace(int id, String value);

    @Modifying
    @Query("UPDATE User u SET mailId =?2 where id=?1")
    @Transactional
    void findMailReplace(int id, String value);

    @Modifying
    @Query("UPDATE User u SET address =?2 where id=?1")
    @Transactional
    void findAddressReplace(int id, String value);

    @Modifying
    @Query("UPDATE User u SET phone =?2 where id=?1")
    @Transactional
    void findPhoneReplace(int id, String value);

    @Modifying
    @Query("UPDATE User u SET name =null where id=?1")
    @Transactional
    void findNameDelete(int id);

    @Modifying
    @Query("UPDATE User u SET address=null where id=?1")
    @Transactional
    void findAddressDelete(int id);

    @Modifying
    @Query("UPDATE User u SET phone=null where id=?1")
    @Transactional
    void findPhoneDelete(int id);
}

