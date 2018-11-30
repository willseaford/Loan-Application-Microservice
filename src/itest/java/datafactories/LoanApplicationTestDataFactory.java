package datafactories;

import com.willseaford.finance.loanapplication.loanapplication.domain.LoanApplication;
import com.willseaford.finance.loanapplication.loanapplication.domain.Period;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class LoanApplicationTestDataFactory {


    public static LoanApplication buildLoanApplication(){
        return LoanApplication.builder()
                .applicant(UserTestDataFactory.buildUser())
                .active(true)
                .period(Period.SIX_MONTHS)
                .principal(BigDecimal.valueOf(100.00))
                .total(BigDecimal.valueOf(117.19))
                .build();
    }

    public static List<LoanApplication> buildLoanApplications(){
        var user = UserTestDataFactory.buildUser();

        var loanApplicationOne = LoanApplication.builder()
                .applicant(user)
                .active(true)
                .period(Period.SIX_MONTHS)
                .principal(BigDecimal.valueOf(100.00))
                .total(BigDecimal.valueOf(117.19))
                .build();

        var loanApplicationTwo = LoanApplication.builder()
                .applicant(user)
                .active(true)
                .period(Period.TWELVE_MONTHS)
                .principal(BigDecimal.valueOf(40.00))
                .total(BigDecimal.valueOf(300.00))
                .build();

        var loanApplicationThree = LoanApplication.builder()
                .applicant(user)
                .active(false)
                .period(Period.SEVEN_DAYS)
                .principal(BigDecimal.valueOf(100.00))
                .total(BigDecimal.valueOf(117.19))
                .build();

        return Arrays.asList(loanApplicationOne, loanApplicationTwo, loanApplicationThree);
    }
}
