<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        div {
            height: 200px;
            border: 1px solid black;
            margin-bottom: 20px;
        }

        .abc {
           background-color: yellow;
        }
    </style>

</head>
<body>
    
   <div id="box1"></div>
   <div id="box2"></div>
   <div id="box3"></div>

   <script>
       let box1Dom = document.querySelector("#box1");
       box1Dom.innerHTML = "딸기";
       box1Dom.className = "abc";

       let box2Dom = document.querySelector("#box2");
       download();
     //  let data = await fetch("http://192.168.56.1:8000/download") // promise 나중에 값을  넣어 줄게
        
       box2Dom.innerHTML = "사과";
     
       let box3Dom = document.querySelector("#box3");
       box3Dom.innerHTML = "바나나";

     async function download() {
            let data = await fetch("http://192.168.1.16.1:8000/download"); // promise 나중에 값을  넣어 줄게
            let parseData = await data.text();
          //  box3Dom.innerHTML = parsedata;
            box2Dom.innerHTML = parseData; 
       }

   </script>
</body>
</html>