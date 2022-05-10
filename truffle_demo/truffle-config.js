// 导入dotenv库创用于读取`.env`文件中的设置
require('dotenv').config();
// 导入truffle-hdwallet-provider库重建钱包
const HDWalletProvider = require('truffle-hdwallet-provider');

module.exports = {
    // Uncommenting the defaults below
    // provides for an easier quick-start with Ganache.
    // You can also follow this format for other networks.
    // See details at: https://trufflesuite.com/docs/truffle/reference/configuration
    // on how to specify configuration options!
    //
    networks: {
        development: {
            host: "127.0.0.1",
            port: 8545,
            network_id: "*",
            from: "0xc8109FD3af2C4E6F907DcD6063b9Aaf831410cd2",
        },
        // test: {
        //   host: "127.0.0.1",
        //   port: 7545,
        //   network_id: "*"
        // }
        // Useful for deploying to a public network.
        // NB: It's important to wrap the provider as a function.
        kovan: {
            provider: () => new HDWalletProvider(
                process.env.MNEMONIC,
                process.env.INFURA_API_KEY
            ),
            gas: 5000000,
            gasPrice: 25000000000,
            network_id: 42,
            from: "0x09245c57c040d1739A4ED2169037aC54b2359a72",
        },
    },
    compilers: {
        solc: {
            version: "0.8.7",
            settings: {
                optimizer: {
                    enabled: true,
                    runs: 200   // 优化次数
                }
            }
        }
    },
    //
    // Truffle DB is currently disabled by default; to enable it, change enabled:
    // false to enabled: true. The default storage location can also be
    // overridden by specifying the adapter settings, as shown in the commented code below.
    //
    // NOTE: It is not possible to migrate your contracts to truffle DB and you should
    // make a backup of your artifacts to a safe location before enabling this feature.
    //
    // After you backed up your artifacts you can utilize db by running migrate as follows:
    // $ truffle migrate --reset --compile-all
    //
    // db: {
    // enabled: false,
    // host: "127.0.0.1",
    // adapter: {
    //   name: "sqlite",
    //   settings: {
    //     directory: ".db"
    //   }
    // }
    // }
};
