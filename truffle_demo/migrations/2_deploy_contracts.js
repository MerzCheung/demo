// const ConvertLib = artifacts.require("ConvertLib");
// const MetaCoin = artifacts.require("MetaCoin");
// const MyContract = artifacts.require("MyContract");
// const EtherStore = artifacts.require("EtherStore");
// const Attack = artifacts.require("Attack");
const call_demo = artifacts.require("call_demo");
const back_demo = artifacts.require("back_demo");

module.exports = function (deployer) {
    // deployer.deploy(ConvertLib);
    // deployer.link(ConvertLib, MetaCoin);
    // deployer.deploy(MetaCoin);
    // deployer.deploy(MyContract);
    // deployer.deploy(EtherStore).then(function () {
    //     return deployer.deploy(Attack, EtherStore.address);
    // });
    // deployer.link(EtherStore, Attack);
    deployer.deploy(call_demo);
    deployer.deploy(back_demo);
};
