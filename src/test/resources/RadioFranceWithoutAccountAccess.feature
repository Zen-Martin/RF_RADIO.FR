Feature: Re-Test Cases for Radio France Website without account Access

  Background:
    Given User is on homepage

  @Bug775
  Scenario: Check that link redirection content appear*
    When User get on **cercle des amis** page
    And User click on specific link
    Then User should see effective content depend on link*
    And User get on **another page** check specific links
    Then user should see same content

  @Bug778
  Scenario: Check that voice content appear
    When User get on **entreprise proximite** page
    And User click on the voice
    Then User should see effective content on voice

  @Bug779
  Scenario: Check that brochure content appear
    When User get on **brochures** page
    And User click on brochure
    Then User should see effective content on brochure

  @Bug780
  Scenario: Check that link redirection content appear
    When User get on **choeur de radio** page
    And User click on differents links
    Then User should see effective content depend on links

  @Bug781
  Scenario: Check that info cookie network link content appear
    When User get on **info cookies** page
    And User click on cookie network
    Then User should see effective content on cookie network

  @Bug782
  Scenario: Check that info cookie support-apple link content appear
    When User get on **info cookies** page
    And User click on support-apple
    Then User should see effective content on support-apple

  @Bug783
  Scenario: Check that prix italia link content appear
    When User get on **prix italia** page
    And User click on lemouv link
    Then User should see effective lemouv content

  @Bug784
  Scenario: Check that editions radio france links redirections contents appear
    When User get on **editions radio france recompensees** page
    And User click on algeria_war link
    And User get back on **previous page** check specific links
    Then user should see effectives contents

  @Bug785
  Scenario: Check that kiosque radio link content appear
    When User get on **production edition radio recompensee** page
    And User click on kiosque-radio link
    Then User should see effective kiosque-radio content

  @Bug786
  Scenario: Check that international radio award link content appear
    When User get on **radio france new-york recompense** page
    And User click on international-radio-award link
    Then User should see effective international-radio-award content

  @Bug798
  Scenario: Check that article culture link content appear
    When User get on **article culture** page
    And User click on article culture n16 link
    Then User should see effective article culture n16 content

  @Bug799
  Scenario: Check that scene française links contents appears
    When User get on **scene française** page
    And User click on two specific links
    Then User should see two effectives content depend on link
