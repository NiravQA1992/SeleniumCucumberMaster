Feature: Account Creation

  Scenario: TC01_Retention_officer_create_a_case_for_a_new_account(Account_creation)_and_asignate_a_llamada_task_with_MC_tengo_miedo_a_quedarme_sin_trabajo
    #Validate that retention officer can create a new case for a new customer with MC as tengo miedo a quedarme sin trabajo, and then  create a llamada task for that case
    Given the user navigate to "https://latamcrm--qa.lightning.force.com"
    When the user enter "hialtamiranol@@metlife.com.mx.latam.qa.super" into input field having xpath "Username"
    And the user enter "vision2020" into input field having xpath "Password"
		And the user click on element having xpath "LoginButton"