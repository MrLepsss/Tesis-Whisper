import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EjecutarPython {
    public static void main(String[] args) {
        try {
            // Especifica el comando y el script de Python a ejecutar
            String pythonScriptPath = "C:\\Users\\USUARIO\\Desktop\\Prueba\\R.py";
            ProcessBuilder pb = new ProcessBuilder("python", pythonScriptPath);
            Process process = pb.start();

            // Lee la salida del script de Python
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String s;
            System.out.println("Salida del script de Python:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println("Errores (si los hay):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            // Espera a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("El script de Python terminó con el código: " + exitCode);
        } catch (IOException e) {
            System.out.println("Excepción de E/S");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido");
            e.printStackTrace();
        }
    }
}
