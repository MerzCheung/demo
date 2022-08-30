// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.4.22 <0.9.0;

contract Box2 {
    uint256 private value;

    event ValueChanged(uint256 value);

    function store(uint256 _value) public {
        value = _value;
        emit ValueChanged(_value);
    }

    function retrieve() public view returns (uint256) {
        return value;
    }

    // 新增一个方法
    function increment() public {
        value = value + 1;
        emit ValueChanged(value);
    }
}
