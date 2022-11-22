canvas = document.getElementById('canvas');
let ctx = canvas.getContext('2d');
let dataScript = document.getElementById("myjson").textContent;
let data = JSON.parse(dataScript);
let pj;
let start, previousTimeStamp, idleStart;
let done = false
let idleCancel = false;

const srcs = ["img/backGround.png", "img/coin.png", "img/key.png", "img/wallH.png", "img/wallV.png",
    "img/doorH.png", "img/doorV.png", "img/pj.png"];
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
requestAnimationFrame(idle);
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
        window.cancelAnimationFrame(idle);
        requestAnimationFrame(moveN);
    }
    if (x >= 702 & y >= 431 && x <= 974 && y <= 477) {
        console.log("S")
        window.cancelAnimationFrame(idle);
        requestAnimationFrame(moveS);
    }
    if (x >= 1079 && y >= 167 && x <= 1126 && y <= 380) {
        console.log("E")
        idleCancel = true;
        requestAnimationFrame(moveE);
    }
    if (x >= 536 && y >= 105 && x <= 596 && y <= 380) {
        console.log("W")
        window.cancelAnimationFrame(idle);
        requestAnimationFrame(moveW);
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
    pj = images[7];
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
let numero = 0;

function moveN(timestamp) {
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.1 * elapsed, 100);
        draw(images);
        ctx.drawImage(pj, numero * 39, 3 * 62, 39, 62,
            810, 200 - count, 39 * 1.2, 62 * 1.2);
        if (count % 20 == 0) {
            numero += 1;
            if (numero > 3) {
                numero = 0;
            }
        }
        if (count === 100) done = true;
    }

    if (elapsed < 5000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveN);
        } else {
            window.location.assign("/nav?dir=North");
        }
    }
}
function moveS(timestamp) {
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.1 * elapsed, 100);
        draw(images);
        ctx.drawImage(pj, numero * 39, 0 * 62, 39, 62,
            810, 200 + count, 39 * 1.2, 62 * 1.2);
        if (count % 20 == 0) {
            numero += 1;
            if (numero > 3) {
                numero = 0;
            }
        }
        if (count === 100) done = true;
    }

    if (elapsed < 5000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveS);
        } else {
            window.location.assign("/nav?dir=South");
        }
    }
}
function moveE(timestamp) {
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.1 * elapsed, 150);
        draw(images);
        ctx.drawImage(pj, numero * 39, 2 * 62, 39, 62,
            810 + count, 200, 39 * 1.2, 62 * 1.2);
        if (count % 20 == 0) {
            numero += 1;
            if (numero > 3) {
                numero = 0;
            }
        }
        if (count === 150) done = true;
    }

    if (elapsed < 5000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveE);
        } else {
            window.location.assign("/nav?dir=East");
        }
    }
}
function moveW(timestamp) {
    if (start === undefined) {
        start = timestamp;
    }
    const elapsed = timestamp - start;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.1 * elapsed, 150);
        draw(images);
        ctx.drawImage(pj, numero * 39, 1 * 62, 39, 62,
            810 - count, 200, 39 * 1.2, 62 * 1.2);
        if (count % 20 == 0) {
            numero += 1;
            if (numero > 3) {
                numero = 0;
            }
        }
        if (count === 150) done = true;
    }

    if (elapsed < 5000) {
        previousTimeStamp = timestamp;
        if (!done) {
            window.requestAnimationFrame(moveW);
        } else {
            window.location.assign("/nav?dir=West");
        }
    }
}
function idle(timestamp) {
    if (idleStart === undefined) {
        idleStart = timestamp;
    }
    const elapsed = timestamp - idleStart;

    if (previousTimeStamp !== timestamp) {
        const count = Math.floor(0.12 * elapsed);
        draw(images);
        ctx.drawImage(pj, 0 * 39, numero * 62, 39, 62,
            810, 200, 39 * 1.2, 62 * 1.2);
        if (count % 25 == 0) {
            numero += 1;
            if (numero > 3) {
                numero = 0;
            }
        }
    }
    if (!idleCancel) {
        window.requestAnimationFrame(idle);
    }
}
function reset(){
 window.location.assign("/reset");
}
