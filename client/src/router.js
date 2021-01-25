import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home'
import Wall from "@/views/Wall";
import Registration from "@/views/Registration";
import Login from "@/views/Login";
import Users from "@/views/Users";

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/registration',
            name: 'registration',
            component: Registration
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/users',
            name: 'users',
            component: Users
        },
        {
            path: '/user/:id',
            name: 'user',
            component: Wall
        },
    ]
})