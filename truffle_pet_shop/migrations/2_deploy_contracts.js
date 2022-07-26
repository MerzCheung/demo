const Adoption = artifacts.require("Adoption");
const CrowdFunding = artifacts.require("CrowdFunding");
const MyToken = artifacts.require("MyToken");

module.exports = function (deployer) {
    deployer.deploy(Adoption);
    deployer.deploy(CrowdFunding);
    deployer.deploy(MyToken);
};
