package io.ryanpro.jpaidgentest;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaIdGenTestApplicationTests {
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @Test
    void contextLoads() {
    }

    @Test
    public void givenIdentityStrategy_whenCommitTransction_thenReturnPrimaryKey() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TestEntity entity = new TestEntity();

        entityManager.getTransaction()
                .begin();
        entityManager.persist(entity);

        assertThat(entity.getId()).isNotNull();

        entityManager.getTransaction()
                .commit();

        assertThat(entity.getId()).isNotNull();

        entityManager.close();
    }

}
