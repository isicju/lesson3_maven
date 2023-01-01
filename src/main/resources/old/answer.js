const Http = new XMLHttpRequest();
const url = 'http://localhost:8500/cities';
Http.open("GET", url);
Http.send();

Http.onreadystatechange = (e) => {
    if (Http.readyState === XMLHttpRequest.DONE) {
        const cities = JSON.parse(Http.responseText);
        for (let i = 0; i < cities.length; i++) {
            citiesData.push({
                country: cities[i].country,
                name: cities[i].name,
                latitude: cities[i].latitude,
                longitude: cities[i].longitude
            })
            addCityByName(cities[i].name);
        }
    }
}

<button style="padding: 10px; margin: 10px" type="button" className="btn btn-primary" onClick="loadCountries()">Click To
    Load Countries
</button>


<button style="padding: 10px; margin: 10px" type="button" className="btn btn-primary" onClick="showSelectedCity()">Click
    To
    Show city on the map
</button>