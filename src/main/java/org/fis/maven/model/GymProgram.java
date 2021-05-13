package org.fis.maven.model;
import org.dizitart.no2.objects.Id;
import java.util.Objects;
public class GymProgram {
    @Id
    private String Antrenament;
    private String Ziua;
    private String Ora;
    private String Descriere;

    public GymProgram(String Antrenament, String Ziua, String Ora, String Descriere) {
        this.Antrenament = Antrenament;
        this.Ziua = Ziua;
        this.Ora = Ora;
        this.Descriere = Descriere;

    }
    public GymProgram() {
    }
    public String getAntrenament(){
        return this.Antrenament;
    }
    public String getZiua(){
        return this.Ziua;
    }
    public String getOra(){
        return this.Ora;
    }
    public String getDescriere(){
        return this.Descriere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymProgram gymProgram = (GymProgram) o;
        if (!Objects.equals(Antrenament, gymProgram.Antrenament)) return false;
        if (!Objects.equals(Ziua, gymProgram.Ziua)) return false;
        if (!Objects.equals(Ora, gymProgram.Ora)) return false;
        if (!Objects.equals(Descriere, gymProgram.Descriere)) return false;
        return true;
    }

}