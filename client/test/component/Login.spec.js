// import {afterEach, beforeEach, test} from "@jest/globals";
// import ServerMock from "mock-http-server";
// import {queryByAttribute} from "@testing-library/dom";
// import {fireEvent, render} from "@testing-library/vue";
// import router from "@/router";
// import Login from "@/views/Login.vue";
// import App from "@/App";
//
// const server = new ServerMock({host: "localhost", port: 3000}, {});
//
// const getById = queryByAttribute.bind(null, 'id');
//
// beforeEach(function (done) {
//     server.start(done);
// });
//
// afterEach(function (done) {
//     server.stop(done);
// });
//
// test('Successful login', async () => {
//
//     const login = 'abcde'
//     const password = 'abcdef'
//
//     server.on({
//         method: 'POST',
//         path: '/login',
//         reply: {
//             headers: {
//                 'Content-Type': 'application/json;charset=utf-8',
//             },
//             mode: 'cors',
//             body: req => JSON.stringify((req.formLog.login === login && req.formLog.password === password))
//         }
//     });
//
//     const wrapper = render(Login, {router});
//
//     const usernameForm = getByText("Имя",{selector: '#login'});
//     await fireEvent.update(usernameForm, 'abcde');
//
//     const passwordForm = getByText("Пароль",{selector: '#password'});
//     await fireEvent.update(passwordForm, 'abcde');
//
//     const button = getByText("Вход", {selector: '#login-button'})
//     await fireEvent.click(button)
//
//     const delay = ms => new Promise(res => setTimeout(res, ms));
//     await delay(100) // waiting for asynchronous query
//     getById(container, "secure")
// })