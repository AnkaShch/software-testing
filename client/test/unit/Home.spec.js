import {describe, test} from "@jest/globals"
import {createLocalVue, shallowMount} from "@vue/test-utils"
import Home from "@/views/Home.vue"
import VueRouter from 'vue-router'
import VueCookies from "vue-cookies";

const localVue = createLocalVue()
localVue.use(VueRouter)
localVue.use(VueCookies)

describe("Home page", () => {
    test("Check all router-links", () => {
        const wrapper = shallowMount(Home, {
            stubs: ['router-link']
        })
        const rlWrappers = wrapper.findAll('router-link-stub')

        expect((rlWrappers.at(0).attributes()).to).toBe('/users')
        expect((rlWrappers.at(1).attributes()).to).toBe('/registration')
        expect((rlWrappers.at(2).attributes()).to).toBe('/login')
    });

    test("Check relogin user", () => {
        const wrapper = shallowMount(Home, {
            localVue,
            stubs: ['router-link']
        })

        // login user with id = 11
        localVue.$cookies.set("user_id", 11)

        const button = wrapper.findAll('button').at(-1)
        button.trigger('click')
        expect(localVue.$cookies.get("user_id")).toBe(null)
    })
})
