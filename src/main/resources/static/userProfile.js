'use strict';

userProfile()

function userProfile() {
    fetch("http://localhost:8080/userApi/profile")
        .then(res => res.json())
        .then(js => {
            $('#emailUser').append(`<span>${js.email}</span>`)
            $('#roleUser').append(`<span>${js.shortRole}</span>`)
            const user = `$(
                    <tr>
                        <td>${js.id}</td>
                        <td>${js.firstName}</td>
                        <td>${js.lastName}</td>
                        <td>${js.age}</td>
                        <td>${js.email}</td>
                        <td>${js.shortRole}</td>
                    </tr>)`;
            $('#oneUser').append(user)
        })
}