package com.willseaford.finance.loanapplication.repository;

import docker.MySqlDockerContainer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LoanApplicationMySqlIntTest extends LoanApplicationRepositoryBaseIntTest {
    @BeforeClass
    public static void setUpClass() throws InterruptedException {
        MySqlDockerContainer.instance().startMySqlContainerIfDown();
        for(int i =0; i<10;i++){
            System.out.println("waiting");
            Thread.sleep(1000);
        }
    }

    @Before
    public void  waitSomeTime() throws InterruptedException {
        Thread.sleep(1000);
    }
}
