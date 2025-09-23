/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author Minht
 */
public class UserAccountDAO {
    private static final String LOGIN = "SELECT MemberId,Password, Email, FullName,Role FROM UserAccount WHERE Email = ? AND Password = ?";
    
    public  UserAccountDTO checkLogin(String email, String password) throws SQLException {
            UserAccountDTO user = null;
            Connection conn = null;
            PreparedStatement ptm = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    int memberId = rs.getInt("memberId");
                    int role = rs.getInt("role");
                    user = new UserAccountDTO(memberId, password, email, fullName, role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return user;
    }
    public UserAccountDTO register(){
        UserAccountDTO user=null;
        return user;
    }
}
