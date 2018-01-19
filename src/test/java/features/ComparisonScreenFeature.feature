Feature: Verify Comparison Sceen
  I want verif the comparison screen pages

  Scenario: inbound offered packages
    Given application is launched
    When Complete a checkOut for inbound purchase with the following data
      | noOfTravelleres | destinationCounry | residentCountryName | tripStartDate | tripReturnDate | agesSaparatedbyComma |
      |               3 | United States     | United Kingdom      | 11/13/2017    | 12/15/2017     |             30,20,40 |
    Then Verify Offered Package
      | verifyText            | coverageAmountText                 | deductibleText    | extremeSportsCoverageText | tripCancellationText       |
      | SafeTrip - Comparison | Medical / Accident Coverage amount | Deductible amount | Extreme sports coverage   | Trip cancellation coverage |

        #Scenario: inbound offered packages2
    #Given application is launched
    #When Complete a checkOut for inbound purchase with the following data
      #| noOfTravelleres | destinationCounry | residentCountryName | tripStartDate | tripReturnDate | agesSaparatedbyComma |
      #|               3 | United States     | United Kingdom      | 11/13/2017    | 12/15/2017     |             30,20,40 |
    #Then Verify Offered Package
      #| verifyText            | coverageAmountText                 | deductibleText    | extremeSportsCoverageText | tripCancellationText       |
      #| SafeTrip - Comparison | Medical / Accident Coverage amount | Deductible amount | Extreme sports coverage   | Trip cancellation coverage |
      #
      #
        #Scenario: inbound offered packages3
    #Given application is launched
    #When Complete a checkOut for inbound purchase with the following data
      #| noOfTravelleres | destinationCounry | residentCountryName | tripStartDate | tripReturnDate | agesSaparatedbyComma |
      #|               3 | United States     | United Kingdom      | 11/13/2017    | 12/15/2017     |             30,20,40 |
    #Then Verify Offered Package
      #| verifyText            | coverageAmountText                 | deductibleText    | extremeSportsCoverageText | tripCancellationText       |
      #| SafeTrip - Comparison | Medical / Accident Coverage amount | Deductible amount | Extreme sports coverage   | Trip cancellation coverage |
      #
      #
        #Scenario: inbound offered packages4
    #Given application is launched
    #When Complete a checkOut for inbound purchase with the following data
      #| noOfTravelleres | destinationCounry | residentCountryName | tripStartDate | tripReturnDate | agesSaparatedbyComma |
      #|               3 | United States     | United Kingdom      | 11/13/2017    | 12/15/2017     |             30,20,40 |
    #Then Verify Offered Package
      #| verifyText            | coverageAmountText                 | deductibleText    | extremeSportsCoverageText | tripCancellationText       |
      #| SafeTrip - Comparison | Medical / Accident Coverage amount | Deductible amount | Extreme sports coverage   | Trip cancellation coverage |
      