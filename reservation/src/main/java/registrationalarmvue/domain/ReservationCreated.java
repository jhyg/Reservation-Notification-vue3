package registrationalarmvue.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import registrationalarmvue.domain.*;
import registrationalarmvue.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReservationCreated extends AbstractEvent {

    private String taskId;
    private String userId;
    private String title;
    private String description;
    private Date dueDate;

    public ReservationCreated(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationCreated() {
        super();
    }
}
//>>> DDD / Domain Event
