package com.aiassistant.service;

import com.aiassistant.model.User;
import com.aiassistant.utils.ResultModel;

public interface UserService {
    /**
     * Adds a new user to the system.
     *
     * @param user the user to be added
     * @return the result model containing the added user
     */
    ResultModel<User> addUser(User user);

    /**
     * Retrieves a user by their ID.
     *
     * @param userId the ID of the user to be retrieved
     * @return the result model containing the retrieved user
     */
    ResultModel<User> getUserById(String userId);

    /**
     * Updates the information of an existing user.
     *
     * @param user the updated user information
     * @return the result model containing the updated user
     */
    ResultModel<User> updateUser(User user);

    /**
     * Deletes a user from the system.
     *
     * @param userId the ID of the user to be deleted
     * @return the result model containing the deleted user
     */
    ResultModel<User> deleteUser(String userId);

    /**
     * Updates the password of an existing user.
     *
     * @param userId       the ID of the user
     * @param newPassword the new password
     * @return the result model containing the updated user
     */
    ResultModel<User> updatePassword(String userId, String newPassword);

    /**
     * Updates the phone number of an existing user.
     *
     * @param userId          the ID of the user
     * @param newPhoneNumber the new phone number
     * @return the result model containing the updated user
     */
    ResultModel<User> updatePhoneNumber(String userId, String newPhoneNumber);

    /**
     * Changes the password of an existing user.
     *
     * @param userId       the ID of the user
     * @param newPassword the new password
     * @return the result model containing the updated user
     */
    ResultModel<User> changePassword(String userId, String newPassword);

    /**
     * Changes the phone number of an existing user.
     *
     * @param userId          the ID of the user
     * @param newPhoneNumber the new phone number
     * @return the result model containing the updated user
     */
    ResultModel<User> changePhoneNumber(String userId, String newPhoneNumber);
}