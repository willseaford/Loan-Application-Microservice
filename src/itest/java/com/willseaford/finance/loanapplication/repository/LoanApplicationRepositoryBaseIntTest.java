package com.willseaford.finance.loanapplication.repository;

import com.willseaford.finance.loanapplication.loanapplication.domain.LoanApplication;
import com.willseaford.finance.loanapplication.loanapplication.repository.LoanApplicationRepository;
import datafactories.LoanApplicationTestDataFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public abstract class LoanApplicationRepositoryBaseIntTest {

    @Autowired
    private LoanApplicationRepository sut;

    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void when_find_by_id_then_return_loan_application(){

        //Given pre-seeded file

        //When
        var actualOptional = sut.findById(1L);

        //Then
        assertThat(actualOptional.isPresent()).isTrue();
    }

    @Test
    public void when_saving_new_loan_application_then_entity_is_returned(){

        //Given
        var testData = LoanApplicationTestDataFactory.buildLoanApplication();

        var expected = sut.save(testData);

        //When
        var actualOptional = sut.findById(expected.getId());

        //Then
        assertThat(actualOptional.isPresent()).isTrue();
        LoanApplication actual = actualOptional.get();
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void when_finding_loan_applications_for_user_then_list_of_loan_applications_is_returned(){

        //Given
        var loanApplications = LoanApplicationTestDataFactory.buildLoanApplications();

        Long expectedUserId = 0L;
        for(LoanApplication loanApplication: loanApplications){
            expectedUserId = sut.save(loanApplication).getApplicant().getUserId();
        }

        //When
        var actuals = sut.findByApplicant_UserId(expectedUserId);

        //Then
        assertThat(actuals).isNotEmpty();
        assertThat(actuals.size()).isEqualTo(loanApplications.size());
    }
}
