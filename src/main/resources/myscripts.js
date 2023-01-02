let citiesData = [];
document.onreadystatechange = function () {
    if (document.readyState === "complete") {
        initFirstMapView();
    }
}

function loadCities() {
    //loading cities localhost:8500/cities
    //parsing cities and adding them to citiesData
    fetch("http://localhost:8500/cities")
        .then(res => res.json())
        .then(data => {
            citiesData = data;
        })
        .then(() => {
            console.log(citiesData);
        });
    console.log("Button city load");

}

function initFirstMapView() {
    let map = L.map('map').setView([51.505, -0.09], 9);
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19
    }).addTo(map);
}

function setMapLatitudeAndLongitude(latitude, longitude) {
    resetMap();
    let map = L.map('map').setView([latitude, longitude], 8);
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {maxZoom: 19}).addTo(map);
}

function findCityDataByCityName(cityName) {
    let cityDataResult = null;
    for (let cityData of citiesData){
        if (cityData.name === cityName) {
            cityDataResult = cityData;
            break;
        }
    }
    return cityDataResult;
}

function resetMap() {
    if (L.DomUtil.get('map')) {
        L.DomUtil.get('map')._leaflet_id = null;
    }
}

function showSelectedCity() {
    let cityName = document.getElementById("currentCityNameId").value;
    if (cityName) {
        const cityData = findCityDataByCityName(cityName)
        if (cityData) {
            setMapLatitudeAndLongitude(cityData.latitude, cityData.longitude)
        }
    }
    console.log("Click Show selected city on map");
}

function addCityByName(countryName) {
    let my_list = document.getElementById("Country");
    my_list.innerHTML = my_list.innerHTML + '<option value="' + countryName + '">';
}