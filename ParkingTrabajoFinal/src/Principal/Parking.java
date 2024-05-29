package Principal;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Parking {
    private ArrayList<String> matriculas;
    private ArrayList<Instant> tiemposDeEntrada;
    private String nombre;

    public Parking(String nombre, int numLugar) {
        this.nombre = nombre;
        this.matriculas = new ArrayList<>(numLugar);
        this.tiemposDeEntrada = new ArrayList<>(numLugar);
        for (int i = 0; i < numLugar; i++) {
            matriculas.add(null);
            tiemposDeEntrada.add(null);
        }
    }

    public int getLugaresTotales() {
        return matriculas.size();
    }

    public int getLugaresOcupados() {
        int ocupadas = 0;
        for (String matricula : matriculas) {
            if (matricula != null) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public int getLugaresLibres() {
        return getLugaresTotales() - getLugaresOcupados();
    }

    public String getNombre() {
        return nombre;
    }

    public void entrada(String matricula, int lugar) throws ParkingException {
        if (matricula == null || matricula.length() < 4) {
            throw new ParkingException("Matrícula incorrecta", matricula);
        }
        if (lugar < 0 || lugar >= matriculas.size() || matriculas.get(lugar) != null) {
            throw new ParkingException("Lugar ocupado", matricula);
        }
        if (matriculas.contains(matricula)) {
            throw new ParkingException("Matrícula repetida", matricula);
        }
        matriculas.set(lugar, matricula);
        tiemposDeEntrada.set(lugar, Instant.now());
    }

    public int salida(String matricula) throws ParkingException {
        int lugar = matriculas.indexOf(matricula);
        if (lugar == -1) {
            throw new ParkingException("La Matrícula no existe", matricula);
        }
        Duration tiempoEstacionado = getTiempoEstacionado(lugar);
        double cobro = Math.floor(calcularCobro(tiempoEstacionado));
        if(cobro < 3000){
            cobro = 3000.0;
        }
        String mensaje =    "------------------------ Plaza #"+(lugar+1)+" ------------------------"+"\n" +
                            "Placa: "+matricula+"\n" +
                            "Tiempo estacionado: " + formatDuration(tiempoEstacionado) + "\n" + 
                            "Cobro: $"+cobro;
        JOptionPane.showMessageDialog(null, mensaje);
        matriculas.set(lugar, null);
        tiemposDeEntrada.set(lugar, null);
        return lugar;
    }

    public double calcularCobro(Duration duration){
        double segundos = duration.getSeconds();
        return (segundos * 3000)/3600;
    }

    private Duration getTiempoEstacionado(int lugar){
        Instant entrada = tiemposDeEntrada.get(lugar);
        Instant salida = Instant.now();
        Duration duracion = Duration.between(entrada, salida);
        return duracion;
    }

    private String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
            "%d horas, %d minutos, %d segundos",
            absSeconds / 3600,
            (absSeconds % 3600) / 60,
            absSeconds % 60);
    
        if (seconds < 0) {
            return "-" + positive;
        } else {
            return positive;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------- ").append(nombre).append(" ----------------------------------------------\n");
        for (int i = 0; i < matriculas.size(); i++) {
            sb.append("Plaza ").append(i + 1).append(": ");
            if (matriculas.get(i) == null) {
                sb.append("(vacío) - Tiempo estacionado: N/A\n");
            } else {
                sb.append(matriculas.get(i));
                Instant entrada = tiemposDeEntrada.get(i);
                if (entrada != null) {
                    Duration duracion = Duration.between(entrada, Instant.now());
                    sb.append(" - Tiempo estacionado: ").append(formatDuration(duracion)).append("\n");
                }
            }
        }
        sb.append("---------------------------------------------------------------------------------------------------------------\n");
        return sb.toString();
    }
}