package dao;

import model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyDAOImp implements MyDAO {

    @Override
    public boolean checkLogin(String username, String password) throws Exception {
        boolean isSuc=false;
        Class.forName(driver);
        String sql="select * from tea where name=? and password=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt=con.prepareStatement(sql)){
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            try(ResultSet rs=pstmt.executeQuery()){
                isSuc=rs.next();
            }
        }
        return isSuc;
    }
    @Override
    public List<String[]> getAllBooks() throws Exception{
        List<String[]> stus=new ArrayList<String[]>();
        String sql="select * from stu";
        Class.forName(driver);
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            try(ResultSet rs=pstmt.executeQuery()){
                while(rs.next()){
                    String[] row=new String[5];
                    row[0]=rs.getString("id");
                    row[1]=rs.getString("name");
                    row[2]=rs.getString("age");
                    row[3]=rs.getString("class");
                    row[4]=rs.getString("java");
                    stus.add(row);
                }
            }
        }
        return stus;
    }

    @Override
    public List<String[]> queryByPageBooks(Book book) throws Exception{
//        int page = Integer.parseInt(book.getPage())+1;
        int page = book.getPage();
        System.out.println(page);
        List<String[]> stus=new ArrayList<String[]>();
        String sql="select * from stu order by id limit "+(page)*2+","+2;
//        String sql="select * from stu order by id limit "+(page)*2;
        Class.forName(driver);
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            try(ResultSet rs=pstmt.executeQuery()){
                while(rs.next()){
                    String[] row=new String[6];
                    row[0]=rs.getString("id");
                    row[1]=rs.getString("name");
                    row[2]=rs.getString("age");
                    row[3]=rs.getString("class");
                    row[4]=rs.getString("java");
                    row[5]=""+page;
                    stus.add(row);
                }
            }
        }
        return stus;
    }

    @Override
    public String addBook(Book book) throws Exception{
        String sql="insert into stu" + "(id,name,age,class,java)" + "values(?,?,?,?,?)";
        Class.forName(driver);
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt=con.prepareStatement(sql)){
//            System.out.println(book.getBookClass());
            pstmt.setInt(1,book.getId());
            pstmt.setString(2,book.getName());
            pstmt.setInt(3,book.getAge());
            pstmt.setString(4,book.getBookClass());
            pstmt.setInt(5,book.getJava());
            int i=pstmt.executeUpdate();
            if(i>0){
                return "success";
            }else{
                System.out.println("更新失败!");
                return "error";
            }
        }
    }
    @Override
    public String delBook(Book book) throws Exception{
        String sql="delete from stu where id = ?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt=con.prepareStatement(sql)){
            pstmt.setInt(1,book.getId());
            int i=pstmt.executeUpdate();
            if(i>0){
                return "success";
            }else{
                System.out.println("更新失败!");
                return "error";
            }
        }
    }

    @Override
    public String modifyBook(Book book) throws Exception{
        String sql="update stu set"
                + " name = ?, "
                + "age = ?, "
                + "class = ?, "
                + "java = ? "+ "where id=?";
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt=con.prepareStatement(sql)){
            System.out.println(book.getName());
            System.out.println(book.getId());
            pstmt.setString(1,book.getName());
            pstmt.setInt(2,book.getAge());
            pstmt.setString(3,book.getBookClass());
            pstmt.setInt(4,book.getJava());
            pstmt.setInt(5,book.getId());
            int i=pstmt.executeUpdate();
            if(i>0){
                return "success";
            }else{
                System.out.println("更新失败!");
                return "error";
            }
        }
    }
}
