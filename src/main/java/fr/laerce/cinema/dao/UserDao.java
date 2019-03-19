package fr.laerce.cinema.dao;

import fr.laerce.cinema.model.Film;
import fr.laerce.cinema.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

   //Qaund on ne peut pas faire de requête dsl de jpa repository on utilise les requetes jpql avec l'annotation @Query
   @Query("select u from User u order by u.givenname")
   Set<User> findAllByGivenname();



}
