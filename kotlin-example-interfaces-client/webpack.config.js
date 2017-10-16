/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */

const path = require('path');
const webpack = require('webpack');

// webpack plugins
const HtmlWebpackPlugin = require('html-webpack-plugin');

const distRoot = path.resolve(__dirname, 'dist');
const srcRoot = path.resolve(__dirname, 'src');

const plugins = [
    new HtmlWebpackPlugin({
        filename: path.resolve(distRoot, 'index.html'),
        template: path.resolve(srcRoot, 'index-template.ejs')
    })
];

module.exports = {
    entry: {
        app: './src/app/index.js'
    },
    output: {
        path: distRoot,
        filename: 'app-dist.local.js'
    },
    module: {
        rules: [
            {
                test: /(\.jsx|\.js)$/,
                exclude: /node_modules/,
                use: 'babel-loader'
            },
            {

            },
            {
                test :/\.css$/,
                exclude: /node_modules/,
                use: [ { loader: 'style-loader' }, { loader: 'css-loader' }]
            }
        ]
    },

    plugins: plugins
};