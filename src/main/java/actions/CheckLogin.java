package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.slf4j.Slf4j;
import model.User;
import dao.MyDAOImp;

import java.util.Map;
@Slf4j
public class CheckLogin extends ActionSupport implements ModelDriven<User> {

    private User user=new User();

    private ActionContext actionContext = ActionContext.getContext();
    private Map<String, Object> session=actionContext.getSession();
    @Override
    public String execute() throws Exception{
        MyDAOImp myDAOImp=new MyDAOImp();
        if(myDAOImp.checkLogin(user.getUsername(),user.getPassword())){
            session.put("usersession", user);
            User te = (User)session.get("usersession");
            System.out.println(te.getUsername());
            return SUCCESS;
        }else{
            addActionError(getText("LoginErr", new String[]{user.getUsername(),user.getPassword()}));
            return "input";
        }
    }

    public void validate(){
        if (user.getUsername().isEmpty()){
            addFieldError("username",getText("UserNameErr"));//乱码问题todo
        }
        if (user.getPassword().isEmpty()){
            addFieldError("password", getText("PassWordErr"));
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
