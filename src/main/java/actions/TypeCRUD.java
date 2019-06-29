package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.mapper.TypeDAOByMybatis;
import lombok.Getter;
import lombok.Setter;
import model.Type;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeCRUD extends ActionSupport implements ModelDriven<Type> {
    private Type type = new Type();

    @Override
    public Type getModel(){
        return type;
    }
    @Autowired
    @Setter
    @Getter
    TypeDAOByMybatis dao;
    @Getter @Setter
    List<Type> allType;
    
    public String addType() throws Exception {
        System.out.println(type.getName());
        int row = dao.add(type);
        return row > 0 ? SUCCESS : ERROR;
    }
    public String queryAllType() throws Exception{
        allType= dao.getAll();
        System.out.println(allType.get(0));
        return SUCCESS;
    }
}
