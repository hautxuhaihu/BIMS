package tools;

import java.util.HashMap;
import java.util.List;

public class BuildSQL {

    private HashMap<String,String> map = new HashMap<>();

    public HashMap<String,String> setSql(String bool, String firstStr, List<String> list){
        if (bool.equals("0")){
            System.out.println(firstStr+list.get(0)+" like '%"+list.get(1)+"%'");
            bool="1";
            map.put("sql",firstStr+list.get(0)+" like '%"+list.get(1)+"%'");
        }else {
            System.out.println(firstStr+"and "+list.get(0)+" like '%"+list.get(1)+"%'");
            map.put("sql",firstStr+"and "+list.get(0)+" like '%"+list.get(1)+"%'");
        }
        map.put("bool",bool);
        return map;
    }
}
