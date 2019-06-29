package actions;

import dao.mapper.PressDAOByMybatis;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Getter;
import lombok.Setter;
import model.Press;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PressCRUD extends ActionSupport implements ModelDriven<Press> {
    private Press press = new Press();

    @Getter @Setter
    List<Press> allPress;

    @Autowired
    @Setter @Getter
    PressDAOByMybatis dao;

    @Override
    public Press getModel(){
        return press;
    }

    public String addPress() throws Exception {
        System.out.println(press.getName());
        int row = dao.add(press);
        return row > 0 ? SUCCESS : ERROR;
    }
    public String queryAllPress() throws Exception{
        allPress= dao.getAll();
        System.out.println(allPress.get(0));
        return SUCCESS;
    }
}
