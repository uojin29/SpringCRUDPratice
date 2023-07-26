package com.example.demo.repository;

import com.example.demo.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void create(Member member){
        em.persist(member);
    }

   public List<Member> findByEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
   }

    public Member findById(Long id){
        return em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id)
                .getSingleResult();
    }
   public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
   }
   public Member deleteById(Long id){
       Member member = em.find(Member.class, id);
       em.remove(member);
       return member;
   }
}
