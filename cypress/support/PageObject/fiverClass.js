class fiverClass
{
visitURl(){
    cy.visit('https://codemachsolutions.com/')
}
Search(){
    
    cy.get('#search_button > .icon-search-fine').click();
    cy.wait(3000)
    cy.get('input[name=s]').type("Irfan Ullah",{ delay: 100 }).type('{enter}');
    cy.get('#ht-ctc-chat > div.ctc-analytics').click();
    cy.wait(3000);
    cy.get('.icon-menu-fine').click({force:true}).wait(3000);
    cy.get('#menu-item-10290 > a').click({force:true})
    cy.get('#wpforms-10300-field_4').type('Irfanullah')
   cy.get('#wpforms-10300-field_1').type('irfan.khan24460@gmail.com')
   cy.get('#wpforms-10300-field_3').type('Testing of website')
   cy.get('#wpforms-10300-field_2').type('For Testing purpose please ignore')
   cy.get('#wpforms-submit-10300').click({force:true})
}
Email_Passw(e,p){
    const email=cy.get('#username')
    email.clear()
    email.type(e, {delay: 200})
    const pass=cy.get('input[name=password]')
    pass.clear()
    pass.type(p,{delay: 200})
    return (e,p)
}
//cy.get('input[name=username]').click().wait(1000).type('demoadmin', {delay: 200}).should('have.value', 'demoadmin')
loginbtn(){
   const logn= cy.get('.col-md- > .btn')
   logn.click({force:true})
}
reservation()
{
   // var seconds ='';
   var minutes ='';
    var hours ='';
    var day='';
    var month='';
    var year='';
    var dt = new Date();
    //Get Time
     if (parseInt(dt.getHours()) < 10) {hours = "0" + dt.getHours();} else hours = dt.getHours();
    if (parseInt(dt.getMinutes()) < 10) {minutes = "0" + dt.getMinutes();} else minutes = dt.getMinutes();
    //if (parseInt(dt.getSeconds()) < 10) {seconds = "0" + dt.getSeconds();} else seconds = dt.getSeconds();
     var time = hours + ":" + minutes;
    // cy.log(time);
    
    //Get Date 
    if (parseInt(dt.getMonth()+1) < 10) {month = "0" + (dt.getMonth()+1)} else month = dt.getMonth()+1;
    if (parseInt(dt.getFullYear()) < 10) {year = "0" + dt.getFullYear();} else year = dt.getFullYear();
    if (parseInt(dt.getDate()) < 10) {day = "0" + dt.getDate();} else day = dt.getDate();
    var todayDate =  month+ "/" + day + "/" + year;
   // cy.log(todayDate);

    cy.get('#layout-condensed-toggle > .material-icons').click()
    cy.get('[style=""][title="Add Reservation"] > a > .fa').click()
   
    cy.wait(2000)
    cy.viewport(1000, 550)

    //Customer Information
    cy.get('#s2id_account_id > .select2-choice > .select2-chosen').click({ multiple: true })
    cy.get(':nth-child(285) > .select2-result-label').click()
    cy.get('#cal_name').type('Test Requester', {delay: 200})
    cy.get('#cus_po').type('9876543321', {delay: 200})
    //Customer Information -----End 

    //Trip Information
    cy.get('#service_id').select('Test').should('have.value', '79')
    cy.get('#loc_date').type('06/10/2021', {delay: 200})
    cy.get('tbody > :nth-child(2) > .active').click();
    cy.get(':nth-child(6) > :nth-child(3) > .form-group > .controls > .input-group').type('12:13')


    cy.get('#q_date').type(todayDate, {delay: 200}  )// Opintment Date for trip

    //var time = today.getHours() + ":" + today.getMinutes();
    //cy.log(today.getMinutes())
cy.log(time)
    cy.get('#default-picker').type(time);
    cy.get(':nth-child(1) > .col-md-12').click()
    //Trip Information ----- End

    // Pick Up Information
    cy.get('#service1_pickup').select('Medical Team').should('have.value', '28')
    cy.get('#service1_meet_where').select('Other').should('have.value', '37')
    cy.get('#pk_location').type("ariz", { delay: 100 }).wait(1000).type('{downarrow}{enter}'); // location drop down from ggole suggestion
    cy.get('#pk_suite').type("3457", { delay: 100 })
    cy.get('#pk_phone').type("00000000000000000", { delay: 100 })
    cy.get('#pk_tail_number').type("F23L", { delay: 100 })
    cy.get('#pk_air_data').type("Test Air Data 12345", { delay: 100 })
    cy.get(':nth-child(4) > :nth-child(3) > .form-group > .controls > .input-group').type('12:13')
    cy.get('#pk_arrival_flage').select('Departure').should('have.value', '0')

    cy.get('#pk_notes').type("Pick Up Testing Notes", { delay: 100 })
    //Pick Up information ------End

    //Drop off Information

   //General information ----- End.

    //Provider information 

}
}
export default fiverClass