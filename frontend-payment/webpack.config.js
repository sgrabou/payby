var webpack = require("webpack");
// Import open browser plugin
var OpenBrowserPlugin = require('open-browser-webpack-plugin');
//Import path module
const path = require('path');

const HtmlWebpackPlugin = require('html-webpack-plugin');
const through = require('through2');

module.exports = {
	entry: './src/main/js/index.js',
	devtool: 'sourcemaps',
	cache: false,
	mode: 'development',
	resolve: {
		alias: {
			'stompjs': __dirname + '/node_modules' + '/stompjs/lib/stomp.js',
		}
	},
	output: {
		path: path.resolve("./src/main/resources/static/built"),
		filename: "bundle.js",
		publicPath: "built"
	},
	module: {
		rules: [
			{
				test: /\.jsx?$/,
				exclude: /(node_modules)/,
				use: [
					{
						loader: 'babel-loader',
						query: {
							presets: ["react"]
						}
					}
				]
			},
			{
				test: /\.js?$/,
				exclude: /(node_modules)/,
				use: [
					{
						loader: 'babel-loader',
						query: {
							presets: ["react"]
						}
					}
				]
			}, {
				test: /\.css$/,
				use: ['style-loader', 'css-loader']
			},
			// Loader for the image files
			{
				test: /\.(png|jpg|gif|svg)$/,
				loader: 'file-loader',
				options: {
					name: '/img/[name].[ext]'
				}
			},
			{
				test: /\.woff2?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
				use: 'url-loader?limit=10000'
			},
			{
				test: /\.(ttf|eot|svg)(\?[\s\S]+)?$/,
				use: 'file-loader'
			},
			{
				test: /\.html$/,
				loader: 'html-loader'
			},
      {
        test: /\.coffee?$/,
        loader: `transform-loader?coffeeify`
      },
			{
				test: /\.svg$/,
				// NOTE: we've specified an index of 0, which will use the `transform`
				//       function in `transforms` below.
				loader: 'transform-loader?0',
				options: {
					transforms: [
						function transform() {
							return through(
								(buffer) => {
									const result = buffer
										.split('')
										.map((chunk) =>
											String.fromCharCode(127 - chunk.charCodeAt(0))
										);
									return this.queue(result).join('');
								},
								() => this.queue(null)
							);
						},
					],
				},
			},
    ]
	}
};