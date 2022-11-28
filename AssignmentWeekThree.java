import edu.duke.*;
import org.apache.commons.csv.*;

/**
* 
* @author: Amir Armion 
* 
* @version: V.01
* 
*/
public class AssignmentWeekThree 
{

    public String countryInfo(CSVParser parser, String country)
    {
        String info = "";

        for(CSVRecord record: parser)
        {
            String countryName = record.get("Country");

            if(countryName.equalsIgnoreCase(country))
            {

                info = countryName + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        
        if(info.length() == 0)
        {
            return "NOT FOUND!";
        }
        
        return info;
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
        for(CSVRecord record: parser)
        {
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem)
    {
        int count = 0;

        for(CSVRecord record: parser)
        {
            if(record.get("Exports").contains(exportItem))
            {
                count++;
            }
        }

        return count;
    }

    public void bigExporters(CSVParser parser, String amount)
    {
        for(CSVRecord record: parser)
        {
            String value = record.get("Value (dollars)");

            if((value.length() - 1) > amount.length())
            {

                System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            }
        }
    }

    public void tester()
    {
        FileResource file   = new FileResource();
        CSVParser    parser = file.getCSVParser();

        //System.out.println(countryInfo(parser, "Nauru"));

        //listExportersTwoProducts(parser, "cotton", "flowers");

        //System.out.println(numberOfExporters(parser, "cocoa"));

        bigExporters(parser, "$999,999,999,999");
    }
}
