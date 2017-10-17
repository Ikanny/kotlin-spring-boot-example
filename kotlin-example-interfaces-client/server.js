/**
 * @author ryuikhan
 * @since 2017. 10. 16.
 */
const webpack = require('webpack');
const webpackDevServer = require('webpack-dev-server');
const webpackConfig = require('./webpack.config');
const config = require('./config');

const proxyConfig = config.proxy;

const devServerOptions = {
    publicPath: '/',
    contentBase: './dist',
    hot: true,
    host: proxyConfig.devServerHost,
    proxy: {
        '/api/*': proxyConfig.url
    }
};

webpackDevServer.addDevServerEntrypoints(webpackConfig, devServerOptions);

const compiler = webpack(webpackConfig);
const server = new webpackDevServer(compiler, devServerOptions);

server.listen(proxyConfig.port, proxyConfig.devServerHost, () =>
    console.log('start listening at port', proxyConfig.port)
);