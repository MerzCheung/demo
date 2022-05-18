// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;


library SafeMath {

    function add(uint a, uint b) internal pure returns(uint) {
        return a + b;
    }

    function sub(uint a, uint b) internal pure returns(uint) {
        return a - b;
    }

}


contract Example {
    using SafeMath for uint;

    function add(uint a, uint b) public pure returns(uint) {
        return a.add(b);
    }

    function sub(uint a, uint b) public pure returns(uint) {
        return a.sub(b);
    }
}