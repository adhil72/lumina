const fs = require('fs');
const path = require('path');

const outputFilePath = path.join(__dirname, 'mapped.txt');
const currentDir = __dirname;

function readFilesRecursively(dir) {
    let fileContents = '';

    const files = fs.readdirSync(dir);
    files.forEach((file, index) => {
        const filePath = path.join(dir, file);
        const stat = fs.lstatSync(filePath);

        if (stat.isDirectory()) {
            fileContents += readFilesRecursively(filePath);
        } else if (file.endsWith('.kt') || file.endsWith('.xml')) {
            const content = fs.readFileSync(filePath, 'utf-8');
            fileContents += `${filePath}\n${content}\n\n`;
        }
    });

    return fileContents;
}

const fileContents = readFilesRecursively(currentDir);
fs.writeFileSync(outputFilePath, fileContents, 'utf-8');
console.log('File mapping saved to', outputFilePath);