import {fireEvent, render} from "@testing-library/vue";
import Login from "@/views/Login.vue";
import {createLocalVue} from "@vue/test-utils";
import VueRouter from "vue-router";
import VueCookies from "vue-cookies";

const localVue = createLocalVue()
localVue.use(VueRouter)
localVue.use(VueCookies)

const routes = [{path: '/login', component: Login}]

const router = new VueRouter({
    routes
})

describe('Test login user', () => {
    const login = 'Anya100500'
    const password = '100500'

    beforeEach(() => {
            localVue.$cookies.remove("user_id")
        }
    )

    test('correct login', async () => {
        const {getByPlaceholderText, getByText} = render(Login, {
            localVue,
            router,
            stubs: ['router-link']
        })
        const usernameForm = getByPlaceholderText("Username")
        await fireEvent.update(usernameForm, login)
        const passwordForm = getByPlaceholderText("Password")
        await fireEvent.update(passwordForm, password)
        const loginButton = getByText('Вход')
        await fireEvent.click(loginButton)
        expect(localVue.$cookies.get("user_id")).toBe(password)
    })

    test('incorrect login', async () => {
        const {getByPlaceholderText, getByText} = render(Login, {
            localVue,
            router,
            stubs: ['router-link']
        })
        const usernameForm = getByPlaceholderText("Username")
        await fireEvent.update(usernameForm, 'abdiybdiy')
        const passwordForm = getByPlaceholderText("Password")
        await fireEvent.update(passwordForm, '123123')
        const loginButton = getByText('Вход')
        await fireEvent.click(loginButton)
        expect(localVue.$cookies.get("user_id")).toBeNull()
    })
})