import {afterAll, beforeAll} from "@jest/globals";

const playwright = require('playwright')

const PAGE_URL = 'http://localhost:8081'
const delay = ms => new Promise(res => setTimeout(res, ms))

describe(`App Tests with Playwright`, () => {
    let browser = null;
    let page = null;

    beforeAll(async () => {
        browser = await playwright['chromium'].launch()
        page = await browser.newPage()

        if (!page) {
            throw new Error("Connection wasn't established");
        }
    });

    beforeEach(async () => {
        await page.goto(PAGE_URL)
        await page.click('text=Выход')
    });

    afterAll(async () => {
        await page.close()
        await browser.close()
    });

    test(`Start at home page`, async () => {
        const paragraph = await page.$('text=Дуров верни стеночку!')
        expect(paragraph).not.toBeNull()
    });

    test('Go to users and back', async () => {
        const toUsers = await page.$('text=Пользователи')
        expect(toUsers).not.toBeNull()
        await toUsers.click()

        const back = await page.$('text=Home')
        expect(back).not.toBeNull()
        await back.click()

        const paragraph = await page.$('text=Дуров верни стеночку!')
        expect(paragraph).not.toBeNull()
    })

    test('Login user', async () => {
        await page.goto(PAGE_URL + '/login')
        await page.fill('input[id="login"]', 'Anya100500')
        await page.fill('input[id="password"]', '100500')
        await page.click('text=Вход')
        await delay(200)
        expect(page.url()).toMatch('http://localhost:8081/user/100500')
        const paragraph = await page.$('text=Стеночка')
        expect(paragraph).not.toBeNull()
        const exitButton = await page.$('text=Выход')
        expect(exitButton).not.toBeNull()
    })

    test('Incorrect login user', async () => {
        await page.goto(PAGE_URL + '/login')
        await page.fill('input[id="login"]', 'abdiybdiy')
        await page.fill('input[id="password"]', '1234')
        await page.click('text=Вход')
        await delay(200)
        expect(page.url()).toMatch('http://localhost:8081/login')
    })

    test('Guess view', async () => {
        await page.goto(PAGE_URL + '/user/100500')
        const paragraph = await page.$('text=Стеночка')
        expect(paragraph).not.toBeNull()
        const exitButton = await page.$('text=Выход')
        expect(exitButton).toBeNull()
    })
});