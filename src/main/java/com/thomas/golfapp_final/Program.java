package com.thomas.golfapp_final;
import com.thomas.golfapp_final.entity.Skyway;
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
        int hole1 = servletScoreCard.hole1;
        int hole2 = servletScoreCard.hole2;
        int hole3 = servletScoreCard.hole3;
        int hole4 = servletScoreCard.hole4;
        int hole5 = servletScoreCard.hole5;
        int hole6 = servletScoreCard.hole6;
        int hole7 = servletScoreCard.hole7;
        int hole8 = servletScoreCard.hole8;
        int hole9 = servletScoreCard.hole9;




        try {
            transaction.begin();

            Skyway stroke = new Skyway();



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


