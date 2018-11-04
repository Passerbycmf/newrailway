package zjnu.newrailway.project.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.newrailway.common.constant.UserConstants;
import zjnu.newrailway.common.utils.ShiroUtils;
import zjnu.newrailway.common.utils.StringUtils;
import zjnu.newrailway.framework.shiro.service.PasswordService;
import zjnu.newrailway.project.system.bean.Role;
import zjnu.newrailway.project.system.bean.UserRole;
import zjnu.newrailway.project.system.mapper.RoleMapper;
import zjnu.newrailway.project.system.mapper.UserMapper;
import zjnu.newrailway.project.system.bean.User;
import zjnu.newrailway.project.system.mapper.UserRoleMapper;
import zjnu.newrailway.project.system.service.IUserService;
import zjnu.newrailway.common.utils.Convert;

/**
 * 用户 服务层实现
 * 
 * @author cmf
 * @date 2018-11-01
 */
@Service
public class UserServiceImpl implements IUserService
{
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private RoleMapper roleMapper;


	@Autowired
	private PasswordService passwordService;


	/**
	 * 查询用户信息
	 *
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	@Override
	public User selectUserById(Integer userId)
	{
		return userMapper.selectUserById(userId);
	}

	/**
	 * 查询用户列表
	 *
	 * @param user 用户信息
	 * @return 用户集合
	 */
	@Override
	public List<User> selectUserList(User user)
	{
		return userMapper.selectUserList(user);
	}

	/**
	 * 新增用户
	 *
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int insertUser(User user)
	{
		user.randomSalt();
		user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
		user.setCreateBy(ShiroUtils.getLoginName());
		// 新增用户信息
		int rows = userMapper.insertUser(user);
		// 新增用户与角色管理
		insertUserRole(user);
		return rows;

	}

	/**
	 * 新增用户角色信息
	 *
	 * @param user 用户对象
	 */
	public void insertUserRole(User user)
	{
		// 新增用户与角色管理
		List<UserRole> list = new ArrayList<UserRole>();
		for (Integer roleId : user.getRoleIds())
		{
			UserRole ur = new UserRole();
			ur.setUserId(user.getUserId());
			ur.setRoleId(roleId);
			list.add(ur);
		}
		if (list.size() > 0)
		{
			userRoleMapper.batchUserRole(list);
		}
	}


	/**
	 * 修改用户
	 *
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int updateUser(User user)
	{
		Integer userId = user.getUserId();
		user.setUpdateBy(ShiroUtils.getLoginName());
		// 删除用户与角色关联
		userRoleMapper.deleteUserRoleByUserId(userId);
		// 新增用户与角色管理
		insertUserRole(user);
		return userMapper.updateUser(user);
	}



	/**
	 * 通过用户ID删除用户
	 *
	 * @param userId 用户ID
	 * @return 结果
	 */
	@Override
	public int deleteUserById(Integer userId)
	{
		// 删除用户与角色关联
		userRoleMapper.deleteUserRoleByUserId(userId);

		return userMapper.deleteUserById(userId);
	}

	/**
	 * 批量删除用户对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteUserByIds(String ids) throws Exception
	{
		Integer[] userIds = Convert.toIntArray(ids);
		for (Integer userId : userIds)
		{
			if (User.isAdmin(userId))
			{
				throw new Exception("不允许删除超级管理员用户");
			}
		}
		return userMapper.deleteUserByIds(userIds);
	}

	/**
	 * 修改用户密码
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int resetUserPwd(User user) {
		user.randomSalt();
		user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
		return updateUserInfo(user);
	}

	/**
	 * 校验用户名称是否唯一
	 * @param loginName 登录名称
	 * @return
	 */
	@Override
	public String checkLoginNameUnique(String loginName) {
		int count = userMapper.checkLoginNameUnique(loginName);
		if (count > 0){
			return UserConstants.USER_NAME_NOT_UNIQUE;
		}
		return UserConstants.USER_NAME_UNIQUE;
	}

	/**
	 * 校验手机号码是否唯一
	 * @param user 用户信息
	 * @return
	 */
	@Override
	public String checkPhoneUnique(User user) {
		Long userId = StringUtils.isNull(user.getUserId()) ? 1L : user.getUserId();
		User info = userMapper.checkPhoneUnique(user.getPhonenumber());
		if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()){
			return UserConstants.USER_PHONE_NOT_UNIQUE;
		}
		return UserConstants.USER_PHONE_UNIQUE;
	}

	/**
	 * 校验email是否唯一
	 * @param user 用户信息
	 * @return
	 */
	@Override
	public String checkEmailUnique(User user) {
		Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
		User info = userMapper.checkEmailUnique(user.getEmail());
		if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
		{
			return UserConstants.USER_EMAIL_NOT_UNIQUE;
		}
		return UserConstants.USER_EMAIL_UNIQUE;
	}

	/**
	 * 查询用户所属角色组
	 *
	 * @param userId 用户ID
	 * @return 结果
	 */
	@Override
	public String selectUserRoleGroup(Integer userId)
	{
		List<Role> list = roleMapper.selectRolesByUserId(userId);
		StringBuffer idsStr = new StringBuffer();
		for (Role role : list)
		{
			idsStr.append(role.getRoleName()).append(",");
		}
		if (StringUtils.isNotEmpty(idsStr.toString()))
		{
			return idsStr.substring(0, idsStr.length() - 1);
		}
		return idsStr.toString();
	}

	/**
	 * 修改用户个人详细信息
	 *
	 * @param user 用户信息
	 * @return 结果
	 */
	@Override
	public int updateUserInfo(User user)
	{
		return userMapper.updateUser(user);
	}

	/**
	 * 通过用户名查询用户
	 *
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	@Override
	public User selectUserByLoginName(String userName)
	{
		return userMapper.selectUserByLoginName(userName);
	}

	/**
	 * 通过手机号码查询用户
	 *
	 * @param phoneNumber 用户名
	 * @return 用户对象信息
	 */
	@Override
	public User selectUserByPhoneNumber(String phoneNumber)
	{
		return userMapper.selectUserByPhoneNumber(phoneNumber);
	}

	/**
	 * 通过邮箱查询用户
	 *
	 * @param email 邮箱
	 * @return 用户对象信息
	 */
	@Override
	public User selectUserByEmail(String email)
	{
		return userMapper.selectUserByEmail(email);
	}
	/**
	 * 修改用户个人详细信息
	 * @param user 用户信息
	 * @return
	 */
	private int updataUserInfo(User user) {
		return userMapper.updateUser(user);
	}






}
