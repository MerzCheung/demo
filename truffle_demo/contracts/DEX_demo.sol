// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/utils/math/SafeMath.sol";

contract SwappableToken is ERC20 {
    constructor(string memory name, string memory symbol, uint amount) ERC20(name, symbol) {
        _mint(msg.sender, amount * 10 ** decimals());
    }

    function approve(address sender, address _address, uint amount) public {
        _approve(sender, _address, amount);
    }
}

contract Dex {

    using SafeMath for uint;
    address public token1;
    address public token2;

    constructor(address _token1, address _token2) {
        token1 = _token1;
        token2 = _token2;
    }

    // 卖from的币， 买to的币
    function swap(address from, address to, uint amount) public {
        require((from == token1 && to == token2) || (from == token2 && to == token1), 'Invalid tokens');
        require(SwappableToken(from).balanceOf(msg.sender) >= amount, 'Not enough to swap');
        uint swap_amount = get_swap_price(from, to, amount);

        // 需要先approve给交易所amount数量的币
        SwappableToken(from).transferFrom(msg.sender, address(this), amount);
        SwappableToken(to).approve(address(this), swap_amount);
        SwappableToken(to).transferFrom(address(this), msg.sender, swap_amount);
    }

    // 2. 增加流动性
    function add_liquidity(address token_address, uint amount) public {
        SwappableToken(token_address).transferFrom(msg.sender, address(this), amount);
    }

    // 获取交易金额
    function get_swap_price(address from, address to, uint amount) public view returns(uint) {
        return ((amount * SwappableToken(to).balanceOf(address(this))) / SwappableToken(from).balanceOf(address(this)));
    }

    // 1. 授权
    function approve(address token, uint amount) public {
        SwappableToken(token).approve(msg.sender, address(this), amount);
    }

    // 查询合约可以调用sender的币的个数
    function allowance(address token) public view returns(uint) {
        return SwappableToken(token).allowance(msg.sender, address(this));
    }

    // 查询合约里的余额
    function balanceOf(address token, address account) public view returns(uint) {
        return SwappableToken(token).balanceOf(account);
    }

}