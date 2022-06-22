describe('Adding/ Editing and Deleting item from Cart', () => {

  
     it('Handling new Browser Window', function () {
         cy.visit('https://www.etsy.com/')
         cy.wait(6000);
        
         // Clicking on Cart Icon
      cy.get(':nth-child(2) > .wt-text-link-no-underline > .wt-horizontal-center > .wt-position-relative > .query-image').click()
       
      // Selecting Item from Cart
      cy.get('.wt-grid__item-xs-7 > .wt-btn').click()
     
      //Adding to Cart
      cy.get('#variation-selector-0').select('Digital File Only (USD 85.00)')
      cy.get('#listing-page-personalization-textarea').type('ABC',{delay:200})
      cy.wait(2000);
      cy.get('.add-to-cart-form > div.wt-width-full > .wt-btn').click()
      cy.wait(2000);
      // Editing the item that are added to Cart
      cy.get('.wt-hide-xs > .wt-grid > .wt-grid__item-xs-5 > :nth-child(1) > :nth-child(1) > .wt-select > .wt-select__element').select('10')
      cy.wait(2000);
      
      // Deleting Item From Cart
      cy.get('.wt-pr-xs-1 > a > .wt-btn').click();
     // cy.get('wt-text-center-xs > .wt-text-heading-01').should('have.text','Your basket is empty.')
     // cy.get('.wt-text-center-xs > .wt-text-heading-01').
     cy.get('.wt-text-center-xs > .wt-text-heading-01').should('have.text','\n            Your basket is empty.\n        ')
    })
 })