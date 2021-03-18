package a2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * Created by jordi on 23/02/17.
 */
public class ExempleInetAdress {

    public static void main(String[] args) {
        String a = "nasa.gov";
        InetAddress address = null, ad[];

        try {
            address = InetAddress.getByName(a);
            ad = InetAddress.getAllByName(a);
            System.out.println(address.toString());
            for(InetAddress i : ad) System.out.println(i.toString());
            System.out.println("canonical name: "+ address.getCanonicalHostName());
            System.out.println("name: "+ address.getHostName());
            System.out.println("és loopback? "+ address.isLoopbackAddress());
            System.out.println("localhost: "+ address.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
