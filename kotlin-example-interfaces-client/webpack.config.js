/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */

const path = require('path');
const webpack = require('webpack');

const env = process.env.NODE_ENV || 'local';
const isProduction = env === 'production';

const distRoot = path.resolve(__dirname, 'dist');
const srcRoot = path.resolve(__dirname, 'src');

// webpack plugins
const HtmlWebpackPlugin = require('html-webpack-plugin');

const plugins = [
    new HtmlWebpackPlugin({
        filename: path.resolve(distRoot, 'index.html'),
        template: path.resolve(srcRoot, 'index-template.ejs')
    })
];

if (isProduction) {
    const UglifyJSPlugin = require('uglifyjs-webpack-plugin');

    plugins.push(
        new UglifyJSPlugin()
    );
} else {
    plugins.push(new webpack.HotModuleReplacementPlugin());
}

module.exports = {
    entry: {
        app: './src/app/index.js'
    },
    output: {
        path: distRoot,
        filename: '[name]-dist.' + env + '.js'
    },
    module: {
        rules: [
            {
                test: /(\.jsx|\.js)$/,
                exclude: /node_modules/,
                use: 'babel-loader'
            },
            {
                test: /\.css$/,
                exclude: /node_modules/,
                use: [{loader: 'style-loader'}, {loader: 'css-loader', options: {modules: true}}]
            }
        ]
    },

    plugins: plugins
};