// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

interface IService {
    function setName(string memory _name) external;
    function getName() external view returns(string memory);
}

contract Service is IService {

    string private name;

    function setName(string memory _name) public override {
        name = _name;
    }

    function getName() public override view returns(string memory) {
        return name;
    }

}

contract CusService {

    IService iservice;

    constructor(address _address) {
        iservice = IService(_address);
    }

    function setName(string memory _name) public {
        iservice.setName(_name);
    }

    function getName() public view returns(string memory) {
        return iservice.getName();
    }

}