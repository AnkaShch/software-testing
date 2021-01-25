const PAGE_URL = 'http://localhost:8081'

describe('`App Tests with Cypress', () => {
    it('home page', () => {
        cy.visit(PAGE_URL)
        cy.get('#home').should('be.visible')
        cy.get('#home').should('contain', 'Дуров верни стеночку!')
    })
    it ('login user', () => {
        cy.visit(PAGE_URL + '/login')
        cy.get('#login').type('Anya100500')
        cy.get('#password').type('100500')
        cy.get('#login-button').click()
        cy.get('#wall').should('be.visible')
        cy.get('#exit-button').should('contain', 'Выход')
        cy.get('h1').should('contain', 'Стеночка')
    })
    it ('incorrect login user', () => {
        cy.visit(PAGE_URL + '/login')
        cy.get('#login').type('abdyabdya')
        cy.get('#password').type('123123')
        cy.get('#login-button').click()
        cy.url().should('contain', 'http://localhost:8081/login')
    })
    it ('relogin user', () => {
        cy.visit(PAGE_URL + '/login')
        cy.get('#login').type('Anya100500')
        cy.get('#password').type('100500')
        cy.get('#login-button').click()
        cy.get('#wall').should('be.visible')
        cy.get('#exit-button').click()
        cy.get('#home').should('be.visible')
    })
})