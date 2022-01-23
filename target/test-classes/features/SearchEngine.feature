Feature:
'When I go to the Google search page, and search for an item,I should be seen the item related to the result.'

  Scenario Outline: Happy Scenario
    Given that I have gone to "https://www.google.com/" page with chrome browser
     When I fill <query> to the search box
      And Click on suggest <suggest> word
     Then The "<suggest>" should be mentioned in the results
      And close browsers
  
    Examples: 
      | query  | suggest        | 
      | python | python online  | 
  
  Scenario Outline: Negative Scenario
    Given that I have gone to "https://www.google.com/" page with chrome browser
     When I fill <query> to the search box
      And Click the Search Button
     Then The "<query>" should not be mentioned in the results
      And close browsers
  
    Examples: 
      | query  | 
      | pyhton | 
  
  Scenario Outline: E2E Scenario
    Given that I have gone to "https://www.google.com/" page with chrome browser
     When I fill <query> to the search box
      And Click on suggest <suggest> word
     Then The "<suggest>" should be mentioned in the results
      And click the link <link>
      And close browsers
  
    Examples: 
      | query  | suggest | link                 | 
      | python | python   | Python For Beginners | 
  
  
