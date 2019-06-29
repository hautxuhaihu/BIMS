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
        if(myDAOImp.checkLogin(user.getId(),user.getPassword())){
            session.put("usersession", user);
            User user = (User)session.get("usersession");
            System.out.println(user.getId());
            return SUCCESS;
        }else{
            addActionError(getText("LoginErr", new String[]{user.getId(),user.getPassword()}));
            return "input";
        }
    }

    public void validate(){
        if (user.getId().isEmpty()){
            addFieldError("id",getText("idErr"));//乱码问题todo
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
