package a1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Form {
    public static void main(String[] args) {

        String Parameters = "entry.835030737=Jordi&entry.1616686619=No";

        String request = "https://docs.google.com/forms/d/e/1FAIpQLScE6sxLFb3BmCmT2TKHQH5ormS0qvjHwO-uTAR8MXaagBvSSQ/formResponse";


        for(int i=0; i<1; i++){
            Form.excutePost(request, Parameters);
            try {
                Thread.sleep(10);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    private static void excutePost(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close ();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
           /* String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
                System.out.println(response.toString());
            }*/
            rd.close();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }

}
