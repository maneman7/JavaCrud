/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kasapp.model.DatabaseConfig;
import kasapp.model.Kas;

/**
 *
 * @author emanu
 */
public class KasDAOProses implements KasDAO{
    Connection connection=null;
    ResultSet resultSet=null;
    Statement statement=null;
    PreparedStatement preparedStatement=null;
    
    @Override
    public List<Kas> get() {
        List<Kas> list=new ArrayList<Kas>();
        try{
            
            String sql="Select * from tbl_kas";
            connection=DatabaseConfig.openConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                Kas kas=new Kas();
                kas.setId(resultSet.getInt("id"));
                kas.setNama(resultSet.getString("nama"));
                kas.setNominal(resultSet.getString("nominal"));
                kas.setBulan(resultSet.getString("bulan"));
                list.add(kas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    

    @Override
    public boolean save(Kas kas) {
        boolean flag=false;
        try{
            String sql="Insert Into tbl_kas(nama,nominal,bulan) values(?,?,?)";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, kas.getNama());
            preparedStatement.setString(2, kas.getNominal());
            preparedStatement.setString(3, kas.getBulan()); 
            preparedStatement.executeUpdate();
            flag=true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public Kas getSinggle(int id) {
        Kas kas=null;
        try{
            String sql="Select * from tbl_kas where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                kas=new Kas();
                kas.setId(resultSet.getInt("id"));
                kas.setNama(resultSet.getString("nama"));
                kas.setNominal(resultSet.getString("nominal"));
                kas.setBulan(resultSet.getString("bulan"));
            }
        }catch(SQLException ex){
      }
        return kas;
    }

    @Override
    public boolean update(Kas kas) {
        boolean flag=false;
        try{
            String sql="update tbl_kas set nama=?,nominal=?,bulan=? where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, kas.getNama());
            preparedStatement.setString(2, kas.getNominal());
            preparedStatement.setString(3, kas.getBulan());
            preparedStatement.setInt(4, kas.getId());
            preparedStatement.executeUpdate();
            flag=true;
        }catch(SQLException ex){
      }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag=false;
        try{
            String sql="delete from tbl_kas where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag=true;
        }catch(SQLException ex){
      }
        return flag;
    }
    
}
