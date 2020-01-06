package me.whakanda.jpa.whakandajpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Post post = new Post();
        post.setTitle("Spring Data JPA 언제 보나...");

        Comment comment = new Comment();
        comment.setComment("빨리 보고 싶다..");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("곧 볼겁니다..");
        post.addComment(comment1);


        Session session = entityManager.unwrap(Session.class);
        session.save(post);



        /*Account account = new Account();
        account.setUserName("kuyoung");
        account.setPassWord("jpa");


        Study study = new Study();
        study.setName("Spring Data Jpa");
//        study.setOwner(account);

        account.addStudy(study);

        // hibernate의 가장 큰 특징은 session 이다!
        Session session = entityManager.unwrap(Session.class);
        session.persist(account);
        session.persist(study);
        //entityManager.persist(account);*/
    }
}
