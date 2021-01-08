import {setCookie} from "@/utils/Cookie";

export async function CreateAccount(user_name, user_password) {
    try {
        await fetch("http://localhost:8080/api/registration", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            mode: 'cors',
            body: JSON.stringify({
                name: user_name,
                password: user_password
            })
        })
            .then(response => {
                console.log(response)
                response.json().then(data => {
                    setCookie("user_id", data.id)
                    window.location = '/user/' + data.id
                })
            })
    } catch (err) {
        console.log(err)
    }
}