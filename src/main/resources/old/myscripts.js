function getDataFromServerAndShow() {
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:8500/users';
    Http.open("GET", url);
    Http.send();

    Http.onreadystatechange = (e) => {
        if (Http.readyState === XMLHttpRequest.DONE) {
            const users = JSON.parse(Http.responseText);
            for (let i = 0; i < users.length; i++) {
                appendUser(users[i].id, users[i].firstname, users[i].lastname, users[i].email);
            }
        }
    }
}

function appendUser(id, firstName, lastName, email) {
    let myTable = document.getElementById('usersTable').getElementsByTagName('tbody')[0];

    let row = myTable.insertRow();
    let cell0 = row.insertCell(0);
    let cell1 = row.insertCell(1);
    let cell2 = row.insertCell(2);
    let cell3 = row.insertCell(3);

    cell0.innerHTML = id;
    cell1.innerHTML = firstName;
    cell2.innerHTML = lastName;
    cell3.innerHTML = email;
}

function removeById() {
    let removeId = document.getElementById('removeId').value;
    const table = document.getElementById("usersTable");

    for (let i = 0; i < table.rows.length; i++) {
        for (let j = 0; j < table.rows[i].cells.length; j++) {
            const cell =  table.rows[i].cells[j];
            if (cell.innerText === removeId) {
                table.deleteRow(i);
                return;
            }
        }
    }
}