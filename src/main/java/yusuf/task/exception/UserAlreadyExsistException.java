package yusuf.task.exception;

import yusuf.task.model.entity.User;

public class UserAlreadyExsistException extends Exception {

    public UserAlreadyExsistException(User user) {
        super(String.format("%s user email or %s telephone already exsist!", user.getEmail(), user.getTelephone()));
    }

}
