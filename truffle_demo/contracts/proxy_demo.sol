// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;


interface ILogic {

    function setNumber(uint _number) external;
    function getNumber() external view returns(uint);

}

contract Logic1 is ILogic {

    uint private number;

    function setNumber(uint _number) public override {
        number = _number + 1;
    }

    function getNumber() public override view returns(uint) {
        return number;
    }
}

contract Logic2 is ILogic {

    uint private number;

    function setNumber(uint _number) public override {
        number = _number + 2;
    }

    function getNumber() public override view returns(uint) {
        return number;
    }
}

contract Example {

    ILogic private iLogic;

    function setLogic(address _address) public {
        iLogic = ILogic(_address);
    }

    function getLogic() public view returns(address) {
        return address(iLogic);
    }

    function setNumber(uint _number) public {
        iLogic.setNumber(_number);
    }

    function getNumber() public view returns(uint) {
        return iLogic.getNumber();
    }

}