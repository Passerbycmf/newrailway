package zjnu.newrailway.project.monitor.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import zjnu.newrailway.common.utils.ShiroUtils;
import zjnu.newrailway.framework.aspectj.lang.annotation.Log;
import zjnu.newrailway.framework.aspectj.lang.constant.BusinessType;
import zjnu.newrailway.framework.shiro.session.OnlineSessionDAO;
import zjnu.newrailway.framework.web.AjaxResult;
import zjnu.newrailway.framework.web.BaseController;
import zjnu.newrailway.framework.web.TableDataInfo;
import zjnu.newrailway.project.monitor.bean.OnlineSession;
import zjnu.newrailway.project.monitor.bean.UserOnline;
import zjnu.newrailway.project.monitor.service.IUserOnlineService;


import java.util.List;

/**
 * 在线用户记录 信息操作处理
 * 
 * @author cmf
 * @date 2018-10-11
 */
@Controller
@RequestMapping("/monitor/userOnline")
public class UserOnlineController extends BaseController
{
    private String prefix = "monitor/userOnline";
	
	@Autowired
	private IUserOnlineService userOnlineService;

	@Autowired
	private OnlineSessionDAO onlineSessionDAO;

	@RequiresPermissions("monitor:online:view")
	@GetMapping()
	public String userOnline()
	{
	    return prefix + "/userOnline";
	}
	
	/**
	 * 查询在线用户记录列表
	 */
	@RequiresPermissions("monitor:online:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserOnline userOnline)
	{
		startPage();
        List<UserOnline> list = userOnlineService.selectUserOnlineList(userOnline);
		return getDataTable(list);
	}

	/**
	 *在线用户
	 */
	@RequiresPermissions("monitor:online:batchForceLogout")
	@Log(title = "在线用户", action = BusinessType.FORCE)
	@PostMapping("/batchForceLogout")
	@ResponseBody
	public AjaxResult batchForceLogout(@RequestParam("ids[]") String[] ids)
	{
		for (String sessionId : ids)
		{
			UserOnline online = userOnlineService.selectOnlineById(sessionId);
			if (online == null)
			{
				return error("用户已下线");
			}
			OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
			if (onlineSession == null)
			{
				return error("用户已下线");
			}
			if (sessionId.equals(ShiroUtils.getSessionId()))
			{
				return error("当前登陆用户无法强退");
			}
			onlineSession.setStatus(OnlineSession.OnlineStatus.off_line);
			online.setStatus(OnlineSession.OnlineStatus.off_line);
			userOnlineService.saveOnline(online);
		}
		return success();
	}

	/**
	 * 强制下线
	 * @param sessionId
	 * @return
	 */
	@RequiresPermissions("monitor:online:forceLogout")
	@Log(title = "在线用户", action = BusinessType.FORCE)
	@PostMapping("/forceLogout")
	@ResponseBody
	public AjaxResult forceLogout(String sessionId)
	{
		UserOnline online = userOnlineService.selectOnlineById(sessionId);
		if (sessionId.equals(ShiroUtils.getSessionId()))
		{
			return error("当前登陆用户无法强退");
		}
		if (online == null)
		{
			return error("用户已下线");
		}
		OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
		if (onlineSession == null)
		{
			return error("用户已下线");
		}
		onlineSession.setStatus(OnlineSession.OnlineStatus.off_line);
		online.setStatus(OnlineSession.OnlineStatus.off_line);
		userOnlineService.saveOnline(online);
		return success();
	}

	/**
	 * 新增在线用户记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存在线用户记录
	 */
	@RequiresPermissions("monitor:online:add")
	@Log(title = "在线用户记录", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(UserOnline userOnline)
	{		
		return toAjax(userOnlineService.insertUserOnline(userOnline));
	}

	/**
	 * 修改在线用户记录
	 */
	@GetMapping("/edit/{sessionId}")
	public String edit(@PathVariable("sessionId") String sessionId, ModelMap mmap)
	{
		UserOnline userOnline = userOnlineService.selectUserOnlineById(sessionId);
		mmap.put("userOnline", userOnline);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存在线用户记录
	 */
	@RequiresPermissions("monitor:online:edit")
	@Log(title = "在线用户记录", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(UserOnline userOnline)
	{		
		return toAjax(userOnlineService.updateUserOnline(userOnline));
	}
	
	/**
	 * 删除在线用户记录
	 */
	@RequiresPermissions("monitor:online:remove")
	@Log(title = "在线用户记录", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userOnlineService.deleteUserOnlineByIds(ids));
	}
	
}
