package com.thomas.golfapp_final;
import entity.Skyway;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;


public class Program extends ServletScoreCard {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();





        try {
            transaction.begin();

            //I was using a scanner here to get the holes, then used them in the try statement//

       /* ServletScoreCard servletScoreCard = new ServletScoreCard();
        int hole1 = servletScoreCard.hole1;
        int hole2 = servletScoreCard.hole2;
        int hole3 = servletScoreCard.hole3;
        int hole4 = servletScoreCard.hole4;
        int hole5 = servletScoreCard.hole5;
        int hole6 = servletScoreCard.hole6;
        int hole7 = servletScoreCard.hole7;
        int hole8 = servletScoreCard.hole8;
        int hole9 = servletScoreCard.hole9;

        */

            Scanner userInput = new Scanner(System.in);

            System.out.println("Hole 1: ");
            int userHole1 = userInput.nextInt();
            System.out.println("Hole 2: ");
            int userHole2 = userInput.nextInt();
            System.out.println("Hole 3: ");
            int userHole3 = userInput.nextInt();
            System.out.println("Hole 4: ");
            int userHole4 = userInput.nextInt();
            System.out.println("Hole 5: ");
            int userHole5 = userInput.nextInt();
            System.out.println("Hole 6: ");
            int userHole6 = userInput.nextInt();
            System.out.println("Hole 7: ");
            int userHole7 = userInput.nextInt();
            System.out.println("Hole 8: ");
            int userHole8 = userInput.nextInt();
            System.out.println("Hole 9: ");
            int userHole9 = userInput.nextInt();

            //Skyway stroke = new Skyway();

            Skyway stroke = new Skyway();
            //stroke.setRound(2);//
            stroke.setHole1(userHole1);
            stroke.setHole2(userHole2);
            stroke.setHole3(userHole3);
            stroke.setHole4(userHole4);
            stroke.setHole5(userHole5);
            stroke.setHole6(userHole6);
            stroke.setHole7(userHole7);
            stroke.setHole8(userHole8);
            stroke.setHole9(userHole9);
            entityManager.persist(stroke);

            /*stroke.setHole1(hole1);
            stroke.setHole2(hole2);
            stroke.setHole3(hole3);
            stroke.setHole4(hole4);
            stroke.setHole5(hole5);
            stroke.setHole6(hole6);
            stroke.setHole7(hole7);
            stroke.setHole8(hole8);
            stroke.setHole9(hole9);
            entityManager.persist(stroke);*/

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}


