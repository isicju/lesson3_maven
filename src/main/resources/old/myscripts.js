function getDataFromServerAndShow() {
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:8080/users';
    Http.open("GET", url);
    Http.send();

    Http.onreadystatechange = (e) => {
        alert(Http.responseText)
    }
}