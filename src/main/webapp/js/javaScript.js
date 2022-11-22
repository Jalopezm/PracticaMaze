canvas = document.getElementById('canvas');
let ctx = canvas.getContext('2d');
let dataScript = document.getElementById("myjson").textContent;
let data = JSON.parse(dataScript);

const srcs = ["img/backGround.png", "img/coin.png", "img/key.png", "img/wallH.png", "img/wallV.png",
    "img/doorH.png", "img/doorV.png"];
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
    if (x >= 785 && y >= 100 && x <= 915 && y <= 116) {
        window.location.assign("/open?dir=North");
    }
    if (x >= 785 & y >= 371 && x <= 915 && y <= 387) {
        window.location.assign("/open?dir=South");
    }
    if (x >= 640 && y >= 190 && x <= 652 && y <= 319) {
        window.location.assign("/open?dir=West");
    }
    if (x >= 1018 && y >= 190 && x <= 1033 && y <= 319) {
        window.location.assign("/open?dir=East");
    }
    if (x >= 702 && y >= 9 && x <= 974 && y <= 56) {
        console.log("N")
        window.location.assign("/nav?dir=North");
    }
    if (x >= 702 & y >= 431 && x <= 974 && y <= 477) {
        console.log("S")
        window.location.assign("/nav?dir=South");
    }
    if (x >= 1079 && y >= 167 && x <= 1126 && y <= 380) {
        console.log("E")
        window.location.assign("/nav?dir=East");
    }
    if (x >= 536 && y >= 105 && x <= 596 && y <= 380) {
        console.log("W")
        window.location.assign("/nav?dir=West");
    }
    if (x >= 945 && y >= 298 && x <= 1000 && y <= 351) {
        console.log("Coin")
        window.location.assign("/getCoin");
    }
    if (x >= 670 && y >= 299 && x <= 730 && y <= 351) {
        console.log("Key")
        window.location.assign("/getKey");
    }
});
function draw(images) {
    ctx.drawImage(images[0], 0, 0);
    if (data.items.Coin != "[null]") {
        ctx.drawImage(images[1], 945, 298, 60, 60);
    }
    if (data.items.Key != "[null]") {
        ctx.drawImage(images[2], 670, 299, 60, 60);
    }
    switch (data.Walls.N) {
        case "Wall":
            ctx.drawImage(images[3], 770, 87, 164, 40);
            break;
        case "HallWay":
            break;
        case "Door":
            ctx.drawImage(images[5], 770, 87, 164, 40);
            break;
    }
    switch (data.Walls.S) {
        case "Wall":
            ctx.drawImage(images[3], 770, 360, 164, 40);
            break;
        case "HallWay":
            break;
        case "Door":
            ctx.drawImage(images[5], 770, 360, 164, 40);
            break;
    }
    switch (data.Walls.E) {
        case "Wall":
            ctx.drawImage(images[4], 1010, 170, 40, 164);
            break;
        case "HallWay":
            break;
        case "Door":
            ctx.drawImage(images[6], 1010, 170, 40, 164);
            break;
    }
    switch (data.Walls.W) {
        case "Wall":
            ctx.drawImage(images[4], 627, 180, 40, 164);
            break;
        case "HallWay":
            break;
        case "Door":
            ctx.drawImage(images[6], 627, 180, 40, 164);
            break;
    }
};