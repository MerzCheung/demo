// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;


contract A {
    /*
        // 1、abi.encode
        function getBFunctionByte4() public pure returns(bytes4) {
            return bytes4(keccak256("bFunction(uint256,string)"));
            // return 0xf36b7e20
        }

        function getParamsBytes(uint256 _num, string calldata _message) public pure returns(bytes memory) {
            return abi.encode(_num, _message);
            // return 0x00000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000040000000000000000000000000000000000000000000000000000000000000000568656c6c6f000000000000000000000000000000000000000000000000000000
        }

        // _bAddress: B的合约地址
        // _data: getBFunctionByte4 + getParamsBytes去掉0x
        function callBFunction(address _bAddress, bytes calldata _data) public returns(bool) {
            (bool success, ) = _bAddress.call(_data);
            return success;
        }
        */
/*
    // 2、 abi.encodeWithSignature 推荐
    function callBFunction(address _bAddress, uint256 _num, string memory _message) public returns (bool) {

        (bool success,) = _bAddress.call(
            abi.encodeWithSignature("bFunction(uint256,string)", _num, _message)
        );
        return success;
    }
    */
/*
    // 3、 abi.encodePacked
    function callBFunction(address _bAddress, uint256 _num, string memory _message) public returns (bool) {

        bytes4 sig = bytes4(keccak256("bFunction(uint256,string)"));
        bytes memory _bNum = abi.encode(_num);
        bytes memory _bMessage = abi.encode(_message);
        (bool success, ) = _bAddress.call(
            abi.encodePacked(sig, _bNum, _bMessage)
        );
        return success;
    }
    */
/*

    // 4、 abi.encodeWithSelecto
    function callBFunction(address _bAddress, uint256 _num, string memory _message) public returns (bool) {

        bytes4 sig = bytes4(keccak256("bFunction(uint256,string)"));

        (bool success, ) = _bAddress.call(
            abi.encodeWithSelector(sig, _num, _message)
        );
        return success;
    }
*/

    // 5、推荐
    function callBFunction(address _bAddress, uint256 _num, string memory _message) public returns (bool) {

        B contractB = B(_bAddress);
        contractB.bFunction(_num, _message);

        return true;
    }

}

contract B {
    uint256 public num;
    string public message;

    function bFunction(uint256 _num, string memory _message) public returns (uint256, string memory) {
        num = _num;
        message = _message;
        return (num, message);
    }

    fallback() external {}
}