module.exports = api => {
    api.assertVersion('^7.4');
    api.cache.using(() => process.env.NODE_ENV);

    return {
        presets: [
            [
                '@babel/preset-env',
                {
                    "modules": false,
                    "useBuiltIns": "usage",
                    "corejs": {
                        version: 3
                    }
                }
            ]
        ],
        plugins: ['@babel/plugin-syntax-dynamic-import']
    }

};