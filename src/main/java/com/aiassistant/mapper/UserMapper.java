package com.aiassistant.mapper;

import com.aiassistant.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * Inserts a user record into the database.
     *
     * @param user the user object to be inserted
     * @return the inserted user object
     */
    User insertUser(User user);

    /**
     * Retrieves a list of all user records from the database.
     *
     * @return a list of user objects
     */
    List<User> getUserList();

    /**
     * Retrieves a user record from the database based on the user ID.
     *
     * @param userId the ID of the user to be retrieved
     * @return the user object with the specified ID
     */
    User selectById(String userId);

    /**
     * Deletes a user record from the database based on the user ID.
     *
     * @param userId the ID of the user to be deleted
     */
    void deleteUser(String userId);

    /**
     * Updates the password of a user record in the database based on the user ID.
     *
     * @param userId       the ID of the user to be updated
     * @param newPassword the new password to be set
     */
    void updatePassword(String userId, String newPassword);

    /**
     * Updates the phone number of a user record in the database based on the user ID.
     *
     * @param userId          the ID of the user to be updated
     * @param newPhoneNumber the new phone number to be set
     */
    void updatePhoneNumber(String userId, String newPhoneNumber);
}
