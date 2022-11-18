canvas = document.getElementById('canvas');
let ctx = canvas.getContext('2d');
let dataScript = document.getElementById("myjson").textContent;
let data = JSON.parse(dataScript);

const srcs = ["img/backGround.jpeg", "img/coin.png", "img/key.png", "img/wallH.png", "img/wallV.png",
    "img/doorH.png", "img/doorV.png", "img/hallWayH.png", "img/hallWayV.png"];
const images = srcs.map((src) => {
    const image = new Image();
    image.src = src;
    return image;
});
const imagesLoaded = () => images.every((image) => image.complete);
images.forEach((image) => {
    image.onload = () => {
        if (imagesLoaded()) {
            draw(images);
        }
    };
});


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
        window.location.assign("/getCoin");
    }
    if (x >= 525 && y >= 305 && x <= 580 && y <= 360) {
        console.log("Key")
        window.location.assign("/getKey");
    }
});
function draw(images) {
    ctx.drawImage(images[0], 0, 0);
    if (data.items.Coin != "[null]") {
        ctx.drawImage(images[1], 688, 303, 60, 60);
    }
    if (data.items.Key != "[null]") {
        ctx.drawImage(images[2], 523, 304, 60, 60);
    }
    switch (data.Walls.N) {
        case "Wall":
            ctx.drawImage(images[3], 605, 103, 64, 12);
            break;
        case "HallWay":
            ctx.drawImage(images[7], 605, 103, 64, 12);
            break;
        case "Door":
            ctx.drawImage(images[5], 605, 103, 64, 12);
            break;
    }
    switch (data.Walls.S) {
        case "Wall":
            ctx.drawImage(images[3], 607, 382, 64, 12);
            break;
        case "HallWay":
            ctx.drawImage(images[7], 607, 382, 64, 12);
            break;
        case "Door":
            ctx.drawImage(images[5], 607, 382, 64, 12);
            break;
    }
    switch (data.Walls.E) {
        case "Wall":
            ctx.drawImage(images[4], 767, 222, 16, 58);
            break;
        case "HallWay":
            ctx.drawImage(images[8], 767, 222, 16, 58);
            break;
        case "Door":
            ctx.drawImage(images[6], 767, 222, 16, 58);
            break;
    }
    switch (data.Walls.W) {
        case "Wall":
            ctx.drawImage(images[4], 493, 221, 16, 58);
            break;
        case "HallWay":
            ctx.drawImage(images[8], 493, 221, 16, 58);
            break;
        case "Door":
            ctx.drawImage(images[6], 493, 221, 16, 58);
            break;
    }
};