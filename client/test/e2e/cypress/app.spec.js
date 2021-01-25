import {afterAll, beforeAll, beforeEach, describe, test, it} from "@jest/globals"

const PAGE_URL = 'http://localhost:8081'

describe('`App Tests with Cypress', () => {
    it('visits home page', () => {
        cy.visit(PAGE_URL);
        cy.get('#home').should('be.visible');
        cy.get('#home').should('contain', 'Дуров верни стеночку!')
    })
    it ('logs in successfully', () => {
        cy.visit(PAGE_URL + '/authorize');
        cy.get('#greeting').should('contain', `Hello, guest!`);
        cy.get('#authorization-login').type(testLogin);
        cy.get('#authorization-button').click();
        cy.get('#greeting').should('contain', `Hello, ${testName}!`);
    })
    it ('home page of user should contain link to budget', () => {
        cy.visit(PAGE_URL);
        cy.get('#home-greeting').should('contain', `Hello, guest!`);
        cy.get('#App-header-link-auth').click();
        cy.get('#authorization-login').type(testLogin);
        cy.get('#authorization-button').click();
        cy.get('#App-header-link').click();
        cy.get('#home-greeting').should('contain', `Hello, ${testName}!`);
        cy.get('#link-to-budget').should('contain', 'To budget');
    })
})