// const ConvertLib = artifacts.require("ConvertLib");
// const MetaCoin = artifacts.require("MetaCoin");
// const MyContract = artifacts.require("MyContract");
const EtherStore = artifacts.require("EtherStore");
const Attack = artifacts.require("Attack");

module.exports = function (deployer) {
    // deployer.deploy(ConvertLib);
    // deployer.link(ConvertLib, MetaCoin);
    // deployer.deploy(MetaCoin);
    // deployer.deploy(MyContract);
    deployer.deploy(EtherStore).then(function () {
        return deployer.deploy(Attack, EtherStore.address);
    });
    deployer.link(EtherStore, Attack);
};
