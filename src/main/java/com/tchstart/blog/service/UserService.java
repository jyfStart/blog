package com.tchstart.blog.service;

import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import com.tchstart.blog.model.vo.UserVO;
import com.tchstart.blog.model.UserDetail;

/**
 * User Service
 *
 * @author tchstart
 */
public interface UserService {

	/**
	 * 根据用户名获取用户信息
	 */
	UserDetail getByUsername(@NonNull String username);

	/**
	 * 根据用户id获取用户信息
	 */
	UserDetail getByUserId(int userId);

	/**
	 * 根据id更新用户信息
	 */
	int updateProfile(int userId, UserVO userVO);

	/**
	 * 更新密码
	 */
	int updatePassword(int userId, String newPassword);

	/**
	 * 获取已登录的用户认证信息
	 */
	Authentication getAuth();

}
