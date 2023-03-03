'use strict';

userProfile()

function userProfile() {
    fetch("http://localhost:8080/userApi/profile")
        .then(res => res.json())
        .then(js => {
            $('#emailUser').append(`<span>${js.email}</span>`)
            $('#roleUser').append(`<span>${js.roles}</span>`)
            const user = `$(
                    <tr>
                        <td>${js.id}</td>
                        <td>${js.firstName}</td>
                        <td>${js.lastName}</td>
                        <td>${js.age}</td>
                        <td>${js.email}</td>
                        <td>${js.roles}</td>
                    </tr>)`;
            $('#oneUser').append(user)
        })
}