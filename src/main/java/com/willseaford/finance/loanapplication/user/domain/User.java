package com.willseaford.finance.loanapplication.user.domain;

import com.willseaford.finance.loanapplication.loanapplication.domain.DomainModel;
import com.willseaford.finance.loanapplication.loanapplication.domain.LoanApplication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User extends DomainModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    private Address homeAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;

    @OneToMany(mappedBy = "applicant")
    private List<LoanApplication> loanApplications;
}
