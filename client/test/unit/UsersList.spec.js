import {createLocalVue, mount} from "@vue/test-utils"
import {describe, test} from "@jest/globals"
import UsersList from "@/components/UsersList.vue"
import VueRouter from "vue-router";

const localVue = createLocalVue()
localVue.use(VueRouter)

describe("Test UsersList", () => {
    test('check length of users list', () => {
        const wrapper = mount(UsersList, {
            stubs: ['router-link'],
            propsData: {
                users: [
                    {id: 1, name: 'asdf', password: '111'},
                    {id: 2, name: 'qwer', password: '123123'},
                    {id: 3, name: 'erty', password: '123123'}
                    ]
            }
        })
        // console.log(wrapper.html())
        const rlWrappers = wrapper.find('ul').findAll('router-link-stub')
        expect(rlWrappers.length).toBe(3)
    });

    test('check length of empty users list', () => {
        const wrapper = mount(UsersList, {
            stubs: ['router-link'],
            propsData: {
                users: []

            }
        })
        // console.log(wrapper.html())
        const rlWrappers = wrapper.find('ul').findAll('router-link-stub')
        expect(rlWrappers.length).toBe(0)
    });
});
