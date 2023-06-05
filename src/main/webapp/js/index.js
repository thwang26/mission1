document.getElementById("getMyLocationButton").onclick = function () {
    navigator.geolocation.getCurrentPosition(
        function (position) {
            document.getElementById("lat").value = position.coords.latitude.toFixed(7);
            document.getElementById("lnt").value = position.coords.longitude.toFixed(7);
        },
        function (error) {
            console.log(error);
        }
    );
}

document.getElementById("getNearWifiButton").onclick = function() {
    const lat = document.getElementById("lat").value;
    const lnt = document.getElementById("lnt").value;

    if (lat === "0.0" && lnt === "0.0") {
        alert("위치를 입력해주세요");
    } else {
        location.href = "http://localhost:8080/?lat="+lat+"&lnt="+lnt;
    }
}

function fillZero(elem) {
    if (!elem.value) {
        elem.value = "0.0";
    }
}