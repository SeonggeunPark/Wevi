package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //code
        try {
            Member member = new Member();
            member.setId(2L);
            member.setName("Jack");
            em.persist(member);
            member.setId(3L);
            member.setName("Jack");
            em.persist(member);

            Member findMember = em.find(Member.class, 1);
            System.out.println(findMember.getId());
            System.out.println(findMember.getName());

            tx.commit();
        } catch (Exception e) {
            System.out.println("에러");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
