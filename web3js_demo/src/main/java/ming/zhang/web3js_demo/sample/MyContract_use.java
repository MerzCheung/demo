package ming.zhang.web3js_demo.sample;

import generated.ming.zhang.web3js_demo.MyContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;

public class MyContract_use {
    public static void main(String[] args) throws IOException {
        Web3j web3j = Web3j.build(new HttpService("http://localhost:8545"));
        MyContract myContract = MyContract.load("0xDa238D7F48636cE4ABB95B5D9dbddC7Be3563675", web3j, Credentials.create("1c2b57818ecb0d0d7aa9247d2cdaba6e70215fec8226b646baeaf1994757e0e1"), new DefaultGasProvider());
        if (myContract.isValid()) {
            myContract.set("111");
            System.out.println("=============" + myContract.get().encodeFunctionCall());
        }
        web3j.shutdown();
    }
}
