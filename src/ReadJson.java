import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Program for print data in JSON format.
    public class ReadJson {
        public static void main(String args[]) throws ParseException {
            // In java JSONObject is used to create JSON object
            // which is a subclass of java.util.HashMap.

            JSONObject file = new JSONObject();
            file.put("Full Name", "Ritu Sharma");
            file.put("Roll No.", new Integer(1704310046));
            file.put("Tution Fees", new Double(65400));


            // To print in JSON format.
            System.out.print(file.get("Tution Fees"));
           pull();

        }

        public static void pull() throws ParseException {
            String output = "abc";
            String totlaJson="";
            try {
                System.out.println("pull");
                URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");



                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));


                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    totlaJson+=output;
                }

                conn.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONParser parser = new JSONParser();
            //System.out.println(str);
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totlaJson);
            System.out.println(jsonObject);

            try {


                org.json.simple.JSONArray msg = (org.json.simple.JSONArray) jsonObject.get("films");
                int n =   msg.size(); //(msg).length();
                for (int i = 0; i < n; ++i) {
                    String test =(String) msg.get(i);
                    System.out.println(test);
                   // System.out.println(person.getInt("key"));
                }
                String name= (String)jsonObject.get("height");
                System.out.println(name);


            }

            catch (Exception e) {
                e.printStackTrace();
            }




        }
    }

