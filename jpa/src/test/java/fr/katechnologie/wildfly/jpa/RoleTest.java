package fr.katechnologie.wildfly.jpa;

import javax.inject.Inject;
import javax.transaction.UserTransaction;

import fr.katechnologie.wildfly.jpa.entity.Role;
import fr.katechnologie.wildfly.jpa.session.RoleFacade;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class RoleTest {

    @Deployment
    public static JavaArchive createDeployment() {
        //return ShrinkWrap.create(WebArchive.class, "RoleTest.war" )
        //        .addPackage( Role.class.getPackage() )
        //        .addAsResource( "META-INF/persistence.xml" )
        //        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        return ShrinkWrap.create( JavaArchive.class )
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    //@Inject
    //RoleFacade role;

    //@Inject
    //UserTransaction utx;


    @Before
    public void preparePersistenceTest() throws Exception {
        //clearData();
        //insertData();
        //startTransaction();
    }

    @After
    public void commitTransaction() throws Exception {
        //utx.commit();
    }
/*
    private void clearData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Dumping old records...");
        //em.createQuery("delete from Game").executeUpdate();
        utx.commit();
    }

    private void insertData() throws Exception {
        utx.begin();
        em.joinTransaction();
        System.out.println("Inserting records...");
        //for (String title : GAME_TITLES) {
        //    Game game = new Game(title);
        //    em.persist(game);
        //}
        utx.commit();
        // clear the persistence context (first-level cache)
        em.clear();
    }

    private void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }
*/
    @Test
    public void aUnitTest() {
        //Assert.fail("Not yet implemented");
    }
}