package a5;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ClientVelocimetre {
    private int portDesti;
    private String ipServ;
    private InetAddress adrecaDesti;
    private MulticastSocket multicastSocket;
    private InetAddress multicastIP;

    InetSocketAddress groupMulticast;
    NetworkInterface netIf;
    boolean continueRunning = true;
    int num1,num2,num3,num4,num5, media;
    List<Integer> numeros = new ArrayList<>();

    public ClientVelocimetre(String ip, int port) {
        this.portDesti = port;
        ipServ = ip;
        try {
            multicastSocket = new MulticastSocket(5555);
            multicastIP = InetAddress.getByName("224.0.2.14");
            groupMulticast = new InetSocketAddress(multicastIP, 5555);
            netIf = NetworkInterface.getByName("fe80");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runClient() throws IOException {
        byte[] receivedData = new byte[1024];
        multicastSocket.joinGroup(groupMulticast, netIf);
        while (continueRunning) {
            DatagramPacket mPacket = new DatagramPacket(receivedData, 1024);
            multicastSocket.receive(mPacket);
            ByteBuffer bytebuffer = ByteBuffer.wrap(mPacket.getData());
            int num = bytebuffer.getInt();
            numeros.add(num);

            System.out.println(num);
            if(numeros.size() == 5){
                num1 = numeros.get(0);
                num2 = numeros.get(1);
                num3 = numeros.get(2);
                num4 = numeros.get(3);
                num5 = numeros.get(4);
                media = ((num1 + num2 + num3 + num4 + num5)/5);
                System.out.println("Velocitat mitja: "+media);
                //vaciamos la lista para que no pasen cosas raras
                numeros.clear();
            }
        }
        multicastSocket.leaveGroup(groupMulticast,netIf);
        multicastSocket.close();
    }

    public static void main(String[] args) {
        String ipSrv = "192.168.1.34";
        ClientVelocimetre clientVelocimetre = new ClientVelocimetre(ipSrv, 5557);


        try {
            clientVelocimetre.runClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}