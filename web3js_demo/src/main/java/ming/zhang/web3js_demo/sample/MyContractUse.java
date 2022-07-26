package ming.zhang.web3js_demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.model.Adoption;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@Component
public class MyContractUse {

    @Autowired
    private Web3j web3j;
    @Autowired
    private Admin admin;


    public void test() throws Exception {
//        List<String> accounts = web3j.ethAccounts().send().getAccounts();
//        for (String account : accounts) {
//            System.out.println(account + "--" + Convert.fromWei(web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST).send().getBalance().toString(), Convert.Unit.ETHER) + "ETH");
//        }
//        System.out.println(web3j.ethGasPrice().send().getGasPrice());
        Adoption adoption = Adoption.load("0x36C15bC37f7737dA489Ce4758d740Ca4153dE247", web3j, Credentials.create("1c2b57818ecb0d0d7aa9247d2cdaba6e70215fec8226b646baeaf1994757e0e1"), new StaticGasProvider(BigInteger.valueOf(4_100_000_000L), BigInteger.valueOf(5000_000)));
//        if (adoption.isValid()) {
            adoption.adopt(BigInteger.ONE).send();
            System.out.println("=============" + adoption.getAdopters());
//        }
        web3j.shutdown();
    }

    public void createNewAccount() throws IOException {
        NewAccountIdentifier send = admin.personalNewAccount("123456").send();
        System.out.println(send.getAccountId());
    }

    public void personalListAccounts() throws IOException {
        PersonalListAccounts personalListAccounts = admin.personalListAccounts().send();
        for (String accountId : personalListAccounts.getAccountIds()) {
            System.out.println(accountId);
        }
    }
}
