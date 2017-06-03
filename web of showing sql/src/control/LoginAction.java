package control;
public class LoginAction {
	static final String ok="ok";
	static final String f="f";
	private String user=null;
	public String getUser(){
		return user;
	}
	public void setUser(String u){
		user=u;
	}
	public String execute(){
		if(getUser().equals("1"))
		return ok;
		else return f;
	}
}
