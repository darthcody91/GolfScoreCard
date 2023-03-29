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





        try {
            transaction.begin();

            Skyway stroke = new Skyway();
            //stroke.setRound(2);//

/*
           stroke.setHole1(hole1);

            stroke.setHole2(hole2);
            stroke.setHole3(hole3);
            stroke.setHole4(hole4);
            stroke.setHole5(hole5);
            stroke.setHole6(hole6);
            stroke.setHole7(hole7);
            stroke.setHole8(hole8);
            stroke.setHole9(hole9);*/
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


