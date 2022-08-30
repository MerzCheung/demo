pragma solidity >=0.4.22 <0.9.0;

import "truffle/Assert.sol";   // 引入的断言
import "truffle/DeployedAddresses.sol";  // 用来获取被测试合约的地址
import "../contracts/Box.sol";

contract TestBox {
    Box box = Box(DeployedAddresses.Box());

    function testStroe() public {
        uint256 _value = 2;
        box.store(_value);
        uint256 value = box.retrieve();
        Assert.equal(_value, value, "error");
    }
}
