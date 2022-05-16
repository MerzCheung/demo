// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

contract Back_demo {

    event _receive(address _address, uint _amount, string msg);

    receive() external payable {
        emit _receive(msg.sender, msg.value, "is receive");
    }

    fallback() external payable {
        emit _receive(msg.sender, msg.value, "is fallback");
    }

    function getBalance() public view returns (uint) {
        return address(this).balance;
    }

}