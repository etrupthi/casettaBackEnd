package dao;

import models.User;

public interface UserDao extends CrudDao<User, String> {


   //User findUserByName(String username);
   User findUserByAuthToken(String accessToken);
}