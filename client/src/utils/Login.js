import {setCookie} from "@/utils/Cookie";
import Users from "@/views/Users";

export async function Login(user_name, user_password) {
    try {
        await fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
            },
            mode: 'cors',
            body: JSON.stringify({
                name: user_name,
                password: user_password,
            }),
        }).then(response => {
            response.json().then(data => {
                console.log(data)
                setCookie("user_id", data)
                window.location = '/user/' + data
            });
        });
    } catch (err) {
        Users.data().users.forEach(data => {
            if (data.name === user_name && data.password === user_password ){
                setCookie("user_id", data.id)
                window.location = '/user/' + data.id
            }
        })
    }
}