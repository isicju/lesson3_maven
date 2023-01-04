let citiesData = [];
let cityNames = [];
document.onreadystatechange = function () {
    if (document.readyState === "complete") {
        initFirstMapView();
    }
}

function loadCountries() {
    //loading cities localhost:8500/cities
    //parsing cities and adding them to citiesData
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:8500/cities';
    Http.open("GET", url);
    Http.send();

    Http.onreadystatechange = (e) => {
        if (Http.readyState === XMLHttpRequest.DONE) {
            const cities = JSON.parse(Http.responseText);
            for (let i = 0; i < cities.length; i++) {
                citiesData[i] = [cities[i].name, cities[i].latitude, cities[i].longitude];
            }
            for (let i = 0; i < citiesData.length; i++) {
                cityNames[i] = cities[i].name;
            }
            var options = '';
            for (var i = 0; i < cityNames.length; i++) {
                options += '<option value="' + cityNames[i] + '" />';
            }
            var my_countries_list=document.getElementById('CountryDataList');
            my_countries_list.innerHTML = options;

            alert("Cities are loaded!")
        }
    }
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
        if (cityData[0] === cityName) {
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
    let cityName = document.forms.form1.CountryChooser.value;
    if (cityName) {
        const cityData = findCityDataByCityName(cityName)
        if (cityData) {
            setMapLatitudeAndLongitude(cityData[1], cityData[2])
        }
    }
}

function addCityByName(countryName) {
    let my_list = document.getElementById('Country');
    my_list.innerHTML = my_list.innerHTML + '<option value="' + countryName + '">';
}