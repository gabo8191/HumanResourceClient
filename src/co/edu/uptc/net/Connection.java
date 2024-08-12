package co.edu.uptc.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Connection {
  public final static String HOST = "localhost";
  public final static int PORT = 1234;
  private Socket socket;
  private DataInputStream input;
  private DataOutputStream output;

  public Connection() {
    try {
      socket = new Socket(HOST, PORT);
      input = new DataInputStream(socket.getInputStream());
      output = new DataOutputStream(socket.getOutputStream());
    } catch (Exception e) {
      System.err.println("Error al crear el socket del cliente.");
    }
  }

  public void send(String message) {
    try {
      output.writeUTF(message);
    } catch (Exception e) {
      System.err.println("Error al enviar datos al servidor.");
    }
  }

  public String receive() {
    try {
      return input.readUTF();
    } catch (Exception e) {
      System.err.println("Error al recibir datos del servidor.");
    }
    return null;
  }

  public void close() {
    try {
      if (socket != null)
        socket.close();
    } catch (Exception e) {
      System.err.println("Error al cerrar el socket del cliente.");
    }
  }

}
