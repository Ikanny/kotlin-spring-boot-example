/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */
const env = process.env.NODE_ENV || 'local';
const config = require('./' + env);

if (!config) {
    throw new Error('Fail to find env for ' + env);
}

module.exports = config;