package com.willseaford.finance.loanapplication.user.domain;

import com.willseaford.finance.loanapplication.loanapplication.domain.DomainModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Address extends DomainModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressLineOne;
    private String addressLineTwo;
    private String town;
    private String county;
    private String postcode;
}
