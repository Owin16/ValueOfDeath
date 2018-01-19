package DAO;

import model.Account;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListLogic {
    private static final String REQUEST_GET_USERS = "SELECT * FROM user";
    private static final String REQUEST_GET_ACCOUNTS = "SELECT * FROM account";
    private static final String REQUEST_GET_SUM = "select sum(account) from account;";
    private static final String REQUEST_GET_RICHEST = "select * from user where userId in (select userId FROM account group by userId having sum(account) >= all (select sum(account) from account group by userId));";
    public ArrayList<User> userListDB = new ArrayList<User>();
    public ArrayList<Account> accountList = new ArrayList<Account>();

    public void getUsers() {

        try {
            Connection cn = ConnectorDB.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(REQUEST_GET_USERS);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSureName(rs.getString(3));
                userListDB.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAccounts() {

        try {
            Connection cn = ConnectorDB.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(REQUEST_GET_ACCOUNTS);

            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt(1));
                acc.setAccount(rs.getInt(2));
                acc.setUserId(rs.getInt(3));
                accountList.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getRichestUser() {

        try {
            Connection cn = ConnectorDB.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(REQUEST_GET_RICHEST);
            User userReturn = new User();
            while (rs.next()) {
                int userId = rs.getInt(1);
                for (User user : userListDB) {
                    if (user.getId() == userId)
                        userReturn = user;
                }
            }
            return userReturn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getSum() {
        int sum = 0;
        try {
            Connection cn = ConnectorDB.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(REQUEST_GET_SUM);

            while (rs.next()) {
                sum = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
