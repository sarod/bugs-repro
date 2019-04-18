'use strict';
const HtmlWebpackPlugin = require('html-webpack-plugin');

const path = require('path');
module.exports = {
    entry: [
        // The following should not be needed but it is on IE11
        // see https://github.com/babel/babel/issues/7402#issuecomment-484447182
        // 'core-js/modules/es.array.iterator',        
        path.join(__dirname, 'src', 'index.js')
    ],
    output: {
        path: __dirname + '/dist',
        library: 'main',
    },
    module: {
        rules: [{
            test: /\.?js$/,
            exclude: /(node_modules|bower_components)/,
            use: [{
                loader: "babel-loader",
                options: {
                    cacheDirectory: true
                }
            }]
        }]
    },
    plugins: [
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'src/index.html',
            title: 'IE11 Bug'

        })
    ]
}