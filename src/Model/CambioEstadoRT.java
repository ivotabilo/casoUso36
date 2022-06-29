import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CambioEstadoRT {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CambioEstadoRT_id_seq")
    @SequenceGenerator(name = "CambioEstadoRT_id_seq", sequenceName = "CambioEstadoRT_id_seq", allocationSize = 1)
    private Integer ID;
    
    private Date fecha;
}
