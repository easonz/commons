package org.eason.common.utils.enums;

import java.lang.reflect.Field;

public enum EnumCode {

	@EnumItemAnno(desc="无错误")
	No_Err,                         

	@EnumItemAnno(desc="添加用户时的错误，数据库中已存在了您要添加的用户")
	Err_UserAlreadyExist,           
	@EnumItemAnno(desc="用户名不存在")
	Err_UserNotExist,               
	@EnumItemAnno(desc="用户改名，新名字已存在")
	Err_UserNewNameAlreadyExist,    
	@EnumItemAnno(desc="用户名为空")
	Err_UserNameEmpty,              
	@EnumItemAnno(desc="用户密码为空")
	Err_UserPwdEmpty;


	public int value() {
		return this.ordinal();
	}
	
	public static EnumCode valueOf(int ordinal) {
		if (ordinal < 0 || ordinal >= values().length) {
			throw new IndexOutOfBoundsException("Invalid ordinal");
		}
		return values()[ordinal];
	}
	
	public String getDesc() {

		Field field = null;
		try {
			field = this.getClass().getDeclaredField(this.name());
		} catch (SecurityException e) {
			e.printStackTrace();
			return "";
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			return "";
		}

		EnumItemAnno item = field.getAnnotation(EnumItemAnno.class);
		return item.desc();
	}
}

