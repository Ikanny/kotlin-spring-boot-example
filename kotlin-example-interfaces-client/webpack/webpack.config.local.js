/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */

const path = require('path');
const webpack = require('webpack');

const plugins = [];

module.exports = {
    entry: './src/app/index.js',
    output: {
        path: path.resolve(__dirname, '..', 'dist'),
        filename: 'app-dist.local.js'
    },
    module: {
        rules: [
            {
                test: /(\.jsx|\.js)$/,
                exclude: /node_modules/,
                use: 'babel-loader'
            }
        ]
    },

    plugins: plugins
};