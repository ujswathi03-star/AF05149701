package com.feedback.dao;

import com.feedback.model.Feedback;
import com.feedback.util.DBConnection;

import java.sql.*;
import java.util.*;

public class FeedbackDAO {

    // CREATE
    public void addFeedback(Feedback f) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO feedback(name, message) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, f.getName());
            ps.setString(2, f.getMessage());

            ps.executeUpdate();
            System.out.println("Feedback Added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Feedback> getAllFeedback() {
        List<Feedback> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM feedback";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Feedback f = new Feedback();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setMessage(rs.getString("message"));
                list.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE
    public void deleteFeedback(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM feedback WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Feedback Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}