Feature: As a user I want to get ability to use menu sections

  @smoke
  Scenario Outline: Docs sections should contain appropriate columns
    Given the user opens Cucumber website
    When the user clicks on the cookies
    And the user clicks on the <section> section
    And the user clicks on the <item> item
    Then page with title <pageTitle> is displayed
    Examples:
      | section         | item      | pageTitle |
      | "Documentation" | "Gherkin" | "Gherkin" |
