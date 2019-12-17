package cn.action;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.entity.User;
import cn.service.UserService;
import cn.service.UserServiceImpl;
import cn.util.VerifyCodeUtil;


public class UserAction extends ActionSupport{

	/**11.1
	 *陈贞校
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private User user;
	private int id;
	private String name;
	private String pwd;
	private String role;
	private String code;
	    //验证码
		public String yanzhengma() throws Exception {
			String code1 = VerifyCodeUtil.generateVerifyCode(4);
			ActionContext.getContext().getValueStack().setValue("#session.code1", code1);
			BufferedImage image = VerifyCodeUtil.getImage(160, 40, code1);
			ServletOutputStream os = ServletActionContext.getResponse().getOutputStream();
			ImageIO.write(image, "png", os);
			return NONE;
		}
		
		//用户登录
	    public String login(){
	    		UserService us = new UserServiceImpl();
	    		String code1 = ActionContext.getContext().getValueStack().findString("#session.code1");
	    		if(code1.equalsIgnoreCase(code)){
	    		User user = us.loginUser(name, pwd);
	    		if(user!=null){
	    			ActionContext.getContext().getValueStack().setValue("#session.user", user);
	    			if (user.getRole().equals("2")) {
						return "admin";
					}if (user.getRole().equals("1")) {
						return "merchants";
					}if (user.getRole().equals("0")) {
						return "clients";
					}
	    		}
	    		JOptionPane.showMessageDialog(null, "用户名或密码错误！", "错误信息",0);
	    		return ERROR;
	    		}
	    		return ERROR;
	    	}
	    //仅用作跳转到用户添加页，无逻辑  
	    public String add(){
    		return SUCCESS;
    	}
		//用户注册检验用户名
		public void ajax() throws IOException{
			//获得要校验的用户名
	        //传递username到service
			UserService us = new UserServiceImpl();
			boolean isExist = us.selectName(user.getName());
			HttpServletResponse response = ServletActionContext.getResponse();
	        response.getWriter().write("{\"isExist\":"+isExist+"}");			  
		}
		//用户注册
		public String register() {
			UserService us = new UserServiceImpl();
			boolean isExist = us.selectName(user.getName());
			if (isExist) {
				JOptionPane.showMessageDialog(null, "用户名已存在！", "错误信息", 0);
				return "register";
			}else {
			us.registerUser(user);
			return "login";
			}
		}
		//查询所有用户信息
		public String selectUsers() {
			UserService cs = new UserServiceImpl();
			users = cs.selectUsers();
			ActionContext.getContext().getValueStack().setValue("#session.users", users);
			return SUCCESS;
		}
		//根据id删除用户信息
			public String deleteUser(){
				UserService cs = new UserServiceImpl();
				cs.deleteUser(id);
				users = cs.selectUsers();
				ActionContext.getContext().getValueStack().setValue("#session.users", users);
				return SUCCESS;
			}
		//根据id查询用户信息
			public String selectUser() {
				UserService cs = new UserServiceImpl();
				user = cs.selectUser(id);
				ActionContext.getContext().getValueStack().setValue("#session.user1", user);
				return SUCCESS;
			}
		//修改用户信息
			 public String updateUser() {
				 UserService cs = new UserServiceImpl();
					cs.updateUser(user);
					users = cs.selectUsers();
					ActionContext.getContext().getValueStack().setValue("#session.users", users);
					JOptionPane.showMessageDialog(null, "修改成功", "提示信息",1);
					return SUCCESS;
			 }
	public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
	public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}