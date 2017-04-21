

import java.net.*;
import java.io.*;
import java.util.*;

class ClienteFecha {
  public static void main( String[] args ) {
    String servidor = "ntp.shoa.cl";
    int puerto = 13;             // puerto de daytime

    try {
      // Se abre un socket conectado al servidor y al
      // puerto estándar de echo
      Socket socket = new Socket( servidor,puerto );
      System.out.println( "Socket Abierto." );

      // Se consigue el canal de entrada
      BufferedReader entrada = new BufferedReader(
        new InputStreamReader( socket.getInputStream() ) );

      System.out.println( "Hora actual en localhost:" );
      System.out.println( "\t"+entrada.readLine() );
      System.out.println( "Hora actual con la clase date:" );
      System.out.println( "\t" + new Date() );

      // Se cierra el canal de entrada
      entrada.close();

      // Se cierra el socket
      socket.close();
    } catch( UnknownHostException e ) {
      System.out.println( e );
      System.out.println(
        "Debes estar conectado para que esto funcione bien." );
    } catch( IOException e ) {
      System.out.println( e );
      }
    }
  }
