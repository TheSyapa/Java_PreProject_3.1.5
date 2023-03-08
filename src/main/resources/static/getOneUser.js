async function getOneUser(id) {
    let url = "http://localhost:8080/adminApi/user/" + id;
    let response = await fetch(url);
    return await response.json();
}