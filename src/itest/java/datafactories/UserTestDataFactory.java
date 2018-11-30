package datafactories;

import com.willseaford.finance.loanapplication.user.domain.User;

public class UserTestDataFactory {

    public static User buildUser(){

        var address = AddressTestDataFactory.buildAddress();

        return User.builder()
                .userId(123L)
                .homeAddress(address)
                .billingAddress(address)
                .build();
    }
}
