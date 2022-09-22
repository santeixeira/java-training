package controller;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Relogio {
    public Date tempo;

    public Relogio(Date tempo) {
        this.tempo = tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public Date getTempo() {
        return tempo;
    }

    public void inicializar() {
        SimpleDateFormat datef = new SimpleDateFormat("hh:mm:ss");
        Date now = new Date();
        System.out.println("Horário de início: " + datef.format(now));
    }
}
