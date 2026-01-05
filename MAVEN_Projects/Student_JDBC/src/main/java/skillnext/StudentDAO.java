package skillnext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/skillnext_db";
    private static final String USER = "root";
    private static final String PASSWORD = "deepikap#0602";

    // Check if ID exists
    public boolean exists(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "SELECT COUNT(*) FROM student WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        rs.next();
        boolean present = rs.getInt(1) > 0;

        rs.close();
        stmt.close();
        conn.close();

        return present;
    }

    // Insert student (ID auto-generated)
    public void insert(Student s) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student (name, sem, department) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, s.getName());
        stmt.setInt(2, s.getSem());
        stmt.setString(3, s.getDepartment());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    // Update student
    public void update(Student s) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE student SET name=?, sem=?, department=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, s.getName());
        stmt.setInt(2, s.getSem());
        stmt.setString(3, s.getDepartment());
        stmt.setInt(4, s.getId());

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    // Delete student
    public void delete(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    // Select all students
    public List<Student> selectAll() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "SELECT * FROM student";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Student> list = new ArrayList<>();

        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setSem(rs.getInt("sem"));
            s.setDepartment(rs.getString("department"));

            list.add(s);
        }

        rs.close();
        stmt.close();
        conn.close();

        return list;
    }
}
