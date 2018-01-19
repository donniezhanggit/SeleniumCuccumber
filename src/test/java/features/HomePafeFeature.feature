Feature: Verify Home Sceen
  I want verif the Home screen pages

  Scenario: Home Page Scenario
    Given application is launched1
    When Complete a checkOut for inbound purchase with the following data1
      | noOfTravelleres | destinationCounry | residentCountryName | tripStartDate | tripReturnDate | agesSaparatedbyComma |
      |               3 | United States     | United Kingdom      | 11/13/2017    | 12/15/2017     |             30,20,40 |
    Then Verify Offered Package1
      | verifyText            | coverageAmountText                 | deductibleText    | extremeSportsCoverageText | tripCancellationText       |
      | SafeTrip - Comparison | Medical / Accident Coverage amount | Deductible amount | Extreme sports coverage   | Trip cancellation coverage |

        #Scenario:Home Page Scenario2
    #Given application is launched
    #When Complete a checkOut for inbound purchase with the following data
      #| noOfTravelleres | destinationCounry | residentCountryName | tripStartDate | tripReturnDate | agesSaparatedbyComma |
      #|               3 | United States     | United Kingdom      | 11/13/2017    | 12/15/2017     |             30,20,40 |
    #Then Verify Offered Package
      #| verifyText            | coverageAmountText                 | deductibleText    | extremeSportsCoverageText | tripCancellationText       |
      #| SafeTrip - Comparison | Medical / Accident Coverage amount | Deductible amount | Extreme sports coverage   | Trip cancellation coverage |
      #
      #
   