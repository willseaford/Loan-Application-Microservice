package datafactories;

import com.willseaford.finance.loanapplication.user.domain.Address;

public class AddressTestDataFactory {

    public static Address buildAddress(){
        return Address.builder()
                .addressLineOne("39")
                .addressLineTwo("Eade Road")
                .town("London")
                .county("Greater London")
                .postcode("N4 1DJ")
                .build();
    }
}
