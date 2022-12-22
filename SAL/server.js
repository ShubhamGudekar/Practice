
const express = require('express');
const app  = express();

app.get("/",(req,res)=>{
    res.send(`<h1>Welcome To Transflower Learning</h1>`);
})

app.listen(5000);
console.log("Express Server Started at Port 5000");