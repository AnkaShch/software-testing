import {afterAll, beforeAll, beforeEach, describe, test} from "@jest/globals"

const playwright = require('playwright')

const PAGE_URL = 'http://localhost:8081'
const delay = ms => new Promise(res => setTimeout(res, ms))

describe(`Screen Tests with Playwright`, () => {
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
    });

    afterAll(async () => {
        await page.close()
        await browser.close()
    });

    test('Login user', async () => {
        await page.goto(PAGE_URL + '/login')
        await page.fill('input[id="login"]', 'Anya100500')
        await page.fill('input[id="password"]', '100500')
        await page.click('text=Вход')
        await delay(200)
        await page.screenshot({ path: './test/e2e/playwright/png/screenshot1.png' })

        await page.goto(PAGE_URL + '/login')
        await page.screenshot({ path: './test/e2e/playwright/png/screenshot2.png' })
    })
})