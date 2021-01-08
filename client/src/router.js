import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home'
import Wall from "@/views/Wall";
import Registration from "@/views/Registration";
import Login from "@/views/Login";
import Hello from "@/views/Hello";
import Users from "@/views/Users";

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            component: Home
        },
        {
            path: '/registration',
            component: Registration
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/hello',
            component: Hello
        },
        {
            path: '/users',
            component: Users
        },
        {
            path: '/user/:id',
            name: 'user',
            component: Wall
        },
    ]
})