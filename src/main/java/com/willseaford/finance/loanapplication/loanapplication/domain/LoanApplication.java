package com.willseaford.finance.loanapplication.loanapplication.domain;

import com.willseaford.finance.loanapplication.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
public class LoanApplication extends DomainModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicantId", referencedColumnName = "id")
    @ToString.Exclude
    private User applicant;

    private Boolean active;

    private BigDecimal principal;

    @Enumerated(EnumType.STRING)
    private Period period;

    private BigDecimal total;




}
