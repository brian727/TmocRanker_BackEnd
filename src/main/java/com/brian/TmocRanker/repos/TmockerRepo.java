package com.brian.TmocRanker.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brian.TmocRanker.entities.Tmocker;
import org.springframework.stereotype.Repository;


@Repository
public interface TmockerRepo extends JpaRepository<Tmocker, Long> {

//    List<Tmocker> findByTmocker_id(long tmocker_id);
    List<Tmocker> findByEmail(String email);
//    List<Tmocker> findByZipcode(int zipcode);


}

//        @Query("from Tmocker")
//	List<Tmocker> findAllTmockers();
//
//	@Query("select t.firstname, t.lastname, t.email, t.zipcode from Tmocker t")
//	List<Object[]> findAllTmockersPartial();
//
//	@Query("from Tmocker where id=:id")
//	List<Tmocker> findAllTmockersById(@Param("id")long l);

