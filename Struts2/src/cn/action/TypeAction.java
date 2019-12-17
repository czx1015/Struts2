package cn.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.entity.Type;
import cn.entity.User;
import cn.service.TypeService;
import cn.service.TypeServiceImpl;

public class TypeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 16 * 1024;
	private static final String path = "C:\\Users\\Administrator\\Desktop\\Struts2\\WebContent\\image";  //��ǰ��Ŀ����·��
	private Type type;
	private User user;
	private List<Type> types;
	private int id;
	private int role;
	private File image;//�ϴ��ļ������
	private String imageFileName;//�ϴ��ļ���
	private String imageContentType;//�ϴ��ļ�����
	//�����ļ������ķ���
	private void copy(File src,File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer))>0) {
				out.write(buffer,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if(null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			if(null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}
	}
	//�����Ʒ
	public String addType(){
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //������ʵʱʱ��ת��Ϊyyyy-MM-dd HH:mm:ss��ʽ
		String dstPath = path+"/"+this.getImageFileName();
		File dstFile = new File(dstPath);
		copy(this.image,dstFile);
		type.setDate(df.format(day));
		type.setId(type.getId());
		type.setImageFileName(imageFileName);
		TypeService ts = new TypeServiceImpl();
		   ts.addType(type);
		/*
		 * if (role < 2) { types = ts.selectMerchantsTypes(type.getUs_id());
		 * System.out.print(types);
		 * ActionContext.getContext().getValueStack().setValue("#session.types", types);
		 * }else { types = ts.selectTypes();
		 * ActionContext.getContext().getValueStack().setValue("#session.types", types);
		 * }
		 */
		   return "type";
		   }
	//��ѯ������Ʒ
	public String selectTypes() {
		TypeService ts = new TypeServiceImpl();
		types = ts.selectTypes();
		ActionContext.getContext().getValueStack().setValue("#session.types", types);
		return SUCCESS;
	}
	//�����̼�id��ѯ�Լ����е���Ʒ
	public String selectMerchantsTypes() {
		TypeService ts = new TypeServiceImpl();
		types = ts.selectMerchantsTypes(id);
		ActionContext.getContext().getValueStack().setValue("#session.types", types);
		return SUCCESS;
	}
	//����idɾ����Ʒ
		public String deleteType(){
			TypeService ts = new TypeServiceImpl();
			ts.deleteType(type.getId());
		/*
		 * if (role < 2) { types = ts.selectMerchantsTypes(type.getUs_id());
		 * ActionContext.getContext().getValueStack().setValue("#session.types", types);
		 * }else { types = ts.selectTypes();
		 * ActionContext.getContext().getValueStack().setValue("#session.types", types);
		 * }
		 */
			return SUCCESS;
		}
	//����id��ѯ��Ʒ��Ϣ
		public String selectType() {
			TypeService ts = new TypeServiceImpl();
			type = ts.selectType(id);
			ActionContext.getContext().getValueStack().setValue("#session.type", type);
			return SUCCESS;
		}
		//������Ʒid��ѯ��Ʒ��Ϣ�͵�����Ϣ
		public String selectUserType() {
			TypeService ts = new TypeServiceImpl();
			type = ts.selectUserType(id);
			ActionContext.getContext().getValueStack().setValue("#session.type", type);
			return SUCCESS;
		}
		//�޸���Ʒ��Ϣ
		 public String updateType() {
			 String dstPath = path+"/"+this.getImageFileName();
				File dstFile = new File(dstPath);
				copy(this.image,dstFile);
				type.setImageFileName(imageFileName);
			    TypeService ts = new TypeServiceImpl();
				ts.updateType(type);
		/*
		 * if (role < 2) { types = ts.selectMerchantsTypes(type.getUs_id());
		 * ActionContext.getContext().getValueStack().setValue("#session.types", types);
		 * }else { types = ts.selectTypes();
		 * ActionContext.getContext().getValueStack().setValue("#session.types", types);
		 * }
		 */
				return SUCCESS;
		 }
		 //����������ַ�������Ʒ���ƣ����ͺͼ�����ģ����ѯ
		 public String search() {
				TypeService ts = new TypeServiceImpl();
				types = ts.search(type);
				ActionContext.getContext().getValueStack().setValue("#session.types", types);
				return SUCCESS;
			}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}
		public List<Type> getTypes() {
			return types;
		}
		public void setTypes(List<Type> types) {
			this.types = types;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public File getImage() {
			return image;
		}
		public void setImage(File image) {
			this.image = image;
		}
		public String getImageFileName() {
			return imageFileName;
		}
		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}
		public String getImageContentType() {
			return imageContentType;
		}
		public void setImageContentType(String imageContentType) {
			this.imageContentType = imageContentType;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		}
