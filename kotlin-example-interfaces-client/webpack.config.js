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
        app: './src/app/index.tsx'
    },
    output: {
        path: distRoot,
        filename: '[name]-dist.' + env + '.js'
    },
    resolve: {
        extensions: ['.ts', '.tsx', '.js', '.json']
    },
    module: {
        rules: [
            {
                test: /(\.tsx?|\.jsx?)$/,
                use: 'ts-loader',
                exclude: /node_modules/
            },
            {
                test: /(\.jsx|\.js)$/,
                exclude: /node_modules/,
                use: 'babel-loader'
            },
            {
                test: /\.css$/,
                exclude: /node_modules/,
                use: [
                    {
                        loader: 'style-loader'
                    },
                    {
                        loader: 'typings-for-css-modules-loader',
                        options: {
                            modules: true,
                            namedExport: true
                        }
                    }]
            }
        ]
    },

    plugins: plugins
};