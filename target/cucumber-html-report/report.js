$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SearchEngine.feature");
formatter.feature({
  "line": 1,
  "name": "",
  "description": "\u0027When I go to the Google search page, and search for an item,I should be seen the item related to the result.\u0027",
  "id": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Happy Scenario",
  "description": "",
  "id": ";happy-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "that I have gone to \"https://www.google.com/\" page with chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I fill \u003cquery\u003e to the search box",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on suggest \u003csuggest\u003e word",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The \"\u003csuggest\u003e\" should be mentioned in the results",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "close browsers",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": ";happy-scenario;",
  "rows": [
    {
      "cells": [
        "query",
        "suggest"
      ],
      "line": 12,
      "id": ";happy-scenario;;1"
    },
    {
      "cells": [
        "python",
        "python online"
      ],
      "line": 13,
      "id": ";happy-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Happy Scenario",
  "description": "",
  "id": ";happy-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "that I have gone to \"https://www.google.com/\" page with chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I fill python to the search box",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on suggest python online word",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The \"python online\" should be mentioned in the results",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "close browsers",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.google.com/",
      "offset": 21
    }
  ],
  "location": "SearchEngine.that_i_have_gone_to_something_page_with_chrome_browser(String)"
});
formatter.result({
  "duration": 11445131000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "python",
      "offset": 7
    }
  ],
  "location": "SearchEngine.i_fill_to_the_search_box(String)"
});
formatter.result({
  "duration": 266786300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "python online",
      "offset": 17
    }
  ],
  "location": "SearchEngine.click_on_suggest_word(String)"
});
formatter.result({
  "duration": 7267331900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "python online",
      "offset": 5
    }
  ],
  "location": "SearchEngine.the_should_be_mentioned_in_the_results(String)"
});
formatter.result({
  "duration": 7874333100,
  "status": "passed"
});
formatter.match({
  "location": "SearchEngine.close_browsers()"
});
formatter.result({
  "duration": 2027606900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 15,
  "name": "Negative Scenario",
  "description": "",
  "id": ";negative-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 16,
  "name": "that I have gone to \"https://www.google.com/\" page with chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I fill \u003cquery\u003e to the search box",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Click the Search Button",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "The \"\u003cquery\u003e\" should not be mentioned in the results",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "close browsers",
  "keyword": "And "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": ";negative-scenario;",
  "rows": [
    {
      "cells": [
        "query"
      ],
      "line": 23,
      "id": ";negative-scenario;;1"
    },
    {
      "cells": [
        "pyhton"
      ],
      "line": 24,
      "id": ";negative-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 24,
  "name": "Negative Scenario",
  "description": "",
  "id": ";negative-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 16,
  "name": "that I have gone to \"https://www.google.com/\" page with chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I fill pyhton to the search box",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Click the Search Button",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "The \"pyhton\" should not be mentioned in the results",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "close browsers",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.google.com/",
      "offset": 21
    }
  ],
  "location": "SearchEngine.that_i_have_gone_to_something_page_with_chrome_browser(String)"
});
formatter.result({
  "duration": 8067935300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "pyhton",
      "offset": 7
    }
  ],
  "location": "SearchEngine.i_fill_to_the_search_box(String)"
});
formatter.result({
  "duration": 182439600,
  "status": "passed"
});
formatter.match({
  "location": "SearchEngine.click_the_Search_Button()"
});
formatter.result({
  "duration": 5795297300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "pyhton",
      "offset": 5
    }
  ],
  "location": "SearchEngine.the_should_not_be_mentioned_in_the_results(String)"
});
formatter.result({
  "duration": 197208300,
  "status": "passed"
});
formatter.match({
  "location": "SearchEngine.close_browsers()"
});
formatter.result({
  "duration": 1845476400,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "E2E Scenario",
  "description": "",
  "id": ";e2e-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "that I have gone to \"https://www.google.com/\" page with chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "I fill \u003cquery\u003e to the search box",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Click on suggest \u003csuggest\u003e word",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "The \"\u003csuggest\u003e\" should be mentioned in the results",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "click the link \u003clink\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "close browsers",
  "keyword": "And "
});
formatter.examples({
  "line": 34,
  "name": "",
  "description": "",
  "id": ";e2e-scenario;",
  "rows": [
    {
      "cells": [
        "query",
        "suggest",
        "link"
      ],
      "line": 35,
      "id": ";e2e-scenario;;1"
    },
    {
      "cells": [
        "python",
        "python",
        "Python For Beginners"
      ],
      "line": 36,
      "id": ";e2e-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 36,
  "name": "E2E Scenario",
  "description": "",
  "id": ";e2e-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "that I have gone to \"https://www.google.com/\" page with chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "I fill python to the search box",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Click on suggest python word",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "The \"python\" should be mentioned in the results",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "click the link Python For Beginners",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "close browsers",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.google.com/",
      "offset": 21
    }
  ],
  "location": "SearchEngine.that_i_have_gone_to_something_page_with_chrome_browser(String)"
});
formatter.result({
  "duration": 8282583200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "python",
      "offset": 7
    }
  ],
  "location": "SearchEngine.i_fill_to_the_search_box(String)"
});
formatter.result({
  "duration": 444504800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "python",
      "offset": 17
    }
  ],
  "location": "SearchEngine.click_on_suggest_word(String)"
});
formatter.result({
  "duration": 8068192200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "python",
      "offset": 5
    }
  ],
  "location": "SearchEngine.the_should_be_mentioned_in_the_results(String)"
});
formatter.result({
  "duration": 1127299400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Python For Beginners",
      "offset": 15
    }
  ],
  "location": "SearchEngine.click_the_link(String)"
});
formatter.result({
  "duration": 376494500,
  "status": "passed"
});
formatter.match({
  "location": "SearchEngine.close_browsers()"
});
formatter.result({
  "duration": 1942700600,
  "status": "passed"
});
});