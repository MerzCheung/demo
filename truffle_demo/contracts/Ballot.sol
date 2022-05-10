// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

contract Ballot {

    //选民
    struct Voter {
        uint weight; //计票的权重
        bool voted; //若为真,代表该人已投票
        address delegate; //被委托人
        uint vote; //投票提案的索引
    }

    //提案的类型
    struct Proposal {
        bytes32 name; //简称
        uint voteCount; //得票数
    }

    address public chairperson;

    //声明状态变量,为每一个可能的地址存储一个Voter
    mapping(address => Voter) public voters;

    //一个Proposal结构类型的动态数组
    Proposal[] public proposals;

    //为proposalNames中的每一个提案,创建一个新的(投票)表决
    constructor(bytes32[] memory proposalNames) {
        chairperson = msg.sender;
        voters[chairperson].weight = 1;
        //对于提供的每个提案名称,创建一个新的proposal对象,并把它添加到proposals数组的末尾
        for (uint i = 0; i < proposalNames.length; i++) {
            proposals.push(Proposal({
                name : proposalNames[i],
                voteCount : 0
                }));
        }
    }

    //授权voter对这个(投票)表决进行投票
    //只有chairperson可以调用该函数
    function giveRightToVoter(address voter) public view {
        //若require的第一个参数的计算结果为false,则终止执行,撤销所有对状态和以太币余额的改动.
        //在旧版的EVM中这增加会消耗gas,但现在不会了.
        //使用require来检查函数是否被正确的调用, 是一个好习惯
        //你也可以在require的第二个参数中提供一个对错误情况的解释
        require(
            msg.sender == chairperson,
            "Only chairperson can give right to vote."
        );

        require(
            !voters[voter].voted,
            "The voter already voted."
        );
        require(voters[voter].weight == 0);
        voters[voter].weight == 1;
    }

    //把你的票委托到投票者to
    function delegate(address to) public {
        //传引用
        Voter storage sender = voters[msg.sender];
        require(!sender.voted, "You already voted.");
        require(to != msg.sender, "Self-delegation is disallowed.");
        //委托是可以传递的,只要被委托者to也设置了委托
        //一般来说,这种循环是很危险的.因为,如果传递的链太长,则可能消耗的gas要多于区块中剩余的(大于区块设置的gaslimit),
        //这种情况下,委托不会被执行
        //而另一些情况下,如果形成闭环,则会让合约完全卡住
        while (voters[to].delegate != address(0)) {
            //如果to存在被委托人
            to = voters[to].delegate;
            //不允许闭环委托
            require(to != msg.sender, "Found loop in delegation.");
        }

        //sender是一个引用,相当于对voters[msg.sender].voted进行修改
        sender.voted = true;
        sender.delegate = to;
        Voter storage delegate_ = voters[to];
        if (delegate_.voted) {
            //若被委托人已经投过票,直接增加的票数
            proposals[delegate_.vote].voteCount += sender.weight;
        } else {
            delegate_.weight += sender.weight;
        }
    }

    //把你的票(包括委托给你的票),投给proposals[proposal].name.
    function vote(uint proposal) public {
        Voter storage sender = voters[msg.sender];
        require(!sender.voted, "Already voted.");
        sender.voted = true;
        sender.vote = proposal;

        //如果proposal超过了数组范围,则会自动抛出异常,并恢复所有改的
        proposals[proposal].voteCount += sender.weight;
    }

    //结合之前所有的投票,计算出最终胜出的提案
    function winningProposal() public view returns (uint winningProposal_) {
        uint winningVoteCount = 0;
        for (uint p = 0; p < proposals.length; p++) {
            if (proposals[p].voteCount > winningVoteCount) {
                winningVoteCount = proposals[p].voteCount;
                winningProposal_ = p;
            }
        }
        return winningProposal_;
    }

    //调用 winningProposal() 函数以获取提案数组中获胜者的索引，并以此返回获胜者的名称
    function winnerName() public view returns (bytes32 winnerName_) {
        winnerName_ = proposals[winningProposal()].name;
    }
}
