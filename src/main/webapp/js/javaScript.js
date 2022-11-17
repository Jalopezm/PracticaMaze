canvas = document.getElementById('canvas');
let ctx = canvas.getContext('2d');
let dataScript = document.getElementById("myjson").textContent;
let data = JSON.parse(dataScript);

let bkGround = new Image();
bkGround.src = 'img/backGround.jpeg';
bkGround.onload = () => {
    ctx.drawImage(bkGround, 0, 0);
};
let coin = new Image();
coin.src = 'img/coin.png';
coin.onload = () => {
    if (data.items.Coin != "[null]") {
        ctx.drawImage(coin, 688, 303, 60, 60);
    }
};

let key = new Image();
key.src = 'img/key.png';
key.onload = () => {
    if (data.items.Key != "[null]") {
        ctx.drawImage(key, 523, 304, 60, 60);
    }
};
let wallH = new Image();
wallH.src = 'img/wallH.png';
let wallV = new Image();
wallV.src = 'img/wallV.png';
let doorH = new Image();
doorH.src = 'img/doorH.png';
let doorV = new Image();
doorV.src = 'img/doorV.png';
let hallWayH = new Image();
hallWayH.src = 'img/hallWayH.png';
let hallWayV = new Image();
hallWayV.src = 'img/hallWayV.png';

function draw() {
    switch (data.Walls.N) {
        case "Wall":
            ctx.drawImage(wallH, 605, 103, 64, 12);
            break;
        case "HallWay":
        ctx.drawImage(hallWayH, 605, 103, 64, 12);
            break;
        case "Door":
            ctx.drawImage(doorH, 605, 103, 64, 12);
            break;
    }
    switch (data.Walls.S) {
        case "Wall":
            ctx.drawImage(wallH, 607, 382, 64, 12);
            break;
        case "HallWay":
                ctx.drawImage(hallWayH, 607, 382, 64, 12);
            break;
        case "Door":
            ctx.drawImage(doorH, 607, 382, 64, 12);
            break;
    }
    switch (data.Walls.E) {
        case "Wall":
            ctx.drawImage(wallV, 767, 222, 16, 58);
            break;
        case "HallWay":
        ctx.drawImage(hallWayV, 767, 222, 16, 58);
            break;
        case "Door":
            ctx.drawImage(doorV, 767, 222, 16, 58);
            break;
    }
    switch (data.Walls.W) {
        case "Wall":
            ctx.drawImage(wallV, 493, 221, 16, 58);
            break;
        case "HallWay":
                ctx.drawImage(hallWayV, 493, 221, 16, 58);
            break;
        case "Door":
            ctx.drawImage(doorV, 493, 221, 16, 58);
            break;
    }
};

canvas.addEventListener('click', event => {
    let rect = canvas.getBoundingClientRect();
    let x = Math.round(event.clientX - rect.left);
    let y = Math.round(event.clientY - rect.top);
    console.log("Coordinate x: " + x,
        "Coordinate y: " + y);
    if (x >= 552 && y >= 11 && x <= 717 && y <= 57) {
        console.log("N")
        window.location.assign("/nav?move=North");
    }
    if (x >= 552 & y >= 441 && x <= 718 && y <= 488) {
        console.log("S")
        window.location.assign("/nav?move=South");
    }
    if (x >= 827 && y >= 167 && x <= 874 && y <= 332) {
        console.log("E")
        window.location.assign("/nav?move=East");
    }
    if (x >= 388 && y >= 167 && x <= 442 && y <= 331) {
        console.log("W")
        window.location.assign("/nav?move=West");
    }
    if (x >= 688 && y >= 303 && x <= 742 && y <= 356) {
        console.log("Coin")
        window.location.assign("/nav?item=Coin");
    }
    if (x >= 525 && y >= 305 && x <= 580 && y <= 360) {
        console.log("Key")
        window.location.assign("/nav?item=Key");
    }
});
function recharge(){
window.location.href = "nav.jsp";
}