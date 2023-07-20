const path = require("path");

module.exports = {
  entry: "./src/frontend/index.tsx",
  output: {
    filename: "theme.js",
    path: path.resolve(__dirname, "src/main/webapp"),
  },
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/,
      },
      {
        test: /\.css$/i,
        use: ["style-loader", "css-loader"],
      },
    ],
  },
  resolve: {
    extensions: ['.tsx', '.ts', '.js'],
  },
};