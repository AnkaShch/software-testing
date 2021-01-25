const PAGE_URL = 'http://localhost:8081'
describe('`App Tests with Cypress', () => {
    it('home page', () => {
        cy.visit(PAGE_URL)
        cy.get('#home').should('be.visible')
        cy.wait(1000)
        cy.get('#home').contains('Пользователи').click()
        cy.wait(2000)
        cy.get('#users').contains('Kate').click()
        cy.wait(2000)
        cy.get('#wall').contains('Пользователи').click()
        cy.wait(1000)
        cy.get('#users').contains('Anya100500').click()
        cy.wait(2000)
        cy.get('#wall').contains('Home').click()
        cy.wait(1000)
        cy.get('#home').should('be.visible')
    })
})