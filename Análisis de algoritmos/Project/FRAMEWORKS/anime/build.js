const fs = require('fs');
const compile = require('google-closure-compiler-js').compile;

const fileIn = 'anime.js';
const fileOut = 'anime.min.js';

console.info('Compiling... 😤');

fs.unlink(fileOut, (err) => {
  fs.readFile(fileIn, {encoding: 'utf-8'}, function(err, data) {
    if (err) throw err;
    const flags = {
      jsCode: [{src: data}],
      languageIn: 'ES6',
      languageOut: 'ES5'
    };
    const out = compile(flags);
    fs.writeFile(fileOut, out.compiledCode, function(err) {
      if (err) throw err;
      console.info('Compilation was a success! 😎 🍺');
    });
  });
});