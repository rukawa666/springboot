package com.steven.springboot.exception;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-10 15:06
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
