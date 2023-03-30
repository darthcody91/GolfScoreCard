package com.thomas.golfapp_final;
import entity.Skyway;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class Program extends ServletScoreCard {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        //I was using a scanner here to get the holes, then used them in the try statement//

        ServletScoreCard servletScoreCard = new ServletScoreCard();
        int hole1 = Integer.parseInt(servletScoreCard.getParameter("hole1"));
        int hole2 = Integer.parseInt(servletScoreCard.getParameter("hole2"));
        int hole3 = Integer.parseInt(servletScoreCard.getParameter("hole3"));
        int hole4 = Integer.parseInt(servletScoreCard.getParameter("hole4"));
        int hole5 = Integer.parseInt(servletScoreCard.getParameter("hole5"));
        int hole6 = Integer.parseInt(servletScoreCard.getParameter("hole6"));
        int hole7 = Integer.parseInt(servletScoreCard.getParameter("hole7"));
        int hole8 = Integer.parseInt(servletScoreCard.getParameter("hole8"));
        int hole9 = Integer.parseInt(servletScoreCard.getParameter("hole9"));



        try {
            transaction.begin();

            Skyway stroke = new Skyway();
            //stroke.setRound(2);//


            stroke.setHole1(hole1);
            stroke.setHole2(hole2);
            stroke.setHole3(hole3);
            stroke.setHole4(hole4);
            stroke.setHole5(hole5);
            stroke.setHole6(hole6);
            stroke.setHole7(hole7);
            stroke.setHole8(hole8);
            stroke.setHole9(hole9);
            entityManager.persist(stroke);

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


