package ming.zhang.web3js_demo;

import ming.zhang.web3js_demo.sample.MyContractUse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Web3jsDemoApplicationTests {

    @Autowired
    private MyContractUse contractUse;

    @Test
    void contextLoads() throws Exception {
//        contractUse.test();
        contractUse.createNewAccount();
        System.out.println("------------------");
        contractUse.personalListAccounts();
    }

}
