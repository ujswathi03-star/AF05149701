package com.feedback.service;

import com.feedback.dao.FeedbackDAO;
import com.feedback.model.Feedback;

import java.util.List;

public class FeedbackService {

    FeedbackDAO dao = new FeedbackDAO();

    public void addFeedback(Feedback f) {
        dao.addFeedback(f);
    }

    public List<Feedback> getFeedbacks() {
        return dao.getAllFeedback();
    }

    public void deleteFeedback(int id) {
        dao.deleteFeedback(id);
    }
}
