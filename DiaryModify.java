/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.diaryapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran-hang
 */
public class DiaryModify {
    public static List<Diary> findAll(){
        List<Diary> diaryList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diary", "root", "MySQL.123");
            
            //query
            String sql = "select * from Diary";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                Diary dia = new Diary(resultSet.getInt("id"),
                        resultSet.getString("date"),
                        resultSet.getString("description"),
                        resultSet.getString("content"));
                diaryList.add(dia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return diaryList;
    }
    
    public static void insert(Diary dia){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diary", "root", "MySQL.123");
            
            //query
            String sql = "insert into Diary(date, description, content) values(?, ?, ?)";
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, dia.getDate());
            statement.setString(2, dia.getDescription());
            statement.setString(3, dia.getContent());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Diary dia){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diary", "root", "MySQL.123");
            
            //query
            String sql = "update Diary set date = ?, description = ?, content = ? where id = ?";
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, dia.getDate());
            statement.setString(2, dia.getDescription());
            statement.setString(3, dia.getContent());
            statement.setInt(4, dia.getId());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
         
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diary", "root", "MySQL.123");
            
            //query
            String sql = "delete from Diary where id = ?";
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiaryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
