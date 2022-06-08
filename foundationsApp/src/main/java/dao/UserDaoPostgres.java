package dao;

import entities.User;
import utilities.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoPostgres implements UserDAO{

    @Override
    public User createUser(User user) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){
            String sql = "insert into users (first_name,last_name,email,username,password,role_id) values (default,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //db will automatically generate keys
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole_id());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedID = rs.getInt("id");

            user.setId(generatedID);
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserById(int id) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){
            String sql = "select * from users where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            rs.next();

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole_id(rs.getInt("role_id"));
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){
            String sql = "select * from users where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            rs.next();

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole_id(rs.getInt("role_id"));
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getUsers() {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()) {
            String sql = "select * from foundation_sql.users";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<User> userList = new ArrayList<>();

            rs.next();

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole_id(rs.getInt("role_id"));
            userList.add(user);

            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){
            String sql = "update users set first_name = ?, last_name = ?, email = ?, username = ?, password = ?, role_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole_id());

            ps.executeUpdate();

            return user;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User deleteUser(int id) {
        try(Connection conn = ConnectionUtil.getInstance().getConnection()){
            String sql = "delete from users where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();

            System.out.println("User has been deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
