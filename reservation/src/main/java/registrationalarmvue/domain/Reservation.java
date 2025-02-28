package registrationalarmvue.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import registrationalarmvue.ReservationApplication;
import registrationalarmvue.domain.ReservationCreated;
import registrationalarmvue.domain.ReservationDeleted;
import registrationalarmvue.domain.ReservationUpdated;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    private String taskId;

    private String userId;

    private String title;

    private String description;

    private Date dueDate;

    @PostPersist
    public void onPostPersist() {
        ReservationCreated reservationCreated = new ReservationCreated(this);
        reservationCreated.publishAfterCommit();

        ReservationUpdated reservationUpdated = new ReservationUpdated(this);
        reservationUpdated.publishAfterCommit();

        ReservationDeleted reservationDeleted = new ReservationDeleted(this);
        reservationDeleted.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
//>>> DDD / Aggregate Root
