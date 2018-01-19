package safetrip.core.business.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import safetrip.core.generic.utilities.AutomationCore;



public class QuoteCalculation extends AutomationCore{

	public String tripType = null;
	public static void main(String[] args) {
		
		QuoteCalculation obj = new QuoteCalculation();
		obj.quoteCalculation("5", "United States", "India", "07/10/2017", "08/20/2017", "80,69,40,70,25", "0", "250000", "0", "No");

		
	}
	public String getTripType(String destinationCountryName, String residenceCountryName, String startDate, String endDate)
	{
		try {
			
			if(residenceCountryName.trim().toUpperCase().equals("UNITED STATES") && !destinationCountryName.trim().toUpperCase().equals("UNITED STATES"))
			{
				tripType = "OUTBOUND";
				
				if(getDateDifff(startDate, endDate)>360)
				{
					tripType = "AFT";
				}
				
			}else if(!residenceCountryName.trim().toUpperCase().equals("UNITED STATES") && destinationCountryName.trim().toUpperCase().equals("UNITED STATES"))
			{
				tripType = "INBOUND";
			}
			else if(!residenceCountryName.trim().toUpperCase().equals("UNITED STATES") && !destinationCountryName.trim().toUpperCase().equals("UNITED STATES"))
			{
				tripType = "TRANSNATIONAL";
			}
			
			return tripType;
		}catch(Exception e)
		{
			
		}
		return tripType;
	}
	
	
	public Map<String, String> quoteCalculation(String noOfTravelers, String destinationCountryName, String residenceCountryName, String startDate, String returnDate, String agesSaperatedByComma, String tripCancellationAmount, String medicalLimit, String deductible, String sportsRider )
	{
		Workbook workBook = null;
		String ages[]  = agesSaperatedByComma.split(",");
		 double dailyPrmiumRate = 0.00;
		 double sportsRiderRate = 0.00;
		 double deductibleRate = 0.00;
		 double tripCancellationRate = 0.00;
		 double totalTripCost = 0.00;
		 double tripCostPerTraveler = 0.00;
		 int tripCancellationPerTraveler = 0;
		 
		 String totalCostInTwoDecimals = null;
		 String finalTotalCost = null;
		 
		 Map<String, String> costDetails = new HashMap<String, String>();
		 
		try {
		//*-------------------Fetching Product Info From sheet-------------------------*//Environment("testDataFilePath") Product Info
			FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+Environment("testDataFilePath"));
			 workBook = new XSSFWorkbook(fileInputStream);
			 
		
			 
			 int age = 0;
			 int travelDays = 1;
			 
			 tripType = getTripType(destinationCountryName, residenceCountryName, startDate, returnDate);
			 
			 if(tripType.equals("AFT"))
			 {
				 travelDays = 1;
			 }else {
			 travelDays = getDateDifff(startDate, returnDate);
			 }
			 
			 System.out.println("travelDayss2 = "+travelDays);
			 tripCancellationPerTraveler = (Integer.parseInt(tripCancellationAmount))/Integer.parseInt(noOfTravelers);
			 
			 
			 for(int i = 0; i<=ages.length-1;i++)
			 {
				age = Integer.parseInt(ages[i].trim()); 
				dailyPrmiumRate = getDailyRatefromProductSheet(workBook, age, destinationCountryName, residenceCountryName, medicalLimit, startDate, returnDate);
				System.out.println("Age: "+age+" DailyPremiumRate: "+dailyPrmiumRate);
				deductibleRate = getDeductible(workBook, destinationCountryName, residenceCountryName, deductible, startDate, returnDate);
				sportsRiderRate = getSportsRiderRate(workBook, destinationCountryName, residenceCountryName, age, startDate, returnDate, sportsRider);
				tripCancellationRate = getTripCancellationRatePercentage(workBook, destinationCountryName, residenceCountryName, age, startDate, returnDate);
				
				tripCostPerTraveler = (dailyPrmiumRate*travelDays)+((dailyPrmiumRate*travelDays)*(deductibleRate))+
						((dailyPrmiumRate*travelDays)*(sportsRiderRate))+ (tripCancellationPerTraveler)*(tripCancellationRate);
				
				System.out.println("The Actual cost per traveler"+tripCostPerTraveler);
				
				tripCostPerTraveler =  Math.round(tripCostPerTraveler * 100D) / 100D;		
					
				totalTripCost = totalTripCost+tripCostPerTraveler;
				
				String tripCostPerTravelerString = Double.toString(tripCostPerTraveler)+"000000";
				costDetails.put("Traveler "+(i+1), tripCostPerTravelerString.substring(0, tripCostPerTravelerString.indexOf('.')+3));
				
				System.out.println("Trip cost for each traveler "+tripCostPerTravelerString.substring(0, tripCostPerTravelerString.indexOf('.')+3));
				
			 }

			 totalTripCost = (double) Math.round(totalTripCost * 100D) / 100D;
			
			 
			 System.out.println(totalTripCost);
		
			 totalCostInTwoDecimals = 	Double.toString(totalTripCost)+"0000000";
			 totalCostInTwoDecimals.indexOf('.');
			 
			 finalTotalCost =  totalCostInTwoDecimals.substring(0, totalCostInTwoDecimals.indexOf('.')+3);
			 costDetails.put("Total Cost", finalTotalCost);
		
		System.out.println("final costv e= "+finalTotalCost);
		
		}catch(Exception e)
		{
			try {
				workBook.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			workBook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return costDetails ;
	}
	
	public double getDailyRatefromProductSheet(Workbook workBook, int age, String destinationCountryName, String residenceCountryName, String medicalLimit, String startDate, String endDate)
	{
		//String tripType = null;
		double dailyRateInt = 0;
		try {
				
			tripType = getTripType(destinationCountryName, residenceCountryName,  startDate,  endDate);

			
				switch(tripType)
				{
				case "OUTBOUND":
				{
				if(isBetween(0, age, 17) )
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(7).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(7).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(7).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(18, age, 29))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =  workBook.getSheet("Product Info").getRow(9).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt = workBook.getSheet("Product Info").getRow(9).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(9).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(30, age, 39))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(10).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(10).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(10).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(40, age, 49))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(50, age, 59))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(60, age, 64))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(13).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(13).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(13).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(65, age, 69))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(14).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(14).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(14).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(70, age, 79))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(15).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(15).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(15).getCell(4).getNumericCellValue();
						break;
					}
				}
				else if(isBetween(80, age, 85))
				{
					switch(Integer.parseInt(medicalLimit)) 
					{
					case 100000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(16).getCell(2).getNumericCellValue();
						break;
					case 500000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(16).getCell(3).getNumericCellValue();
						break;
					case 1000000:
						dailyRateInt =   workBook.getSheet("Product Info").getRow(16).getCell(4).getNumericCellValue();
						break;
					}
				}
				break;
				}
				
				case "INBOUND":
				{
					if(isBetween(0, age, 17) )
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(7).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(7).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(18, age, 29))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(9).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(9).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(30, age, 39))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(10).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(10).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(40, age, 49))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(50, age, 59))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(60, age, 64))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(13).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(13).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(65, age, 69))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(14).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(14).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(70, age, 79))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(15).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(15).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(80, age, 85))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(16).getCell(14).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(16).getCell(15).getNumericCellValue();
							break;
						
						}
					}
					break;
				}
				
				case "TRANSNATIONAL":
				{
					if(isBetween(0, age, 17) )
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(7).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(7).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(18, age, 29))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =workBook.getSheet("Product Info").getRow(9).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(9).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(30, age, 39))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(10).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(10).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(40, age, 49))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(50, age, 59))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(60, age, 64))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(13).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(13).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(65, age, 69))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(14).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(14).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(70, age, 79))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(15).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(15).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					else if(isBetween(80, age, 85))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(16).getCell(20).getNumericCellValue();
							break;
						case 250000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(16).getCell(21).getNumericCellValue();
							break;
						
						}
					}
					break;
				}
				
				case "AFT":
				{
					if(isBetween(0, age, 69) )
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(8).getNumericCellValue();
							break;
						case 500000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(9).getNumericCellValue();
							break;
						case 1000000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(11).getCell(10).getNumericCellValue();
							break;
						}
					}
					else if(isBetween(70, age, 79))
					{
						switch(Integer.parseInt(medicalLimit)) 
						{
						case 100000:
							dailyRateInt =  workBook.getSheet("Product Info").getRow(12).getCell(8).getNumericCellValue();
							break;
						case 500000:
							dailyRateInt = workBook.getSheet("Product Info").getRow(12).getCell(9).getNumericCellValue();
							break;
						case 1000000:
							dailyRateInt =   workBook.getSheet("Product Info").getRow(12).getCell(10).getNumericCellValue();
							break;
						}
					}
					break;
				}
			}
			
			return dailyRateInt;
			
		}catch(Exception e)
		{
			System.out.println(e.getClass().getName());
			//return 0;
		}
		return dailyRateInt;
	}
	
	public double getDeductible(Workbook workBook, String destinationCountryName, String residenceCountryName, String deductible, String startDate, String endDate)
	{
		//Map<String, Double> deductibleMap = new HashMap<String, Double>();
		//String tripType = null;
		double deductiblePercentage = 0.00;
		try {
			
			tripType = getTripType(destinationCountryName, residenceCountryName, startDate,  endDate);
			
			switch(tripType)
			{
			case "OUTBOUND":
			{
				switch(Integer.parseInt(deductible.trim()))
				{
				case 0:
				{
					deductiblePercentage =  workBook.getSheet("Product Info").getRow(22).getCell(4).getNumericCellValue();
//					deductibleMap.put("Rate",  workBook.getSheet("Product Info").getRow(22).getCell(3).getNumericCellValue());
//					deductibleMap.put("Percentage",  workBook.getSheet("Product Info").getRow(22).getCell(4).getNumericCellValue());
					break;
				}
				case 100:
				{
					deductiblePercentage = workBook.getSheet("Product Info").getRow(23).getCell(4).getNumericCellValue();
//					deductibleMap.put("Rate",  workBook.getSheet("Product Info").getRow(23).getCell(3).getNumericCellValue());
//					deductibleMap.put("Percentage",  workBook.getSheet("Product Info").getRow(23).getCell(4).getNumericCellValue());
					break;
				}
				case 250:
				{
					deductiblePercentage = 0;
//					deductibleMap.put("Rate", 1.0);
//					deductibleMap.put("Percentage", 1.0);
					break;
				}
				}
				break;
			}
			case "INBOUND":
			{
				switch(Integer.parseInt(deductible.trim()))
				{
				case 0:
				{
					deductiblePercentage =  workBook.getSheet("Product Info").getRow(20).getCell(16).getNumericCellValue();
					break;
				}
				case 100:
				{
					deductiblePercentage =  workBook.getSheet("Product Info").getRow(21).getCell(16).getNumericCellValue();
					break;
				}
				case 250:
				{
					deductiblePercentage = 0;
					break;
				}
				}
				break;
			}
			
			case "TRANSNATIONAL":
			{
				switch(Integer.parseInt(deductible.trim()))
				{
				case 0:
				{
					deductiblePercentage =  workBook.getSheet("Product Info").getRow(21).getCell(22).getNumericCellValue();
					break;
				}
				case 100:
				{
					deductiblePercentage = workBook.getSheet("Product Info").getRow(22).getCell(22).getNumericCellValue();
					break;
				}
				case 250:
				{
					deductiblePercentage = 0;
					break;
				}
				}
				break;
			}
			case "AFT":
			{
				switch(Integer.parseInt(deductible.trim()))
				{
				case 0:
				{
					deductiblePercentage =  workBook.getSheet("Product Info").getRow(16).getCell(10).getNumericCellValue();
					break;
				}
				case 100:
				{
					deductiblePercentage = workBook.getSheet("Product Info").getRow(17).getCell(10).getNumericCellValue();
					break;
				}
				case 250:
				{
					deductiblePercentage = 0;
					break;
				}
				}
				break;
			}
		
			}
			return deductiblePercentage;
		}catch(Exception e)
		{
			
		}
		return deductiblePercentage; 
	}
	
	public double getSportsRiderRate(Workbook workBook, String destinationCountryName, String residenceCountryName, int age, String startDate, String endDate, String sportsRiderStatus)
	{
		double sportsRiderPercentage = 0.00;
		try {
			tripType = getTripType(destinationCountryName, residenceCountryName, startDate, endDate);
			if(sportsRiderStatus.toUpperCase().trim().equals("YES"))
			{
			if(isBetween(0, age, 69)) 
			{
				switch(tripType)
				{
				case "OUTBOUND":
					{
						sportsRiderPercentage = workBook.getSheet("Product Info").getRow(24).getCell(4).getNumericCellValue();
						break;
					}
				case "INBOUND":
					{
						sportsRiderPercentage =  workBook.getSheet("Product Info").getRow(22).getCell(16).getNumericCellValue();
						break;
					}
				case "TRANSNATIONAL":
				{
					sportsRiderPercentage =  workBook.getSheet("Product Info").getRow(23).getCell(22).getNumericCellValue();
					break;
				}
				default:
				{
					sportsRiderPercentage = 0;
					break;
				}
				}
				
			}
			}
			return sportsRiderPercentage;
			
		}catch(Exception e)
		{
			
		}
		return sportsRiderPercentage;
	}
	
	public double getTripCancellationRatePercentage(Workbook workBook, String destinationCountryName, String residenceCountryName, int age, String startDate, String endDate)
	{
		tripType = getTripType(destinationCountryName, residenceCountryName, startDate, endDate);
		double tripCanPercentage = 0.00;
		
		try {
			if(tripType.equals("OUTBOUND")) 
			{
				if(isBetween(0, age, 69))
				{
					tripCanPercentage =  workBook.getSheet("Product Info").getRow(27).getCell(4).getNumericCellValue();
					
				}else if(isBetween(70, age, 79))
				{
					tripCanPercentage =  workBook.getSheet("Product Info").getRow(28).getCell(4).getNumericCellValue();
				}else if(isBetween(80, age, 85))
				{
					tripCanPercentage =  workBook.getSheet("Product Info").getRow(29).getCell(4).getNumericCellValue();
				}
			}
			return tripCanPercentage;
			
		}catch(Exception e)
		{
			
		}
		return tripCanPercentage;
	}
	
	
	
	 public  boolean isBetween(int lowerRange, int valueToTest, int upperRange) {
	        return lowerRange <= valueToTest && valueToTest <= upperRange;
	    }
	    
	 public double roundUp(double tripCostPerTraveler)
	 {
		 BigDecimal roundedWithScale = null;
		 BigDecimal bigDecimal = null;
		try {
	         bigDecimal = new BigDecimal(tripCostPerTraveler);
	         roundedWithScale = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
	        System.out.println("Rounded value with setting scale = "+roundedWithScale);
	        
	        return roundedWithScale.doubleValue();
		}catch(Exception e)
		{
			System.out.println(e.getClass().getCanonicalName());
		}
		return roundedWithScale.doubleValue();
	 }
	
	
}
