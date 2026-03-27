package com.feedback.main;

import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FeedbackService service = new FeedbackService();

        while (true) {
            System.out.println("\n--- Feedback Management System ---");
            System.out.println("1. Add Feedback");
            System.out.println("2. View Feedback");
            System.out.println("3. Delete Feedback");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    Feedback f = new Feedback();

                    System.out.print("Enter Name: ");
                    f.setName(sc.nextLine());

                    System.out.print("Enter Message: ");
                    f.setMessage(sc.nextLine());

                    service.addFeedback(f);
                    break;

                case 2:
                    List<Feedback> list = service.getFeedbacks();
                    for (Feedback fb : list) {
                        System.out.println(fb.getId() + " | " + fb.getName() + " | " + fb.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    service.deleteFeedback(id);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}