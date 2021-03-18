package a2;

import java.io.*;
import java.net.URL;

/**
 * Created by jordi on 23/02/17.
 * Genera un fitxer blog.xml amb els títols del blod del puig
 * I mostra dades de la URL
 */

public class ExampleURL {
    public static void main(String[] args) throws IOException {
        URL web = new URL("https://blog.elpuig.xeill.net/?feed=rss2");
        System.out.println("Autoritat:\t"+web.getAuthority());
        System.out.println("Port per defecte:\t"+web.getDefaultPort());
        System.out.println("Recurs:\t"+web.getFile());
        System.out.println("Host:\t"+web.getHost());
        System.out.println("Camí:\t"+web.getPath());
        System.out.println("Protocol:\t"+web.getProtocol());

        web.openConnection();

        BufferedReader in = new BufferedReader( new InputStreamReader(web.openStream()));

        File f = new File("blog.xml");
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(f));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.contains("<title>")) {
                System.out.println(inputLine);
                bw.write(inputLine + "\n");
            }
        }
        bw.close();
        in.close();

    }
}
