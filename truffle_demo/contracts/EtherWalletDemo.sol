// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;


contract EtherWalletDemo {

    receive() external payable {}

    function getBalances() public view returns(uint) {
        return address(this).balance;
    }

    function withdraw(uint _amount) public {
        /*
        // 1. 返回值是bool,即便失败也不会抛异常.gas限制2300.
        bool sent = payable(msg.sender).send(_amount);
        require(sent, 'send fail');
        */
        // 2. 没有返回值,交易失败,会抛出异常.gas限制2300.
        //payable(msg.sender).transfer(_amount);

        // 3. 可自定义gas,返回bool,推荐使用
        (bool sent, ) = payable(msg.sender).call{gas:5000,value:_amount}("");
        require(sent, 'send fail');

    }

}