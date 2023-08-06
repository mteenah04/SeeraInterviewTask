import java.time.LocalDate;
import java.util.Random;


public class ApiReader {
    public static String randomCountryISO3Generator() {
        Random random = new Random();
        String[] ISO3 = {"BAH", "JED", " DXB", "AMM", "CAI", "BEY"};
        return ISO3[random.nextInt(6)];
    }

    public static String[] getTwoFutureDates(){
        LocalDate currentDate = LocalDate.now().plusDays(1);
        String formattedDate = currentDate.toString();
        LocalDate nextDayDate = currentDate.plusDays(1);
        String formattedNextDayDate = nextDayDate.toString();
        String[] dates = {formattedDate, formattedNextDayDate};
        return dates;
    }

    public static String readFaresCalenderApiBody() {

        String originId = randomCountryISO3Generator();
        String destinationId = randomCountryISO3Generator();
        String arrayDates[] = {getTwoFutureDates()[0], getTwoFutureDates()[1]};
        return "{\"leg\":[{\"originId\":\"" + originId + "\",\"destinationId\":\"" + destinationId + "\",\"departureFrom\":\"" + arrayDates[0] + "\",\"departureTo\":\"" + arrayDates[1] + "\"},{\"originId\":\"" + destinationId + "\",\"destinationId\":\"" + originId + "\",\"departureFrom\":\"" + arrayDates[0] + "\",\"departureTo\":\"" + arrayDates[1] + "\"}],\"cabin\":\"Economy\",\"pax\":{\"adult\":1,\"child\":0,\"infant\":0},\"stops\":[],\"airline\":[],\"timeSlots\":{},\"airports\":{}}";
    }

    public static String readCountryListApiSchema() {
        return "{\n" + "    \"$schema\": \"http://json-schema.org/draft-06/schema#\",\n" + "    \"type\": \"array\",\n" + "    \"items\": {\n" + "        \"$ref\": \"#/definitions/Welcome2Element\"\n" + "    },\n" + "    \"definitions\": {\n" + "        \"Welcome2Element\": {\n" + "            \"type\": \"object\",\n" + "            \"additionalProperties\": false,\n" + "            \"properties\": {\n" + "                \"Code\": {\n" + "                    \"type\": \"string\"\n" + "                },\n" + "                \"ISOCode\": {\n" + "                    \"type\": \"string\"\n" + "                },\n" + "                \"Label\": {\n" + "                    \"type\": \"array\",\n" + "                    \"items\": {\n" + "                        \"$ref\": \"#/definitions/Label\"\n" + "                    }\n" + "                },\n" + "                \"DialCode\": {\n" + "                    \"type\": \"string\"\n" + "                }\n" + "            },\n" + "            \"required\": [\n" + "                \"Code\",\n" + "                \"DialCode\",\n" + "                \"ISOCode\",\n" + "                \"Label\"\n" + "            ],\n" + "            \"title\": \"Welcome2Element\"\n" + "        },\n" + "        \"Label\": {\n" + "            \"type\": \"object\",\n" + "            \"additionalProperties\": false,\n" + "            \"properties\": {\n" + "                \"Locale\": {\n" + "                    \"$ref\": \"#/definitions/Locale\"\n" + "                },\n" + "                \"Value\": {\n" + "                    \"type\": \"string\"\n" + "                }\n" + "            },\n" + "            \"required\": [\n" + "                \"Locale\",\n" + "                \"Value\"\n" + "            ],\n" + "            \"title\": \"Label\"\n" + "        },\n" + "        \"Locale\": {\n" + "            \"type\": \"string\",\n" + "            \"enum\": [\n" + "                \"en-us\",\n" + "                \"ar-sa\"\n" + "            ],\n" + "            \"title\": \"Locale\"\n" + "        }\n" + "    }\n" + "}\n";
    }
}
