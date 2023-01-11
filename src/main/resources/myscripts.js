let citiesData = [];
document.onreadystatechange = function () {
    if (document.readyState === "complete") {
        initFirstMapView();
    }
}

function loadCountries() {
    //loading cities localhost:8500/cities
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:8500/cities';
    Http.open("GET", url);
    Http.send();
    //parsing cities and adding them to citiesData
    Http.onreadystatechange = (e) => {
        if (Http.readyState === XMLHttpRequest.DONE) {
            const cities = JSON.parse(Http.responseText);
            for (let i = 0; i < cities.length; i++) {
            citiesData[i] = [cities[i].country, cities[i].city, cities[i].latitude, cities[i].longitude];
                addCityByName(cities[i].city);
            }
        }
    }
}

function initFirstMapView() { //первый просмотр карты
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
        if (cityData[1] === cityName) {
            cityDataResult = cityData;
            break;
        }
    }
    return cityDataResult;
}

function resetMap() { //сброс карты
    if (L.DomUtil.get('map')) {
        L.DomUtil.get('map')._leaflet_id = null;
    }
}

function showSelectedCity() {
    let cityName = document.getElementById("currentCityNameId").value;
    if (cityName) {
        const cityData = findCityDataByCityName(cityName)
        if (cityData) {
            setMapLatitudeAndLongitude(cityData[2], cityData[3])
        }
    }
}

function addCityByName(countryName) {
    let my_list = document.getElementById("Country");
    my_list.innerHTML = my_list.innerHTML + '<option value="' + countryName + '">';
}