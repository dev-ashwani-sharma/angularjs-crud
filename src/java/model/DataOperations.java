/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.EstablishConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.User;

/**
 *
 * @author Ashwani
 */
public class DataOperations {
    public static boolean updateUser(User user) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = EstablishConnection.getConnection();
            String sql = "update user set name=?, email=?,city=?,age=?,contact=? where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCity());
            ps.setInt(4, user.getAge());
            ps.setString(5, user.getContact());
            ps.setInt(6, user.getId());
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            System.out.println("Exception1 = "+e);
        }
        finally{
            if(con != null){
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
            if(ps != null){
                try{
                    ps.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
        }
        return false;
    }
    public static boolean deleteUser(int id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = EstablishConnection.getConnection();
            String sql = "delete from user where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally{
            if(con != null){
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
            if(ps != null){
                try{
                    ps.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
        }
        return false;
    }
    public static boolean addUser(User user) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = EstablishConnection.getConnection();
            String sql = "insert into user(name,email,city,age,contact) values (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCity());
            ps.setInt(4, user.getAge());
            ps.setString(5, user.getContact());
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            System.out.println("Exception1 = "+e);
        }
        finally{
            if(con != null){
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
            if(ps != null){
                try{
                    ps.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
        }
        return false;
    }
    
    public static ArrayList<User> viewAllData() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<User> obj = new ArrayList<User>();
        try{
            con = EstablishConnection.getConnection();
            String sql = "select * from user";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                User user = new User(rs.getString("name"), rs.getString("email"), rs.getString("city"), rs.getInt("age"), rs.getString("contact"));
                user.setId(rs.getInt("id"));
                obj.add(user);
            }
            return obj;
        }
        catch(SQLException e){
            System.out.println("Exception1 = "+e);
        }
        finally{
            if(con != null){
                try{
                    con.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
            if(ps != null){
                try{
                    ps.close();
                }
                catch(SQLException e){
                    System.out.println("Exception = "+e);
                }
            }
        }
        return null;
    }
}
