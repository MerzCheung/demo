// const Adoption = artifacts.require("Adoption");
// const CrowdFunding = artifacts.require("CrowdFunding");
// const MyToken = artifacts.require("MyToken");
// const Box = artifacts.require('Box');
// const Box2 = artifacts.require('Box2');
const Box3 = artifacts.require('Box3');
const Box4 = artifacts.require('Box4');
const { deployProxy, upgradeProxy } = require('@openzeppelin/truffle-upgrades');

module.exports = async function (deployer) {
    // deployer.deploy(Adoption);
    // deployer.deploy(CrowdFunding);
    // deployer.deploy(MyToken);

    // 升级
    // 1. 部署第一个合约
    // const instance = await deployProxy(Box3, [10], { deployer, initializer: 'store' });
    // console.log('Deployed', instance.address);
    // 2. 部署第二个合约
    const existing = await Box3.deployed();
    const instance = await upgradeProxy(existing.address, Box4, { deployer });
    console.log("Upgraded", instance.address);
};
