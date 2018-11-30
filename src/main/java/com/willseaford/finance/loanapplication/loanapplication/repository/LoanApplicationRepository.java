package com.willseaford.finance.loanapplication.loanapplication.repository;

import com.willseaford.finance.loanapplication.loanapplication.domain.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    public List<LoanApplication> findByApplicant_UserId(Long userId);
}
