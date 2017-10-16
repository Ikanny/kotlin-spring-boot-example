/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */

const path = require('path');
const webpack = require('webpack');

const BUILD_TIME = new Date().getTime();

module.exports = {
    entry: './src/app/index.js',
    output: {
        path: path.resolve(__dirname, '..', 'dist'),
        filename: 'app-dist.' + BUILD_TIME + '.local.js'
    },
    module: {
        loaders: [

        ]
    }
};