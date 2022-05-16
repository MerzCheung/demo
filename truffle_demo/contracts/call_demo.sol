// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

contract Call_demo {

    event Response(bool msg, bytes data);

    function _callNoData(address payable _path) public payable {
        (bool sent, bytes memory data) = _path.call{value: msg.value}("");
        emit Response(sent, data);
    }

    function _callData(address payable _path) public payable {
        (bool sent, bytes memory data) = _path.call{value: msg.value}("abc");
        emit Response(sent, data);
    }

}