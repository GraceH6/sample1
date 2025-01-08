Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  @first
  Scenario: Sunday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"

   @second
  Scenario: Friday is Friday
    Given today is Friday
    When I ask whether it's Friday yet
    Then I should be told "TGIF"

  @third
  Scenario Outline: Login functionality for various users
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    Then the result should be "<result>"

    Examples:
    |username|password|result  |
    |zhansaya|zhan$aya|cool    |
    |yerlan  |yer1    |cool too|
